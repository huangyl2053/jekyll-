package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaigoNinteiShinseishaInfoDiv extends ICommonChildDivBaseProperties {

    /**
     * 初期化処理。
     *
     * @param 介護導入形態 介護導入形態
     * @param KaigoNinteiAtenaInfo処理タイプ KaigoNinteiAtenaInfo処理タイプ
     * @param 識別コード 識別コード
     * @param 申請書管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     * @param KaigoShikakuKihon表示モード KaigoShikakuKihon表示モード
     */
    void load(RString 介護導入形態, RString KaigoNinteiAtenaInfo処理タイプ
            , ShikibetsuCode 識別コード
            , ShinseishoKanriNo 申請書管理番号
            , HihokenshaNo 被保険者番号
            , RString KaigoShikakuKihon表示モード);
    
}
