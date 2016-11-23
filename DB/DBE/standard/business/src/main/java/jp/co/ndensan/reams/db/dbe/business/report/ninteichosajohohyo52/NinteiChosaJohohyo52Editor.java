/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo52;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo52ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 認定調査票情報のEditorです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyo52Editor implements INinteiChosaJohohyo52Editor {

    private final NinteiChosaJohohyoEntity entity;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link NinteiChosaJohohyoEntity}
     * @param index Index
     */
    protected NinteiChosaJohohyo52Editor(NinteiChosaJohohyoEntity entity, int index) {
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
    public NinteiChosaJohohyo52ReportSource edit(NinteiChosaJohohyo52ReportSource source) {
        editSource_52(source);
        return source;
    }

    private NinteiChosaJohohyo52ReportSource editSource_52(NinteiChosaJohohyo52ReportSource source) {
        source.hokenshaNo = entity.get保険者番号();
        source.hihokenshaNo = entity.get被保険者番号();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hihokennshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), entity.get被保険者番号());
        source.hihokenshaName = entity.get被保険者氏名();
        source.shinseiGengo = entity.get申請日_元号();
        source.shinseiYY = !RString.isNullOrEmpty(entity.get申請日_年()) ? entity.get申請日_年().substring(2) : RString.EMPTY;
        source.shinseiMM = entity.get申請日_月();
        source.shinseiDD = entity.get申請日_日();
        source.sakuseiGengo = entity.get作成日_元号();
        source.sakuseiYY = !RString.isNullOrEmpty(entity.get作成日_年()) ? entity.get作成日_年().substring(2) : RString.EMPTY;
        source.sakuseiMM = entity.get作成日_月();
        source.sakuseiDD = entity.get作成日_日();
        source.chosaGengo = entity.get調査日_元号();
        source.chosaYY = !RString.isNullOrEmpty(entity.get調査日_年()) ? entity.get調査日_年().substring(2) : RString.EMPTY;
        source.chosaMM = entity.get調査日_月();
        source.chosaDD = entity.get調査日_日();
        source.shinsaGengo = entity.get審査日_元号();
        source.shinsaYY = !RString.isNullOrEmpty(entity.get審査日_年()) ? entity.get審査日_年().substring(2) : RString.EMPTY;
        source.shinsaMM = entity.get審査日_月();
        source.shinsaDD = entity.get審査日_日();
        source.title = entity.getタイトル();
        source.age = entity.get年齢();
        source.seibetsu = entity.get性別();
        source.yubimNo = entity.get郵便番号();
        source.hihokenshaTelNo = entity.get電話();
        source.hihokenshaJusho = entity.get現住所();
        source.kazokuYubimNo = entity.get家族連絡先郵便番号();
        source.kazokuTelNo1 = entity.get家族連絡先電話1();
        source.kazokuTelNo2 = entity.get家族連絡先電話2();
        source.kazokuJusho = entity.get家族連絡先住所();
        source.kazokuName = entity.get家族連絡先名();
        source.zokugara = entity.get家族連絡先関係();
        source.shinseiKubun = entity.get申請区分_申();
        source.shinsaYMD = entity.get二次判定日();
        source.ichijiHanteiKekka = entity.get一次判定結果();
        source.nijiHanteiKekka = entity.get二次判定結果();
        source.ｙukokikan = entity.get認定有効時間_月();
        source.nijihanteiKaishiYMD = entity.get認定有効時間From();
        source.nijihanteishuryoYMD = entity.get認定有効時間To();
        source.jotaizo = entity.get状態像コード();
        source.henkoJiyu = entity.get変更事由();
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
        source.imgChosaJisshiBasho = entity.get実施場所イメージ();
        source.chosainName = entity.get記入者();
        source.chosaItakusakiName = entity.get所属機関();
        source.tokubetsukyufuTxit = entity.get市町村特別給付();
        source.imgTokubetsukyufu = entity.get市町村特別給付イメージ();
        source.zaitakusabisuTxit = entity.get介護保険給付外の在宅();
        source.imgZaitakusabisu = entity.get介護保険給付外の在宅イメージ();
        source.shisetsuriyo = entity.get施設利用();
        source.shisetsuNameTxit = entity.get施設名();
        source.imgShisetsuName = entity.get施設名イメージ();
        source.shisetsujushoTxit = entity.get施設住所();
        source.imgShisetsujusho = entity.get施設住所イメージ();
        source.shisetsuTxitTel = entity.get施設電話();
        source.imgShisetsuTel = entity.get施設電話イメージ();
        if (index < entity.get日常生活自立度リスト().size()) {
            source.listChosaJiritsudo_1 = entity.get日常生活自立度リスト().get(index);
        }
        if (index < entity.get身の回りリスト_52().size()) {
            source.listGogun_1 = entity.get身の回りリスト_52().get(index);
        }
        if (index < entity.get麻痺拘縮1_リスト_52().size()) {
            source.listIchigun1_1 = entity.get麻痺拘縮1_リスト_52().get(index);
        }
        if (index < entity.get麻痺拘縮2_リスト_52().size()) {
            source.listIchigun2_1 = entity.get麻痺拘縮2_リスト_52().get(index);
        }
        if (index < entity.get特別な医療リスト_52().size()) {
            source.listIryo_1 = entity.get特別な医療リスト_52().get(index);
        }
        if (index < entity.get移動リスト_52().size()) {
            source.listNigun_1 = entity.get移動リスト_52().get(index);
        }
        if (index < entity.get意思疎通リスト_52().size()) {
            source.listRokugun_1 = entity.get意思疎通リスト_52().get(index);
        }
        if (index < entity.get問題行動リスト_52().size()) {
            source.listRokugun1_1 = entity.get問題行動リスト_52().get(index);
        }
        if (index < entity.getサービス区分リスト_52().size()) {
            source.listSabisujokyo1_1 = entity.getサービス区分リスト_52().get(index);
        }
        if (index < entity.get複雑動作リスト_52().size()) {
            source.listSangun_1 = entity.get複雑動作リスト_52().get(index);
        }
        if (index < entity.get特別介護リスト_52().size()) {
            source.listYongun_1 = entity.get特別介護リスト_52().get(index);
        }
        return source;
    }
}
