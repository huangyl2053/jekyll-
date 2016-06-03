package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-1070-010 lizhuoxuan
 */
public interface IShoKaishuKirokuKanriDiv extends ICommonChildDivBaseProperties {

    void initialize(RString 状態, HihokenshaNo 被保険者番号);

    /**
     * 証交付回収情報一覧を取得します。
     *
     * @return 証交付回収情報一覧 証交付回収情報一覧
     */
    public List<dgKoufuKaishu_Row> get証交付回収情報一覧();

    /**
     * 証交付回収の保存処理結果を返します。
     *
     */
    void saveShoKaishuKirokuKanri();
}
