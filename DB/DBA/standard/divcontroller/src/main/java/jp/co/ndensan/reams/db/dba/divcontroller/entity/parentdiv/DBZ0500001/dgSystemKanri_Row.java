package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBZ0500001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 14 15:08:13 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;


/**
 * dgSystemKanri_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSystemKanri_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString configName;
    private TextBox configValue;
    private RString configDescription;
    private RString beforeChangeConfigValue;
    private RString configValueChangeFlag;

    public dgSystemKanri_Row() {
        super();
        this.configName = RString.EMPTY;
        this.configValue = new TextBox();
        this.configDescription = RString.EMPTY;
        this.beforeChangeConfigValue = RString.EMPTY;
        this.configValueChangeFlag = RString.EMPTY;
        this.setOriginalData("configName", configName);
        this.setOriginalData("configValue", configValue);
        this.setOriginalData("configDescription", configDescription);
        this.setOriginalData("beforeChangeConfigValue", beforeChangeConfigValue);
        this.setOriginalData("configValueChangeFlag", configValueChangeFlag);
    }

    public dgSystemKanri_Row(RString configName, TextBox configValue, RString configDescription, RString beforeChangeConfigValue, RString configValueChangeFlag) {
        super();
        this.setOriginalData("configName", configName);
        this.setOriginalData("configValue", configValue);
        this.setOriginalData("configDescription", configDescription);
        this.setOriginalData("beforeChangeConfigValue", beforeChangeConfigValue);
        this.setOriginalData("configValueChangeFlag", configValueChangeFlag);
        this.configName = configName;
        this.configValue = configValue;
        this.configDescription = configDescription;
        this.beforeChangeConfigValue = beforeChangeConfigValue;
        this.configValueChangeFlag = configValueChangeFlag;
    }

    public RString getConfigName() {
        return configName;
    }

    public TextBox getConfigValue() {
        return configValue;
    }

    public RString getConfigDescription() {
        return configDescription;
    }

    public RString getBeforeChangeConfigValue() {
        return beforeChangeConfigValue;
    }

    public RString getConfigValueChangeFlag() {
        return configValueChangeFlag;
    }

    public void setConfigName(RString configName) {
        this.setOriginalData("configName", configName);
        this.configName = configName;
    }

    public void setConfigValue(TextBox configValue) {
        this.setOriginalData("configValue", configValue);
        this.configValue = configValue;
    }

    public void setConfigDescription(RString configDescription) {
        this.setOriginalData("configDescription", configDescription);
        this.configDescription = configDescription;
    }

    public void setBeforeChangeConfigValue(RString beforeChangeConfigValue) {
        this.setOriginalData("beforeChangeConfigValue", beforeChangeConfigValue);
        this.beforeChangeConfigValue = beforeChangeConfigValue;
    }

    public void setConfigValueChangeFlag(RString configValueChangeFlag) {
        this.setOriginalData("configValueChangeFlag", configValueChangeFlag);
        this.configValueChangeFlag = configValueChangeFlag;
    }

    // </editor-fold>
}
