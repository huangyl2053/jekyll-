/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.entity.report.source.saishinsaketteihokenshain.SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource;

/**
 *
 * 再審査決定通知書情報取込一覧表（保険者分）のEditorです。
 *
 * @reamsid_L DBC-2520-040 chenaoqi
 */
public class SaishinsaKetteiHokenshaInEditor implements ISaishinsaKetteiHokenshaInEditor {

    private final SaishinsaKetteiHokenshaInItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem}
     */
    protected SaishinsaKetteiHokenshaInEditor(SaishinsaKetteiHokenshaInItem item) {
        this.item = item;
    }

    @Override
    public SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource edit(SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource source) {

        return editSource(source);
    }

    private SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource editSource(SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource source) {
        source.futangaku1 = item.get介護給付費請求負担額();
        source.futangaku2 = item.get介護給付費決定負担額();
        source.futangaku3 = item.get介護給付費調整負担額();
        source.futangaku4 = item.get高額介護サービス費請求負担額();
        source.futangaku5 = item.get高額介護サービス費決定負担額();
        source.futangaku6 = item.get高額介護サービス費調整負担額();
        source.hokenshaName = item.get証記載保険者名();
        source.hokenshaNo = item.get証記載保険者番号();
        source.kaipage1 = item.get改頁1();
        source.kaipage2 = item.get改頁2();
        source.kaipage3 = item.get改頁3();
        source.kaipage4 = item.get改頁4();
        source.kaipage5 = item.get改頁5();
        source.kensu1 = item.get介護給付費請求件数();
        source.kensu2 = item.get介護給付費決定件数();
        source.kensu3 = item.get介護給付費調整件数();
        source.kensu4 = item.get高額介護サービス費請求件数();
        source.kensu5 = item.get高額介護サービス費決定件数();
        source.kensu6 = item.get高額介護サービス費調整件数();
        source.kokuhorenName = item.get国保連合会名();
        source.listCenter_1 = item.getNo();
        source.listCenter_2 = item.get取扱年月();
        source.listCenter_3 = item.getサービス提供年月();
        source.listLower_1 = item.get被保険者番号();
        source.listLower_2 = item.get被保険者名();
        source.listLower_3 = item.get申立事由コード();
        source.listLower_4 = item.get申立事由();
        source.listLower_5 = item.get再審査結果();
        source.listLower_6 = item.get原番単位数();
        source.listLower_7 = item.get決定単位数();
        source.listLower_8 = item.get保険者負担額();
        source.listUpper_1 = item.get事業所番号();
        source.listUpper_2 = item.get事業所名();
        source.listUpper_3 = item.getサービス種類コード();
        source.listUpper_4 = item.getサービス種類名();
        source.listUpper_5 = item.get再審査結果コード();
        source.listUpper_6 = item.get当初請求単位数();
        source.listUpper_7 = item.get申立単位数();
        source.listUpper_8 = item.get調整単位数();
        source.midashi1 = item.get再審査申立タイトル();
        source.midashi10 = item.get調査件数タイトル();
        source.midashi11 = item.get調査単位数タイトル();
        source.midashi12 = item.get調査保険者負担額タイトル();
        source.midashi13 = item.get介護給付費タイトル();
        source.midashi14 = item.get高額介護サービス費タイトル();
        source.midashi2 = item.get再審査決定タイトル();
        source.midashi3 = item.get調整タイトル();
        source.midashi4 = item.get請求件数タイトル();
        source.midashi5 = item.get請求単位数タイトル();
        source.midashi6 = item.get請求保険者負担額タイトル();
        source.midashi7 = item.get決定件数タイトル();
        source.midashi8 = item.get決定単位数タイトル();
        source.midashi9 = item.get決定保険者負担額タイトル();
        source.printTimeStamp = item.get作成日時();
        source.shinsakaiName = item.get審査委員会名();
        source.shoHokenshaName = item.get証記載保険者名();
        source.shoHokenshaNameTitle = item.get証記載保険者名タイトル();
        source.shoHokenshaNo = item.get証記載保険者番号();
        source.shoHokenshaNoTitle = item.get証記載保険者番号タイトル();
        source.shutsuryokujun1 = item.get並び順1();
        source.shutsuryokujun2 = item.get並び順2();
        source.shutsuryokujun3 = item.get並び順3();
        source.shutsuryokujun4 = item.get並び順4();
        source.shutsuryokujun5 = item.get並び順5();
        source.tanisu1 = item.get介護給付費請求単位数();
        source.tanisu2 = item.get介護給付費決定単位数();
        source.tanisu3 = item.get介護給付費調整単位数();
        source.tanisu4 = item.get高額介護サービス費請求単位数();
        source.tanisu5 = item.get高額介護サービス費決定単位数();
        source.tanisu6 = item.get高額介護サービス費調整単位数();
        source.torikomiYM = item.get取込年月();

        return source;
    }
}
