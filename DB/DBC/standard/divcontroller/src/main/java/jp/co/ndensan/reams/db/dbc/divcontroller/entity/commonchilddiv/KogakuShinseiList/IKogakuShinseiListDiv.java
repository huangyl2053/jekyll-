package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 画面設計_DBCKD00005_高額申請一覧共有子Div
 *
 * @reamsid_L DBC-2020-010 quxiaodong
 */
public interface IKogakuShinseiListDiv extends ICommonChildDivBaseProperties {

    /**
     * 高額申請一覧共有子DivのInterface
     *
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param 導入形態コード RString
     */
    public void initialize(RString メニューID, HihokenshaNo 被保険者番号, RString 導入形態コード);

    /**
     * 審査決定フラグ
     *
     * @return boolean
     */
    public boolean is審査決定フラグ();

    /**
     * 支給区分フラグ
     *
     * @return boolean
     */
    public boolean is支給区分フラグ();
}
