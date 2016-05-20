/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;

/**
 * 認定調査票情報のEditorです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyoEditor implements INinteiChosaJohohyoEditor {

    private final NinteiChosaJohohyoEntity entity;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link NinteiChosaJohohyoEntity}
     * @param index Index
     */
    protected NinteiChosaJohohyoEditor(NinteiChosaJohohyoEntity entity, int index) {
        this.entity = entity;
        this.index = index;
    }

    /**
     * 認定調査票情報を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public NinteiChosaJohohyoReportSource edit(NinteiChosaJohohyoReportSource source) {
        //09B（総合事業）
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())) {
            editSource(source);
            editSource_09(source);
            source.listSabisujokyo_1 = entity.getサービス区分リスト().get(index);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())) {
            editSource(source);
            editSource_09(source);
            source.listSabisujokyo_1 = entity.getサービス区分リスト().get(index);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.get厚労省IF識別コード())) {
            editSource(source);
            editSource_09(source);
            if (index < entity.getサービス区分リスト_22().size()) {
                source.listSabisujokyo_1 = entity.getサービス区分リスト_22().get(index);
            }
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.get厚労省IF識別コード())) {
            editSource(source);
//            editSource_06(source);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード())) {
            editSource(source);
//            editSource_02(source);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード())) {
            editSource(source);
//            editSource_99(source);
        }
        return source;
    }

//    private NinteiChosaJohohyoReportSource editSource_06(NinteiChosaJohohyoReportSource source) {
//        if (index < 桁数_2) {
//            source.listChosaJiritsudo_1_32 = entity.get日常生活自立度リスト().get(index);
//        }
//        if (index < 桁数_10) {
//            source.listGogun_1_32 = entity.get身の回りリスト_32().get(index);
//            source.listRokugun1_1_32 = entity.get意思疎通リスト_32().get(index);
//        }
//        if (index < 桁数_6) {
//            source.listIchigun1_1_32 = entity.get麻痺拘縮1_リスト_32().get(index);
//            source.listIchigun2_1_32 = entity.get麻痺拘縮2_リスト_32().get(index);
//        }
//        if (index < 桁数_12) {
//            source.listIryo_1_32 = entity.get特別な医療リスト_32().get(index);
//        }
//        if (index < 桁数_3) {
//            source.listJugun_1_32 = entity.get活動参加リスト_32().get(index);
//            source.listSangun_1_32 = entity.get複雑動作リスト_32().get(index);
//        }
//        if (index < 桁数_7) {
//            source.listNigun_1_32 = entity.get移動リスト_32().get(index);
//            source.listYongun_1_32 = entity.get特別介護リスト_32().get(index);
//        }
//        if (index < 桁数_19) {
//            source.listRokugun1_1_32 = entity.get問題行動リスト_32().get(index);
//        }
//        if (index < 桁数_20) {
//            source.listSabisujokyo_1_32 = entity.getサービス区分リスト_32().get(index);
//        }
//        source.yubimNo_32 = entity.get郵便番号();
//        source.hihokenshaTelNo_32 = entity.get電話();
//        source.shinsaYMD_32 = entity.get二次判定日();
//        source.ichijiHanteiKekka = entity.get一次判定結果();
//        source.nijiHanteiKekka = entity.get二次判定結果();
//        source.ｙukokikan = entity.get認定有効時間_月();
//        source.nijihanteiKaishiYMD = entity.get認定有効時間From();
//        source.nijihanteishuryoYMD = entity.get認定有効時間To();
//        source.jotaizo_32 = entity.get状態像コード();
//        source.henkoJiyu_32 = entity.get変更事由();
//        source.tokuteishippeiName_32 = entity.get特定疾病();
//        source.shinsakaiIken_32 = entity.get審査会意見();
//        source.zenkaiNijihanteiDate_32 = entity.get前回判定日();
//        source.zenkaiNijihanteikekka_32 = entity.get前回判定結果();
//        source.zenkaiYukokikan_32 = entity.get前回判定有効時間_月();
//        source.zenHanteiKaishiYMD_32 = entity.get前回判定有効時間From();
//        source.zenHanteishuryoYMD_32 = entity.get前回判定有効時間To();
//        source.chosaJisshiYMD_32 = entity.get調査実施日();
//        source.chosaJisshiBasho_32 = entity.get実施場所コード();
//        source.chosaJisshiBashoTxit_32 = entity.get実施場所名称();
//        source.imgChosaJisshiBasho_32 = entity.get実施場所イメージ();
//        source.chosainName_32 = entity.get記入者();
//        source.chosaItakusakiName_32 = entity.get所属機関();
//        source.tokubetsukyufuTxit_32 = entity.get市町村特別給付();
//        source.imgTokubetsukyufu_32 = entity.get市町村特別給付イメージ();
//        source.zaitakusabisuTxit_32 = entity.get介護保険給付外の在宅();
//        source.imgZaitakusabisu_32 = entity.get介護保険給付外の在宅イメージ();
//        source.shisetsuriyo_32 = entity.get施設利用();
//        source.shisetsuNameTxit_32 = entity.get施設名();
//        source.imgShisetsuName_32 = entity.get施設名イメージ();
//        source.shisetsujushoTxit_32 = entity.get施設住所();
//        source.imgShisetsujusho_32 = entity.get施設住所イメージ();
//        source.shisetsuTxitTel_32 = entity.get施設電話();
//        source.imgShisetsuTel_32 = entity.get施設電話イメージ();
//        return source;
//    }
//    private NinteiChosaJohohyoReportSource editSource_02(NinteiChosaJohohyoReportSource source) {
//        source.yubimNo_42 = entity.get郵便番号();
//        source.hihokenshaTelNo_42 = entity.get電話();
//        source.shinsaYMD_42 = entity.get二次判定日();
//        source.ichijiHanteiKekka_42 = entity.get一次判定結果();
//        source.nijiHanteiKekka_42 = entity.get二次判定結果();
//        source.ｙukokikan_42 = entity.get認定有効時間_月();
//        source.nijihanteiKaishiYMD_42 = entity.get認定有効時間From();
//        source.nijihanteishuryoYMD_42 = entity.get認定有効時間To();
//        source.jotaizo_42 = entity.get状態像コード();
//        source.henkoJiyu_42 = entity.get変更事由();
//        source.tokuteishippeiName_42 = entity.get特定疾病();
//        source.shinsakaiIken_42 = entity.get審査会意見();
//        source.zenkaiNijihanteiDate_42 = entity.get前回判定日();
//        source.zenkaiNijihanteikekka_42 = entity.get前回判定結果();
//        source.zenkaiYukokikan_42 = entity.get前回判定有効時間_月();
//        source.zenHanteiKaishiYMD_42 = entity.get前回判定有効時間From();
//        source.zenHanteishuryoYMD_42 = entity.get前回判定有効時間To();
//        source.chosaJisshiYMD_42 = entity.get調査実施日();
//        source.chosaJisshiBasho_42 = entity.get実施場所コード();
//        source.chosaJisshiBashoTxit_42 = entity.get実施場所名称();
//        source.imgChosaJisshiBasho_42 = entity.get実施場所イメージ();
//        source.chosainName_42 = entity.get記入者();
//        source.chosaItakusakiName_42 = entity.get所属機関();
//        source.tokubetsukyufuTxit_42 = entity.get市町村特別給付();
//        source.imgTokubetsukyufu_42 = entity.get市町村特別給付イメージ();
//        source.zaitakusabisuTxit_42 = entity.get介護保険給付外の在宅();
//        source.imgZaitakusabisu_42 = entity.get介護保険給付外の在宅イメージ();
//        source.shisetsuriyo_42 = entity.get施設利用();
//        source.shisetsuNameTxit_42 = entity.get施設名();
//        source.imgShisetsuName_42 = entity.get施設名イメージ();
//        source.shisetsujushoTxit_42 = entity.get施設住所();
//        source.imgShisetsujusho_42 = entity.get施設住所イメージ();
//        source.shisetsuTxitTel_42 = entity.get施設電話();
//        source.imgShisetsuTel_42 = entity.get施設電話イメージ();
//        return source;
//    }
//    private NinteiChosaJohohyoReportSource editSource_99(NinteiChosaJohohyoReportSource source) {
//        source.yubimNo_52 = entity.get郵便番号();
//        source.hihokenshaTelNo_52 = entity.get電話();
//        source.shinsaYMD_52 = entity.get二次判定日();
//        source.ichijiHanteiKekka_52 = entity.get一次判定結果();
//        source.nijiHanteiKekka_52 = entity.get二次判定結果();
//        source.ｙukokikan_52 = entity.get認定有効時間_月();
//        source.nijihanteiKaishiYMD_52 = entity.get認定有効時間From();
//        source.nijihanteishuryoYMD_52 = entity.get認定有効時間To();
//        source.jotaizo_52 = entity.get状態像コード();
//        source.henkoJiyu_52 = entity.get変更事由();
//        source.tokuteishippeiName_52 = entity.get特定疾病();
//        source.shinsakaiIken_52 = entity.get審査会意見();
//        source.zenkaiNijihanteiDate_52 = entity.get前回判定日();
//        source.zenkaiNijihanteikekka_52 = entity.get前回判定結果();
//        source.zenkaiYukokikan_52 = entity.get前回判定有効時間_月();
//        source.zenHanteiKaishiYMD_52 = entity.get前回判定有効時間From();
//        source.zenHanteishuryoYMD_52 = entity.get前回判定有効時間To();
//        source.chosaJisshiYMD_52 = entity.get調査実施日();
//        source.chosaJisshiBasho_52 = entity.get実施場所コード();
//        source.chosaJisshiBashoTxit_52 = entity.get実施場所名称();
//        source.imgChosaJisshiBasho_52 = entity.get実施場所イメージ();
//        source.chosainName_52 = entity.get記入者();
//        source.chosaItakusakiName_52 = entity.get所属機関();
//        source.tokubetsukyufuTxit_52 = entity.get市町村特別給付();
//        source.imgTokubetsukyufu_52 = entity.get市町村特別給付イメージ();
//        source.zaitakusabisuTxit_52 = entity.get介護保険給付外の在宅();
//        source.imgZaitakusabisu_52 = entity.get介護保険給付外の在宅イメージ();
//        source.shisetsuriyo_52 = entity.get施設利用();
//        source.shisetsuNameTxit_52 = entity.get施設名();
//        source.imgShisetsuName_52 = entity.get施設名イメージ();
//        source.shisetsujushoTxit_52 = entity.get施設住所();
//        source.imgShisetsujusho_52 = entity.get施設住所イメージ();
//        source.shisetsuTxitTel_52 = entity.get施設電話();
//        source.imgShisetsuTel_52 = entity.get施設電話イメージ();
//        return source;
//    }
    private NinteiChosaJohohyoReportSource editSource_09(NinteiChosaJohohyoReportSource source) {
        if (index < entity.get日常生活自立度リスト().size()) {
            source.listChosaJiritsudo_1 = entity.get日常生活自立度リスト().get(index);
        }
        if (index < entity.get社会生活リスト().size()) {
            source.listGogun_1 = entity.get社会生活リスト().get(index);
        }
        if (index < entity.get起居動作リスト().size()) {
            source.listIchigun_1 = entity.get起居動作リスト().get(index);
        }
        if (index < entity.get身体機能1_リスト().size()) {
            source.listIchigun1_1 = entity.get身体機能1_リスト().get(index);
        }
        if (index < entity.get身体機能2_リスト().size()) {
            source.listIchigun2_1 = entity.get身体機能2_リスト().get(index);
        }
        if (index < entity.get生活機能リスト().size()) {
            source.listNigun_1 = entity.get生活機能リスト().get(index);
        }
        if (index < entity.get特別な医療リスト().size()) {
            source.listNigun1_1 = entity.get特別な医療リスト().get(index);
        }
        if (index < entity.get認知機能リスト().size()) {
            source.listSangun_1 = entity.get認知機能リスト().get(index);
        }
        if (index < entity.get行動障害リスト().size()) {
            source.listYongun_1 = entity.get行動障害リスト().get(index);
        }
        source.shinseikubunHorei = entity.get申請区分_法();
        source.tokubetsukyufuTxit = entity.get市町村特別給付();
//        source.imgTokubetsukyufu = entity.get市町村特別給付イメージ();
        source.zaitakusabisuTxit = entity.get介護保険給付外の在宅();
//        source.imgZaitakusabisu = entity.get介護保険給付外の在宅イメージ();
        source.shisetsuriyo = entity.get施設利用();
        source.shisetsuNameTxit = entity.get施設名();
//        source.imgShisetsuName = entity.get施設名イメージ();
        source.shisetsujushoTxit = entity.get施設住所();
//        source.imgShisetsujusho = entity.get施設住所イメージ();
        source.shisetsuTxitTel = entity.get施設電話();
//        source.imgShisetsuTel = entity.get施設電話イメージ();
        source.yubimNo = entity.get郵便番号();
        source.hihokenshaTelNo = entity.get電話();
        source.shinsaYMD = entity.get二次判定日();
        source.ichijiHanteiKekka = entity.get一次判定結果();
        source.nijiHanteiKekka = entity.get二次判定結果();
        source.ｙukokikan = entity.get認定有効時間_月();
        source.nijihanteiKaishiYMD = entity.get認定有効時間From();
        source.nijihanteishuryoYMD = entity.get認定有効時間To();
        source.jotaizo = entity.get状態像コード();
        source.tokuteishippeiName = entity.get特定疾病();
        source.shinsakaiIken = entity.get審査会意見();
        source.zenkaiNijihanteiDate = entity.get前回判定日();
        source.zenkaiNijihanteikekka = entity.get前回判定結果();
        source.zenkaiYukokikan = entity.get前回判定有効時間_月();
        source.zenHanteiKaishiYMD = entity.get前回判定有効時間From();
        source.zenHanteishuryoYMD = entity.get前回判定有効時間To();
        source.chosaJisshiYMD = entity.get調査実施日();
        source.chosaJisshiBasho = entity.get実施場所コード();
        source.chosaJisshiBashoTxit = entity.get実施場所名称();
//        source.imgChosaJisshiBasho = entity.get実施場所イメージ();
        source.chosainName = entity.get記入者();
        source.chosaItakusakiName = entity.get所属機関();
        return source;
    }

    private NinteiChosaJohohyoReportSource editSource(NinteiChosaJohohyoReportSource source) {
        source.hokenshaNo = entity.get保険者番号();
        source.hihokenshaNo = entity.get被保険者番号();
        source.hihokenshaName = entity.get被保険者氏名();
        source.shinseiGengo = entity.get申請日_元号();
        source.shinseiYY = entity.get申請日_年();
        source.shinseiMM = entity.get申請日_月();
        source.shinseiDD = entity.get申請日_日();
        source.sakuseiGengo = entity.get作成日_元号();
        source.sakuseiYY = entity.get作成日_年();
        source.sakuseiMM = entity.get作成日_月();
        source.sakuseiDD = entity.get作成日_日();
        source.chosaGengo = entity.get調査日_元号();
        source.chosaYY = entity.get調査日_年();
        source.chosaMM = entity.get調査日_月();
        source.chosaDD = entity.get調査日_日();
        source.shinsaGengo = entity.get審査日_元号();
        source.shinsaYY = entity.get審査日_年();
        source.shinsaMM = entity.get審査日_月();
        source.shinsaDD = entity.get審査日_日();
        source.title = entity.getタイトル();
        source.age = entity.get年齢();
        source.seibetsu = entity.get性別();
        source.hihokenshaJusho = entity.get現住所();
        source.kazokuYubimNo = entity.get家族連絡先郵便番号();
        source.kazokuTelNo1 = entity.get家族連絡先電話1();
        source.kazokuTelNo2 = entity.get家族連絡先電話2();
        source.kazokuJusho = entity.get家族連絡先住所();
        source.kazokuName = entity.get家族連絡先名();
        source.zokugara = entity.get家族連絡先関係();
        source.shinseiKubun = entity.get申請区分_申();
        return source;
    }
}
