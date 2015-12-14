package jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村選択ShichosonSelectorModelクラスです。
 *
 */
public class ShichosonSelectorModel implements Serializable {

    private static final long serialVersionUID = 2676957532196535475L;

    private RString shichosonCode;
    private RString shichosonName;
    private RString shichosonModel;
    private List<ShichosonSelectorResult> list;

    /**
     * listを取得します。
     *
     * @return list
     */
    public List<ShichosonSelectorResult> getList() {
        return list;
    }

    /**
     * listを設定します。
     *
     * @param list List<ShichosonSelectorResult>
     */
    public void setList(List<ShichosonSelectorResult> list) {
        this.list = list;
    }

    /**
     * shichosonModelを取得します。
     *
     * @return shichosonModel
     */
    public RString getShichosonModel() {
        return shichosonModel;
    }

    /**
     * shichosonModelを設定します。
     *
     * @param shichosonModel RString
     */
    public void setShichosonModel(RString shichosonModel) {
        this.shichosonModel = shichosonModel;
    }

    /**
     * shichosonCodeを取得します。
     *
     * @return shichosonCode
     */
    public RString getShichosonCode() {
        return shichosonCode;
    }

    /**
     * shichosonCodeを設定します。
     *
     * @param shichosonCode RString
     */
    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * shichosonNameを取得します。
     *
     * @return shichosonName
     */
    public RString getShichosonName() {
        return shichosonName;
    }

    /**
     * shichosonNameを設定します。
     *
     * @param shichosonName RString
     */
    public void setShichosonName(RString shichosonName) {
        this.shichosonName = shichosonName;
    }
}
