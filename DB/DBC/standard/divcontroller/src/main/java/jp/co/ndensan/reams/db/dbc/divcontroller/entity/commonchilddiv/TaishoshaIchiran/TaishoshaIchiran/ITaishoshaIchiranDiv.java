package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.TaishoshaIchiran.TaishoshaIchiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBC-4471-010 xupeng
 */
public interface ITaishoshaIchiranDiv extends ICommonChildDivBaseProperties {

    /**
     * 画面初期化
     *
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日From FlexibleDate
     * @param 異動日To FlexibleDate
     * @param 表示モード RString
     * @param 削除データ検索 RString
     * @param 対象者一覧情報 List<KyodoJukyushaTaishoshaEntity>
     */
    public void initialize(RString メニューID, HihokenshaNo 被保険者番号, FlexibleDate 異動日From,
            FlexibleDate 異動日To, RString 表示モード, RString 削除データ検索,
            List<KyodoJukyushaTaishoshaEntity> 対象者一覧情報);
}
