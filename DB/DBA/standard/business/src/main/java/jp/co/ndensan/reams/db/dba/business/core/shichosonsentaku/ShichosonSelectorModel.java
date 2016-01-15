package jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村選択ShichosonSelectorModelの作成する。
 *
 */
public class ShichosonSelectorModel implements Serializable {

    private static final long serialVersionUID = 2676957532196535475L;

    private RString shichosonCode;
    private RString shichosonName;
    private RString shichosonModel;
    private List<ShichosonSelectorResult> list;

    /**
     *
     * @return list
     */
    public List<ShichosonSelectorResult> getList() {
        return list;
    }

    /**
     *
     * @param list list
     */
    public void setList(List<ShichosonSelectorResult> list) {
        this.list = list;
    }

    /**
     *
     * @return shichosonModel
     */
    public RString getShichosonModel() {
        return shichosonModel;
    }

    /**
     *
     * @param shichosonModel shichosonModel
     */
    public void setShichosonModel(RString shichosonModel) {
        this.shichosonModel = shichosonModel;
    }

    /**
     *
     * @return shichosonCode
     */
    public RString getShichosonCode() {
        return shichosonCode;
    }

    /**
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     *
     * @return shichosonName
     */
    public RString getShichosonName() {
        return shichosonName;
    }

    /**
     *
     * @param shichosonName shichosonNames
     */
    public void setShichosonName(RString shichosonName) {
        this.shichosonName = shichosonName;
    }
}
