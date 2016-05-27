package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IHihokenshaShikakuHakkoDiv extends ICommonChildDivBaseProperties {

    void initialize(HihokenshaNo 被保険者番号, RString メニューID, ShikibetsuCode 識別コード);

    tabHihokenshaShikakuShosaiDiv getTabHihokenshaShikakuShosai();

    NinteiInfoDiv getNinteiInfo();

    YukoKigenInfoDiv getYukoKigenInfo();

    RString getHidden入所施設コード１();

    RString getHidden入所施設種類１();

    RString getHidden入所施設コード２();

    RString getHidden入所施設種類２();

    RString getHidden入所施設コード３();

    RString getHidden入所施設種類３();

    RString getHidden適用終了日１();

    RString getHidden適用終了日２();

    RString getHidden適用終了日３();

}
