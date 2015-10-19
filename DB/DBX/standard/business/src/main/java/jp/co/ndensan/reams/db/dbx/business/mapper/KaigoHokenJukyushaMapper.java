/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.IIkensho;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoHokenJukyusha;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoNinteiShinsaKai;
import jp.co.ndensan.reams.db.dbx.business.core.IKobetsuJikoKaigoJukyu;
import jp.co.ndensan.reams.db.dbx.business.core.IYoKaigoNintei;
import jp.co.ndensan.reams.db.dbx.business.core.IYoKaigoNinteiChosa;
import jp.co.ndensan.reams.db.dbx.business.core.IYoKaigoNinteiIchijiHantei;
import jp.co.ndensan.reams.db.dbx.business.core.IYoKaigoNinteiKekka;
import jp.co.ndensan.reams.db.dbx.business.core.IYoKaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbx.business.core._Ikensho;
import jp.co.ndensan.reams.db.dbx.business.core._KaigoHokenJukyusha;
import jp.co.ndensan.reams.db.dbx.business.core._KaigoNinteiShinsaKai;
import jp.co.ndensan.reams.db.dbx.business.core._YoKaigoNintei;
import jp.co.ndensan.reams.db.dbx.business.core._YoKaigoNinteiChosa;
import jp.co.ndensan.reams.db.dbx.business.core._YoKaigoNinteiIchijiHantei;
import jp.co.ndensan.reams.db.dbx.business.core._YoKaigoNinteiKekka;
import jp.co.ndensan.reams.db.dbx.business.core._YoKaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.KaigohokenJukyushaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.KaigohokenJukyushaAndKojinEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護保険受給者の変換クラスです
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者マッパー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public final class KaigoHokenJukyushaMapper {

    private KaigoHokenJukyushaMapper() {
    }

    /**
     * 介護受給者クラスを生成して返します。
     *
     * @param jukyushaList 介護受給者と個人の複合エンティティリスト
     * @return 介護受給者クラス
     */
    public static IKaigoHokenJukyusha toKaigotoKaigoHokenJukyusha(List<KaigohokenJukyushaAndKojinEntity> jukyushaList) {
        if (jukyushaList.isEmpty()) {
            return null;
        }
        List<IYoKaigoNintei> ninteiList = new ArrayList();
        for (KaigohokenJukyushaAndKojinEntity jukyushaAndKojinEntity : jukyushaList) {
            ninteiList.add(createYokaigoNintei(
                    createYoKaigoNinteiShinsei(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createYoKaigoNinteiChosa(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createIkensho(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createYoKaigoNinteiIchijiHantei(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createNinteiShinsakai(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createYoKaigoNinteiKekka(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()));
        }

        IKojin kojin = ShikibetsuTaishoFactory.createShikibetsuTaisho(jukyushaList.get(0).getKojinEntity()).to個人();

        return new _KaigoHokenJukyusha(
                ninteiList,
                jukyushaList.get(0).getKaigohokenJukyushaEntity().get異動年月日(),
                kojin,
                jukyushaList.get(0).getKaigohokenJukyushaEntity().get喪失年月日());
    }

    /**
     * 介護受給者クラスを生成して返します。
     *
     * @param jukyushaKojinEntity 介護受給者と個人の複合エンティティ
     * @return 介護受給者クラス
     */
    public static IKaigoHokenJukyusha toKaigotoKaigoHokenJukyusha(KaigohokenJukyushaAndKojinEntity jukyushaKojinEntity) {

        IYoKaigoNintei yoKaigoNintei = createYokaigoNintei(
                createYoKaigoNinteiShinsei(jukyushaKojinEntity.getKaigohokenJukyushaEntity()),
                createYoKaigoNinteiChosa(jukyushaKojinEntity.getKaigohokenJukyushaEntity()),
                createIkensho(jukyushaKojinEntity.getKaigohokenJukyushaEntity()),
                createYoKaigoNinteiIchijiHantei(jukyushaKojinEntity.getKaigohokenJukyushaEntity()),
                createNinteiShinsakai(jukyushaKojinEntity.getKaigohokenJukyushaEntity()),
                createYoKaigoNinteiKekka(jukyushaKojinEntity.getKaigohokenJukyushaEntity()),
                jukyushaKojinEntity.getKaigohokenJukyushaEntity());

        List<IYoKaigoNintei> ninteiList = new ArrayList();
        ninteiList.add(yoKaigoNintei);

        IKojin kojin = ShikibetsuTaishoFactory.createShikibetsuTaisho(jukyushaKojinEntity.getKojinEntity()).to個人();

        return new _KaigoHokenJukyusha(
                ninteiList,
                jukyushaKojinEntity.getKaigohokenJukyushaEntity().get異動年月日(),
                kojin,
                jukyushaKojinEntity.getKaigohokenJukyushaEntity().get喪失年月日());
    }

    /**
     * 介護受給者クラスを生成して返します。
     *
     * @param jukyushaList 介護受給者と個人の複合エンティティリスト
     * @return 介護受給者クラスのリスト
     */
    public static List<IKaigoHokenJukyusha> toKaigotoKaigoHokenJukyushaList(List<KaigohokenJukyushaAndKojinEntity> jukyushaList) {
        if (jukyushaList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<IKaigoHokenJukyusha> kaigoHokenJukyushaList = new ArrayList();
        for (KaigohokenJukyushaAndKojinEntity jukyushaAndKojinEntity : jukyushaList) {
            IYoKaigoNintei yoKaigoNintei = createYokaigoNintei(
                    createYoKaigoNinteiShinsei(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createYoKaigoNinteiChosa(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createIkensho(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createYoKaigoNinteiIchijiHantei(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createNinteiShinsakai(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    createYoKaigoNinteiKekka(jukyushaAndKojinEntity.getKaigohokenJukyushaEntity()),
                    jukyushaAndKojinEntity.getKaigohokenJukyushaEntity());

            List<IYoKaigoNintei> ninteiList = new ArrayList();
            ninteiList.add(yoKaigoNintei);
            IKojin kojin = ShikibetsuTaishoFactory.createShikibetsuTaisho(jukyushaAndKojinEntity.getKojinEntity()).to個人();
            kaigoHokenJukyushaList.add(new _KaigoHokenJukyusha(
                    ninteiList,
                    jukyushaAndKojinEntity.getKaigohokenJukyushaEntity().get異動年月日(),
                    kojin,
                    jukyushaAndKojinEntity.getKaigohokenJukyushaEntity().get喪失年月日()));
        }
        return kaigoHokenJukyushaList;
    }

    /**
     * 個別事項介護受給クラスを生成して返します。
     *
     * @param jukyushaKojinEntity 介護受給者と個人の複合エンティティ
     * @param 基準日 基準日
     * @return 個別事項受給クラス
     */
    public static IKobetsuJikoKaigoJukyu toKobetsuJikoKaigoJukyu(KaigohokenJukyushaAndKojinEntity jukyushaKojinEntity, RDate 基準日) {
        return createYoKaigoNinteiKekka(jukyushaKojinEntity.getKaigohokenJukyushaEntity(), 基準日);

    }

    private static IYoKaigoNinteiChosa createYoKaigoNinteiChosa(KaigohokenJukyushaEntity jukyushaEntity) {
        IYoKaigoNinteiChosa chosa = new _YoKaigoNinteiChosa(
                jukyushaEntity.get依頼年月日(),
                jukyushaEntity.get実施年月日(),
                jukyushaEntity.get完了年月日(),
                jukyushaEntity.get認定調査員コード(),
                jukyushaEntity.get認定調査員氏名(),
                jukyushaEntity.get調査委託先コード(),
                jukyushaEntity.get事業者名称());
        return chosa;
    }

    private static IIkensho createIkensho(KaigohokenJukyushaEntity jukyushaEntity) {
        IIkensho ikensho = new _Ikensho(
                jukyushaEntity.get作成依頼年月日(),
                jukyushaEntity.get受領年月日(),
                jukyushaEntity.get障害高齢者生活自立度(),
                jukyushaEntity.get認知症高齢者生活自立度());
        return ikensho;
    }

    private static IYoKaigoNinteiIchijiHantei createYoKaigoNinteiIchijiHantei(KaigohokenJukyushaEntity jukyushaEntity) {
        IYoKaigoNinteiIchijiHantei 要介護一時判定 = new _YoKaigoNinteiIchijiHantei(
                YoKaigoJotaiKubun.toValue(jukyushaEntity.get一時判定_要介護状態区分()),
                YoKaigoJotaiKubun.toValue(jukyushaEntity.get認知症加算_要介護状態区分()),
                jukyushaEntity.get判定年月日());
        return 要介護一時判定;
    }

    private static IKaigoNinteiShinsaKai createNinteiShinsakai(KaigohokenJukyushaEntity jukyushaEntity) throws NullPointerException {
        IKaigoNinteiShinsaKai shinsakai = new _KaigoNinteiShinsaKai(
                jukyushaEntity.get資料作成年月日(),
                jukyushaEntity.get開催予定年月日(),
                jukyushaEntity.get合議体番号(),
                jukyushaEntity.get回答年月日());
        return shinsakai;
    }

    private static IYoKaigoNinteiKekka createYoKaigoNinteiKekka(KaigohokenJukyushaEntity jukyushaEntity) {
        return createYoKaigoNinteiKekka(jukyushaEntity, RDate.MIN);
    }

    private static _YoKaigoNinteiKekka createYoKaigoNinteiKekka(KaigohokenJukyushaEntity jukyushaEntity, RDate 基準日) {
        return new _YoKaigoNinteiKekka(
                jukyushaEntity.get認定年月日(),
                YoKaigoJotaiKubun.toValue(jukyushaEntity.get要介護状態区分()),
                new Range(
                        jukyushaEntity.get有効開始年月日(),
                        jukyushaEntity.get有効終了年月日()),
                jukyushaEntity.get審査会意見(),
                jukyushaEntity.get異動年月日(),
                jukyushaEntity.get特定疾病(),
                基準日);
    }

    private static IYoKaigoNintei createYokaigoNintei(
            IYoKaigoNinteiShinsei shinsei,
            IYoKaigoNinteiChosa chosa,
            IIkensho ikensho,
            IYoKaigoNinteiIchijiHantei yoKaigoNinteiIchijiHantei,
            IKaigoNinteiShinsaKai shinsakai,
            IYoKaigoNinteiKekka kekka,
            KaigohokenJukyushaEntity jukyushaEntity) {

        return new _YoKaigoNintei(
                shinsei,
                chosa,
                ikensho,
                yoKaigoNinteiIchijiHantei,
                shinsakai,
                kekka,
                jukyushaEntity.get主治医医師識別コード(),
                jukyushaEntity.get主治医氏名(),
                jukyushaEntity.get医療機関コード(),
                jukyushaEntity.get医療機関名称());
    }

    private static IYoKaigoNinteiShinsei createYoKaigoNinteiShinsei(KaigohokenJukyushaEntity jukyushaEntity) {
        IYoKaigoNinteiShinsei shinsei = new _YoKaigoNinteiShinsei(
                jukyushaEntity.get申請番号(),
                jukyushaEntity.get介護被保険者番号(),
                jukyushaEntity.get申請有効区分(),
                jukyushaEntity.get申請年月日(),
                jukyushaEntity.get申請時申請区分(),
                jukyushaEntity.get法令申請区分(),
                jukyushaEntity.get認定申請理由(),
                new LasdecCode(jukyushaEntity.get地方自治体コード()),
                jukyushaEntity.get取下げ区分());
        return shinsei;
    }
}
