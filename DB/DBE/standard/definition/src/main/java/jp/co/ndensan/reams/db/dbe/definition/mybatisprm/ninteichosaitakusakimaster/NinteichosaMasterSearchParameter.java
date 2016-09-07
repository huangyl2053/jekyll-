package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他機関情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NinteichosaMasterSearchParameter {

    private final ShoKisaiHokenshaNo 保険者番号;
    private final RString その他機関コード;

    private NinteichosaMasterSearchParameter(
            ShoKisaiHokenshaNo 保険者番号,
            RString その他機関コード
    ) {
        this.保険者番号 = 保険者番号;
        this.その他機関コード = その他機関コード;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 保険者番号 保険者番号
     * @param その他機関コード その他機関コード
     *
     * @return 主治医マスタパラメータ
     */
    public static NinteichosaMasterSearchParameter createParamForSelectByKey(
            ShoKisaiHokenshaNo 保険者番号,
            RString その他機関コード
    ) {
        return new NinteichosaMasterSearchParameter(
                保険者番号, その他機関コード);
    }
}
