// ORM class for table 'null'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu Oct 12 06:50:39 PDT 2017
// For connector: com.cloudera.sqoop.teradata.TeradataManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QueryResult extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private Integer SALES_ORDER_LINE_KEY;
  public Integer get_SALES_ORDER_LINE_KEY() {
    return SALES_ORDER_LINE_KEY;
  }
  public void set_SALES_ORDER_LINE_KEY(Integer SALES_ORDER_LINE_KEY) {
    this.SALES_ORDER_LINE_KEY = SALES_ORDER_LINE_KEY;
  }
  public QueryResult with_SALES_ORDER_LINE_KEY(Integer SALES_ORDER_LINE_KEY) {
    this.SALES_ORDER_LINE_KEY = SALES_ORDER_LINE_KEY;
    return this;
  }
  private String BK_AS_PROJECT_CD;
  public String get_BK_AS_PROJECT_CD() {
    return BK_AS_PROJECT_CD;
  }
  public void set_BK_AS_PROJECT_CD(String BK_AS_PROJECT_CD) {
    this.BK_AS_PROJECT_CD = BK_AS_PROJECT_CD;
  }
  public QueryResult with_BK_AS_PROJECT_CD(String BK_AS_PROJECT_CD) {
    this.BK_AS_PROJECT_CD = BK_AS_PROJECT_CD;
    return this;
  }
  private java.math.BigDecimal SOL_AS_PROJECT_REV_AMT;
  public java.math.BigDecimal get_SOL_AS_PROJECT_REV_AMT() {
    return SOL_AS_PROJECT_REV_AMT;
  }
  public void set_SOL_AS_PROJECT_REV_AMT(java.math.BigDecimal SOL_AS_PROJECT_REV_AMT) {
    this.SOL_AS_PROJECT_REV_AMT = SOL_AS_PROJECT_REV_AMT;
  }
  public QueryResult with_SOL_AS_PROJECT_REV_AMT(java.math.BigDecimal SOL_AS_PROJECT_REV_AMT) {
    this.SOL_AS_PROJECT_REV_AMT = SOL_AS_PROJECT_REV_AMT;
    return this;
  }
  private java.sql.Timestamp EDW_CREATE_DTM;
  public java.sql.Timestamp get_EDW_CREATE_DTM() {
    return EDW_CREATE_DTM;
  }
  public void set_EDW_CREATE_DTM(java.sql.Timestamp EDW_CREATE_DTM) {
    this.EDW_CREATE_DTM = EDW_CREATE_DTM;
  }
  public QueryResult with_EDW_CREATE_DTM(java.sql.Timestamp EDW_CREATE_DTM) {
    this.EDW_CREATE_DTM = EDW_CREATE_DTM;
    return this;
  }
  private String EDW_CREATE_USER;
  public String get_EDW_CREATE_USER() {
    return EDW_CREATE_USER;
  }
  public void set_EDW_CREATE_USER(String EDW_CREATE_USER) {
    this.EDW_CREATE_USER = EDW_CREATE_USER;
  }
  public QueryResult with_EDW_CREATE_USER(String EDW_CREATE_USER) {
    this.EDW_CREATE_USER = EDW_CREATE_USER;
    return this;
  }
  private java.sql.Timestamp EDW_UPDATE_DTM;
  public java.sql.Timestamp get_EDW_UPDATE_DTM() {
    return EDW_UPDATE_DTM;
  }
  public void set_EDW_UPDATE_DTM(java.sql.Timestamp EDW_UPDATE_DTM) {
    this.EDW_UPDATE_DTM = EDW_UPDATE_DTM;
  }
  public QueryResult with_EDW_UPDATE_DTM(java.sql.Timestamp EDW_UPDATE_DTM) {
    this.EDW_UPDATE_DTM = EDW_UPDATE_DTM;
    return this;
  }
  private String EDW_UPDATE_USER;
  public String get_EDW_UPDATE_USER() {
    return EDW_UPDATE_USER;
  }
  public void set_EDW_UPDATE_USER(String EDW_UPDATE_USER) {
    this.EDW_UPDATE_USER = EDW_UPDATE_USER;
  }
  public QueryResult with_EDW_UPDATE_USER(String EDW_UPDATE_USER) {
    this.EDW_UPDATE_USER = EDW_UPDATE_USER;
    return this;
  }
  private String ADVNCD_SRVCS_ENGMNT_TYPE_CD;
  public String get_ADVNCD_SRVCS_ENGMNT_TYPE_CD() {
    return ADVNCD_SRVCS_ENGMNT_TYPE_CD;
  }
  public void set_ADVNCD_SRVCS_ENGMNT_TYPE_CD(String ADVNCD_SRVCS_ENGMNT_TYPE_CD) {
    this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = ADVNCD_SRVCS_ENGMNT_TYPE_CD;
  }
  public QueryResult with_ADVNCD_SRVCS_ENGMNT_TYPE_CD(String ADVNCD_SRVCS_ENGMNT_TYPE_CD) {
    this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = ADVNCD_SRVCS_ENGMNT_TYPE_CD;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof QueryResult)) {
      return false;
    }
    QueryResult that = (QueryResult) o;
    boolean equal = true;
    equal = equal && (this.SALES_ORDER_LINE_KEY == null ? that.SALES_ORDER_LINE_KEY == null : this.SALES_ORDER_LINE_KEY.equals(that.SALES_ORDER_LINE_KEY));
    equal = equal && (this.BK_AS_PROJECT_CD == null ? that.BK_AS_PROJECT_CD == null : this.BK_AS_PROJECT_CD.equals(that.BK_AS_PROJECT_CD));
    equal = equal && (this.SOL_AS_PROJECT_REV_AMT == null ? that.SOL_AS_PROJECT_REV_AMT == null : this.SOL_AS_PROJECT_REV_AMT.equals(that.SOL_AS_PROJECT_REV_AMT));
    equal = equal && (this.EDW_CREATE_DTM == null ? that.EDW_CREATE_DTM == null : this.EDW_CREATE_DTM.equals(that.EDW_CREATE_DTM));
    equal = equal && (this.EDW_CREATE_USER == null ? that.EDW_CREATE_USER == null : this.EDW_CREATE_USER.equals(that.EDW_CREATE_USER));
    equal = equal && (this.EDW_UPDATE_DTM == null ? that.EDW_UPDATE_DTM == null : this.EDW_UPDATE_DTM.equals(that.EDW_UPDATE_DTM));
    equal = equal && (this.EDW_UPDATE_USER == null ? that.EDW_UPDATE_USER == null : this.EDW_UPDATE_USER.equals(that.EDW_UPDATE_USER));
    equal = equal && (this.ADVNCD_SRVCS_ENGMNT_TYPE_CD == null ? that.ADVNCD_SRVCS_ENGMNT_TYPE_CD == null : this.ADVNCD_SRVCS_ENGMNT_TYPE_CD.equals(that.ADVNCD_SRVCS_ENGMNT_TYPE_CD));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof QueryResult)) {
      return false;
    }
    QueryResult that = (QueryResult) o;
    boolean equal = true;
    equal = equal && (this.SALES_ORDER_LINE_KEY == null ? that.SALES_ORDER_LINE_KEY == null : this.SALES_ORDER_LINE_KEY.equals(that.SALES_ORDER_LINE_KEY));
    equal = equal && (this.BK_AS_PROJECT_CD == null ? that.BK_AS_PROJECT_CD == null : this.BK_AS_PROJECT_CD.equals(that.BK_AS_PROJECT_CD));
    equal = equal && (this.SOL_AS_PROJECT_REV_AMT == null ? that.SOL_AS_PROJECT_REV_AMT == null : this.SOL_AS_PROJECT_REV_AMT.equals(that.SOL_AS_PROJECT_REV_AMT));
    equal = equal && (this.EDW_CREATE_DTM == null ? that.EDW_CREATE_DTM == null : this.EDW_CREATE_DTM.equals(that.EDW_CREATE_DTM));
    equal = equal && (this.EDW_CREATE_USER == null ? that.EDW_CREATE_USER == null : this.EDW_CREATE_USER.equals(that.EDW_CREATE_USER));
    equal = equal && (this.EDW_UPDATE_DTM == null ? that.EDW_UPDATE_DTM == null : this.EDW_UPDATE_DTM.equals(that.EDW_UPDATE_DTM));
    equal = equal && (this.EDW_UPDATE_USER == null ? that.EDW_UPDATE_USER == null : this.EDW_UPDATE_USER.equals(that.EDW_UPDATE_USER));
    equal = equal && (this.ADVNCD_SRVCS_ENGMNT_TYPE_CD == null ? that.ADVNCD_SRVCS_ENGMNT_TYPE_CD == null : this.ADVNCD_SRVCS_ENGMNT_TYPE_CD.equals(that.ADVNCD_SRVCS_ENGMNT_TYPE_CD));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.SALES_ORDER_LINE_KEY = JdbcWritableBridge.readInteger(1, __dbResults);
    this.BK_AS_PROJECT_CD = JdbcWritableBridge.readString(2, __dbResults);
    this.SOL_AS_PROJECT_REV_AMT = JdbcWritableBridge.readBigDecimal(3, __dbResults);
    this.EDW_CREATE_DTM = JdbcWritableBridge.readTimestamp(4, __dbResults);
    this.EDW_CREATE_USER = JdbcWritableBridge.readString(5, __dbResults);
    this.EDW_UPDATE_DTM = JdbcWritableBridge.readTimestamp(6, __dbResults);
    this.EDW_UPDATE_USER = JdbcWritableBridge.readString(7, __dbResults);
    this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = JdbcWritableBridge.readString(8, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.SALES_ORDER_LINE_KEY = JdbcWritableBridge.readInteger(1, __dbResults);
    this.BK_AS_PROJECT_CD = JdbcWritableBridge.readString(2, __dbResults);
    this.SOL_AS_PROJECT_REV_AMT = JdbcWritableBridge.readBigDecimal(3, __dbResults);
    this.EDW_CREATE_DTM = JdbcWritableBridge.readTimestamp(4, __dbResults);
    this.EDW_CREATE_USER = JdbcWritableBridge.readString(5, __dbResults);
    this.EDW_UPDATE_DTM = JdbcWritableBridge.readTimestamp(6, __dbResults);
    this.EDW_UPDATE_USER = JdbcWritableBridge.readString(7, __dbResults);
    this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = JdbcWritableBridge.readString(8, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(SALES_ORDER_LINE_KEY, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(BK_AS_PROJECT_CD, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(SOL_AS_PROJECT_REV_AMT, 3 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeTimestamp(EDW_CREATE_DTM, 4 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeString(EDW_CREATE_USER, 5 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeTimestamp(EDW_UPDATE_DTM, 6 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeString(EDW_UPDATE_USER, 7 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(ADVNCD_SRVCS_ENGMNT_TYPE_CD, 8 + __off, 12, __dbStmt);
    return 8;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(SALES_ORDER_LINE_KEY, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(BK_AS_PROJECT_CD, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(SOL_AS_PROJECT_REV_AMT, 3 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeTimestamp(EDW_CREATE_DTM, 4 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeString(EDW_CREATE_USER, 5 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeTimestamp(EDW_UPDATE_DTM, 6 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeString(EDW_UPDATE_USER, 7 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(ADVNCD_SRVCS_ENGMNT_TYPE_CD, 8 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.SALES_ORDER_LINE_KEY = null;
    } else {
    this.SALES_ORDER_LINE_KEY = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.BK_AS_PROJECT_CD = null;
    } else {
    this.BK_AS_PROJECT_CD = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.SOL_AS_PROJECT_REV_AMT = null;
    } else {
    this.SOL_AS_PROJECT_REV_AMT = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.EDW_CREATE_DTM = null;
    } else {
    this.EDW_CREATE_DTM = new Timestamp(__dataIn.readLong());
    this.EDW_CREATE_DTM.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.EDW_CREATE_USER = null;
    } else {
    this.EDW_CREATE_USER = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.EDW_UPDATE_DTM = null;
    } else {
    this.EDW_UPDATE_DTM = new Timestamp(__dataIn.readLong());
    this.EDW_UPDATE_DTM.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.EDW_UPDATE_USER = null;
    } else {
    this.EDW_UPDATE_USER = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = null;
    } else {
    this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.SALES_ORDER_LINE_KEY) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.SALES_ORDER_LINE_KEY);
    }
    if (null == this.BK_AS_PROJECT_CD) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, BK_AS_PROJECT_CD);
    }
    if (null == this.SOL_AS_PROJECT_REV_AMT) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.SOL_AS_PROJECT_REV_AMT, __dataOut);
    }
    if (null == this.EDW_CREATE_DTM) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.EDW_CREATE_DTM.getTime());
    __dataOut.writeInt(this.EDW_CREATE_DTM.getNanos());
    }
    if (null == this.EDW_CREATE_USER) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, EDW_CREATE_USER);
    }
    if (null == this.EDW_UPDATE_DTM) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.EDW_UPDATE_DTM.getTime());
    __dataOut.writeInt(this.EDW_UPDATE_DTM.getNanos());
    }
    if (null == this.EDW_UPDATE_USER) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, EDW_UPDATE_USER);
    }
    if (null == this.ADVNCD_SRVCS_ENGMNT_TYPE_CD) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ADVNCD_SRVCS_ENGMNT_TYPE_CD);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.SALES_ORDER_LINE_KEY) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.SALES_ORDER_LINE_KEY);
    }
    if (null == this.BK_AS_PROJECT_CD) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, BK_AS_PROJECT_CD);
    }
    if (null == this.SOL_AS_PROJECT_REV_AMT) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.SOL_AS_PROJECT_REV_AMT, __dataOut);
    }
    if (null == this.EDW_CREATE_DTM) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.EDW_CREATE_DTM.getTime());
    __dataOut.writeInt(this.EDW_CREATE_DTM.getNanos());
    }
    if (null == this.EDW_CREATE_USER) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, EDW_CREATE_USER);
    }
    if (null == this.EDW_UPDATE_DTM) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.EDW_UPDATE_DTM.getTime());
    __dataOut.writeInt(this.EDW_UPDATE_DTM.getNanos());
    }
    if (null == this.EDW_UPDATE_USER) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, EDW_UPDATE_USER);
    }
    if (null == this.ADVNCD_SRVCS_ENGMNT_TYPE_CD) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ADVNCD_SRVCS_ENGMNT_TYPE_CD);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 1, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(SALES_ORDER_LINE_KEY==null?"null":"" + SALES_ORDER_LINE_KEY, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(BK_AS_PROJECT_CD==null?"null":BK_AS_PROJECT_CD, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(SOL_AS_PROJECT_REV_AMT==null?"null":SOL_AS_PROJECT_REV_AMT.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(EDW_CREATE_DTM==null?"null":"" + EDW_CREATE_DTM, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(EDW_CREATE_USER==null?"null":EDW_CREATE_USER, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(EDW_UPDATE_DTM==null?"null":"" + EDW_UPDATE_DTM, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(EDW_UPDATE_USER==null?"null":EDW_UPDATE_USER, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ADVNCD_SRVCS_ENGMNT_TYPE_CD==null?"null":ADVNCD_SRVCS_ENGMNT_TYPE_CD, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(SALES_ORDER_LINE_KEY==null?"null":"" + SALES_ORDER_LINE_KEY, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(BK_AS_PROJECT_CD==null?"null":BK_AS_PROJECT_CD, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(SOL_AS_PROJECT_REV_AMT==null?"null":SOL_AS_PROJECT_REV_AMT.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(EDW_CREATE_DTM==null?"null":"" + EDW_CREATE_DTM, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(EDW_CREATE_USER==null?"null":EDW_CREATE_USER, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(EDW_UPDATE_DTM==null?"null":"" + EDW_UPDATE_DTM, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(EDW_UPDATE_USER==null?"null":EDW_UPDATE_USER, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ADVNCD_SRVCS_ENGMNT_TYPE_CD==null?"null":ADVNCD_SRVCS_ENGMNT_TYPE_CD, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 1, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.SALES_ORDER_LINE_KEY = null; } else {
      this.SALES_ORDER_LINE_KEY = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.BK_AS_PROJECT_CD = null; } else {
      this.BK_AS_PROJECT_CD = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.SOL_AS_PROJECT_REV_AMT = null; } else {
      this.SOL_AS_PROJECT_REV_AMT = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.EDW_CREATE_DTM = null; } else {
      this.EDW_CREATE_DTM = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.EDW_CREATE_USER = null; } else {
      this.EDW_CREATE_USER = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.EDW_UPDATE_DTM = null; } else {
      this.EDW_UPDATE_DTM = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.EDW_UPDATE_USER = null; } else {
      this.EDW_UPDATE_USER = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = null; } else {
      this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.SALES_ORDER_LINE_KEY = null; } else {
      this.SALES_ORDER_LINE_KEY = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.BK_AS_PROJECT_CD = null; } else {
      this.BK_AS_PROJECT_CD = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.SOL_AS_PROJECT_REV_AMT = null; } else {
      this.SOL_AS_PROJECT_REV_AMT = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.EDW_CREATE_DTM = null; } else {
      this.EDW_CREATE_DTM = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.EDW_CREATE_USER = null; } else {
      this.EDW_CREATE_USER = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.EDW_UPDATE_DTM = null; } else {
      this.EDW_UPDATE_DTM = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.EDW_UPDATE_USER = null; } else {
      this.EDW_UPDATE_USER = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = null; } else {
      this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    QueryResult o = (QueryResult) super.clone();
    o.EDW_CREATE_DTM = (o.EDW_CREATE_DTM != null) ? (java.sql.Timestamp) o.EDW_CREATE_DTM.clone() : null;
    o.EDW_UPDATE_DTM = (o.EDW_UPDATE_DTM != null) ? (java.sql.Timestamp) o.EDW_UPDATE_DTM.clone() : null;
    return o;
  }

  public void clone0(QueryResult o) throws CloneNotSupportedException {
    o.EDW_CREATE_DTM = (o.EDW_CREATE_DTM != null) ? (java.sql.Timestamp) o.EDW_CREATE_DTM.clone() : null;
    o.EDW_UPDATE_DTM = (o.EDW_UPDATE_DTM != null) ? (java.sql.Timestamp) o.EDW_UPDATE_DTM.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("SALES_ORDER_LINE_KEY", this.SALES_ORDER_LINE_KEY);
    __sqoop$field_map.put("BK_AS_PROJECT_CD", this.BK_AS_PROJECT_CD);
    __sqoop$field_map.put("SOL_AS_PROJECT_REV_AMT", this.SOL_AS_PROJECT_REV_AMT);
    __sqoop$field_map.put("EDW_CREATE_DTM", this.EDW_CREATE_DTM);
    __sqoop$field_map.put("EDW_CREATE_USER", this.EDW_CREATE_USER);
    __sqoop$field_map.put("EDW_UPDATE_DTM", this.EDW_UPDATE_DTM);
    __sqoop$field_map.put("EDW_UPDATE_USER", this.EDW_UPDATE_USER);
    __sqoop$field_map.put("ADVNCD_SRVCS_ENGMNT_TYPE_CD", this.ADVNCD_SRVCS_ENGMNT_TYPE_CD);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("SALES_ORDER_LINE_KEY", this.SALES_ORDER_LINE_KEY);
    __sqoop$field_map.put("BK_AS_PROJECT_CD", this.BK_AS_PROJECT_CD);
    __sqoop$field_map.put("SOL_AS_PROJECT_REV_AMT", this.SOL_AS_PROJECT_REV_AMT);
    __sqoop$field_map.put("EDW_CREATE_DTM", this.EDW_CREATE_DTM);
    __sqoop$field_map.put("EDW_CREATE_USER", this.EDW_CREATE_USER);
    __sqoop$field_map.put("EDW_UPDATE_DTM", this.EDW_UPDATE_DTM);
    __sqoop$field_map.put("EDW_UPDATE_USER", this.EDW_UPDATE_USER);
    __sqoop$field_map.put("ADVNCD_SRVCS_ENGMNT_TYPE_CD", this.ADVNCD_SRVCS_ENGMNT_TYPE_CD);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("SALES_ORDER_LINE_KEY".equals(__fieldName)) {
      this.SALES_ORDER_LINE_KEY = (Integer) __fieldVal;
    }
    else    if ("BK_AS_PROJECT_CD".equals(__fieldName)) {
      this.BK_AS_PROJECT_CD = (String) __fieldVal;
    }
    else    if ("SOL_AS_PROJECT_REV_AMT".equals(__fieldName)) {
      this.SOL_AS_PROJECT_REV_AMT = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("EDW_CREATE_DTM".equals(__fieldName)) {
      this.EDW_CREATE_DTM = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("EDW_CREATE_USER".equals(__fieldName)) {
      this.EDW_CREATE_USER = (String) __fieldVal;
    }
    else    if ("EDW_UPDATE_DTM".equals(__fieldName)) {
      this.EDW_UPDATE_DTM = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("EDW_UPDATE_USER".equals(__fieldName)) {
      this.EDW_UPDATE_USER = (String) __fieldVal;
    }
    else    if ("ADVNCD_SRVCS_ENGMNT_TYPE_CD".equals(__fieldName)) {
      this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = (String) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("SALES_ORDER_LINE_KEY".equals(__fieldName)) {
      this.SALES_ORDER_LINE_KEY = (Integer) __fieldVal;
      return true;
    }
    else    if ("BK_AS_PROJECT_CD".equals(__fieldName)) {
      this.BK_AS_PROJECT_CD = (String) __fieldVal;
      return true;
    }
    else    if ("SOL_AS_PROJECT_REV_AMT".equals(__fieldName)) {
      this.SOL_AS_PROJECT_REV_AMT = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("EDW_CREATE_DTM".equals(__fieldName)) {
      this.EDW_CREATE_DTM = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("EDW_CREATE_USER".equals(__fieldName)) {
      this.EDW_CREATE_USER = (String) __fieldVal;
      return true;
    }
    else    if ("EDW_UPDATE_DTM".equals(__fieldName)) {
      this.EDW_UPDATE_DTM = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("EDW_UPDATE_USER".equals(__fieldName)) {
      this.EDW_UPDATE_USER = (String) __fieldVal;
      return true;
    }
    else    if ("ADVNCD_SRVCS_ENGMNT_TYPE_CD".equals(__fieldName)) {
      this.ADVNCD_SRVCS_ENGMNT_TYPE_CD = (String) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
