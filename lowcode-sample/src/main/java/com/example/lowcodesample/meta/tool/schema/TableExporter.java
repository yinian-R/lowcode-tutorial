package com.example.lowcodesample.meta.tool.schema;

import com.example.lowcodesample.core.lowcode.Entity;
import com.example.lowcodesample.core.lowcode.MysqlDialect;

import java.util.ArrayList;
import java.util.List;

public class TableExporter {
    
    private MysqlDialect dialect;
    
    public TableExporter() {
        this.dialect = new MysqlDialect();
    }
    
    public String[] getSqlCreateStrings(Entity table) {
        String formattedTableName = dialect.formatTableName(table.getTableName());
        
        StringBuilder buf =
                new StringBuilder(dialect.tableCreateString())
                        .append(' ')
                        .append(formattedTableName)
                        .append(" (");
        
        boolean first = true;
        for (Entity.Properties property : table.getProperties()) {
            if (first) {
                first = false;
            } else {
                buf.append(", ");
            }
            String colName = dialect.getQuotedName(property.getName());
            buf.append(colName).append(" ");
            
            Entity.TypeAnnotation typeAnnotation = property.getTypeAnnotation();
            buf.append(dialect.getSqlType(typeAnnotation, dialect)).append(" ");
            
            if (property.isPrimaryKey()) {
                buf.append(dialect.getIdentityColumnString()).append(" ");
            } else {
                if (property.isRequired()) {
                    buf.append("not null ");
                }
                String defaultValue = property.getDefaultValue();
                if (defaultValue != null) {
                    buf.append("default ").append(defaultValue).append(" ");
                }
            }
            
            String label = property.getLabel();
            if ( label != null ) {
                buf.append( dialect.getColumnComment( label ) );
            }
        }
    
        if (table.hasPrimaryKey()) {
            buf.append(", ")
                    .append(dialect.sqlConstraintString(table.getProperties()));
        }
    
        buf.append(")");
    
        if ( table.getDescription() != null ) {
            buf.append( dialect.getTableComment( table.getDescription() ) );
        }
        
        List<String> sqlList = new ArrayList<>();
        sqlList.add(buf.toString());
        
        // todo add Indexes
        return sqlList.toArray(new String[0]);
    }
    
}
