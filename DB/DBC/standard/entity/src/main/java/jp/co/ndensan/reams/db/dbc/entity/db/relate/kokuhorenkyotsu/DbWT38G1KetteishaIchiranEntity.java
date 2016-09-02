package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 給付管理票一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT38G1KetteishaIchiranEntity
        extends DbTableEntityBase<DbWT38G1KetteishaIchiranEntity> implements IDbAccessable {

    @PrimaryKey
    private RString shinseiTaishoNendo;
    @PrimaryKey
    private RString no;
    private RString kinyuKikanCode;
    private RString kinyuKikanShitenCode;
    private RString kozaShumoku;
    private HihokenshaNo hihokenshaNo;

}
