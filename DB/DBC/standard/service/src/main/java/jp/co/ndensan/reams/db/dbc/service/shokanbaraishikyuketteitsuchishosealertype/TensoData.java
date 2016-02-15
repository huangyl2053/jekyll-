/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.shokanbaraishikyuketteitsuchishosealertype;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer.ShokanKetteiTsuchiShoSealer2Item;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerItem;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import lombok.Getter;

/**
 * 伝送データEntityです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TensoData {

    private final List<ShokanKetteiTsuchiShoSealerItem> ｼｰﾗﾀｲﾌﾟ帳票ソースデータ;
    private final List<ShokanKetteiTsuchiShoSealer2Item> ｼｰﾗﾀｲﾌﾟ2帳票ソースデータ;
    private final IDaikoPrint 代行プリント送付票;

    /**
     * コンストラクタです。
     *
     * @param ｼｰﾗﾀｲﾌﾟ帳票ソースデータ ｼｰﾗﾀｲﾌﾟ帳票ソースデータ
     * @param ｼｰﾗﾀｲﾌﾟ2帳票ソースデータ ｼｰﾗﾀｲﾌﾟ2帳票ソースデータ
     * @param 代行プリント送付票 代行プリント送付票
     */
    public TensoData(List<ShokanKetteiTsuchiShoSealerItem> ｼｰﾗﾀｲﾌﾟ帳票ソースデータ,
            List<ShokanKetteiTsuchiShoSealer2Item> ｼｰﾗﾀｲﾌﾟ2帳票ソースデータ, IDaikoPrint 代行プリント送付票) {
        this.ｼｰﾗﾀｲﾌﾟ帳票ソースデータ = ｼｰﾗﾀｲﾌﾟ帳票ソースデータ;
        this.ｼｰﾗﾀｲﾌﾟ2帳票ソースデータ = ｼｰﾗﾀｲﾌﾟ2帳票ソースデータ;
        this.代行プリント送付票 = 代行プリント送付票;
    }
}
