package jp.co.ndensan.reams.db.dba.business.shichosonselector;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村選択ShichosonSelectorModelの作成する。
 *
 */
public class ShichosonSelectorModel implements Serializable {

    private RString shichosonCode;
    private RString shichosonName;
    private RString shichosonModel;
    private List<DbT7051KoseiShichosonMasterEntity> list;

    /**
     *
     * @return list
     */
    public List<DbT7051KoseiShichosonMasterEntity> getList() {
        return list;
    }

    /**
     *
     * @param list
     */
    public void setList(List<DbT7051KoseiShichosonMasterEntity> list) {
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
     * @param shichosonModel
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
     * @param shichosonCode
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
     * @param shichosonName
     */
    public void setShichosonName(RString shichosonName) {
        this.shichosonName = shichosonName;
    }

}
