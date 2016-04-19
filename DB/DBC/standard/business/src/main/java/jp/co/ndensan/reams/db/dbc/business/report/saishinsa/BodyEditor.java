/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsa;

import jp.co.ndensan.reams.db.dbc.business.core.SaishinsaKohifutanshaBunSourceData;
import jp.co.ndensan.reams.db.dbc.entity.report.saishinsa.SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;

/**
 * 再審査決定通知書情報取込一覧表（公費負担者分）帳票BodyEditor
 *
 * @reamsid_L DBC-2820-050 sunhui
 */
public class BodyEditor implements ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor {

    private final SaishinsaKohifutanshaBunSourceData item;

    /**
     * コンストラクタです
     *
     * @param item SaishinsaKohifutanshaBunSourceData
     */
    public BodyEditor(SaishinsaKohifutanshaBunSourceData item) {
        this.item = item;
    }

    @Override
    public SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource edit(
            SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource source) {

        source.kohiFutanshaNo = item.get公費負担者番号();
        source.kohiFutanshaName = item.get公費負担者名();
        source.shutsuryokujun1 = item.get並び順１();
        source.shutsuryokujun2 = item.get並び順２();
        source.shutsuryokujun3 = item.get並び順３();
        source.shutsuryokujun4 = item.get並び順４();
        source.shutsuryokujun5 = item.get並び順５();
        source.kaipage1 = item.get改頁１();
        source.kaipage2 = item.get改頁２();
        source.kaipage3 = item.get改頁３();
        source.kaipage4 = item.get改頁４();
        source.kaipage5 = item.get改頁５();
        source.listCenter_1 = item.getNo();
        source.listCenter_2 = item.get取扱年月();
        source.listCenter_3 = item.getサービス提供年月();
        source.listUpper_1 = item.get事業者番号();
        source.listUpper_2 = item.get事業者名();
        source.listUpper_3 = item.getサービス種類コード();
        source.listUpper_4 = item.getサービス種類名();
        source.listUpper_5 = item.get再審査結果コード();
        source.listUpper_6 = item.get当初請求単位数();
        source.listUpper_7 = item.get申立単位数();
        source.listUpper_8 = item.get調整単位数();
        source.listLower_1 = item.get被保険者番号();
        source.listLower_2 = item.get被保険者名();
        source.listLower_3 = item.get申立事由コード();
        source.listLower_4 = item.get申立事由();
        source.listLower_5 = item.get再審査結果();
        source.listLower_6 = item.get原番単位数();
        source.listLower_7 = item.get決定単位数();
        source.listLower_8 = item.get公費負担額();
        source.midashi1 = item.get再審査申立タイトル();
        source.midashi2 = item.get再審査決定タイトル();
        source.midashi3 = item.get調整タイトル();
        source.midashi4 = item.get件数タイトル1();
        source.midashi5 = item.get単位数タイトル1();
        source.midashi6 = item.get公費負担額タイトル1();
        source.midashi7 = item.get件数タイトル2();
        source.midashi8 = item.get単位数タイトル2();
        source.midashi9 = item.get公費負担額タイトル2();
        source.midashi10 = item.get件数タイトル3();
        source.midashi11 = item.get単位数タイトル3();
        source.midashi12 = item.get公費負担額タイトル3();
        source.midashi13 = item.get介護給付費タイトル();
        source.midashi14 = item.get高額介護サービス費タイトル();
        source.kensu1 = item.get介護給付費請求件数();
        source.tanisu1 = item.get介護給付費請求単位数();
        source.futangaku1 = item.get介護給付費請求公費負担額();
        source.kensu2 = item.get介護給付費決定件数();
        source.tanisu2 = item.get介護給付費決定単位数();
        source.futangaku2 = item.get介護給付費決定公費負担額();
        source.kensu3 = item.get介護給付費調整件数();
        source.tanisu3 = item.get介護給付費調整単位数();
        source.futangaku3 = item.get介護給付費調整公費負担額();
        source.kensu4 = item.get高額介護サービス費請求件数();
        source.tanisu4 = item.get高額介護サービス費請求単位数();
        source.futangaku4 = item.get高額介護サービス費請求公費負担額();
        source.kensu5 = item.get高額介護サービス費決定件数();
        source.tanisu5 = item.get高額介護サービス費決定単位数();
        source.futangaku5 = item.get高額介護サービス費決定公費負担額();
        source.kensu6 = item.get高額介護サービス費調整件数();
        source.tanisu6 = item.get高額介護サービス費調整単位数();
        source.futangaku6 = item.get高額介護サービス費調整公費負担額();
        return source;
    }

}
