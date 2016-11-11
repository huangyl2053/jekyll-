/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd571001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KyoshitsuShubetsu;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.homonkaigogemmen.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd571001.IdoChushutsuDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.IdoChushutsuDaichoNewEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.SenTouEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.temptable.JukyushaDaichoCyouhyoujouhouTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.FutanGendogakuNinteiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.HomonKaigoGenmenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.HyojunFutanGengakuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ItakuKeikakuTodokedejohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.KyufugakuGengakujohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.RiyoshaFutanGenmenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.RoreiFukushiNenkinjohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.SeikatsuHogojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.SentoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShafuHojinKeigenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShiharaHohoHenkojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShikakujohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.ShisetsuNyutaishojohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TokubetsuChiikiKasanGenmenJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TokureiShisetuNyutaishojohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.kyusochisha.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.SeikatsuHogoFujoShuruiCodeType;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * バッチ設計_DBD571001_受給者台帳のEntity設定のビジネスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
public class JukyushaDaichoCyouhyoujouhou {

    private final RString 要介護認定一次判定結果コード = new RString("要介護認定一次判定結果コード:");
    private final RString 要介護状態区分コード = new RString("要介護状態区分コード:");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_3 = new RString("3");
    private static final RString 区分_4 = new RString("4");
    private static final RString 区分_99A = new RString("99A");
    private static final RString 区分_02A = new RString("02A");
    private static final RString 区分_06A = new RString("06A");
    private static final RString 区分_09A = new RString("09A");
    private static final RString 区分_09B = new RString("09B");
    private static final RString 円 = new RString("円");
    private static final RString 率 = new RString("%");
    private static final RString 有り = new RString("有り");
    private static final int NO_100 = 100;

    /**
     * set先頭情報
     *
     * @param 導入形態コード 導入形態コード
     * @param 保険者番号の取得 保険者番号の取得
     * @param 保険者名称の取得 保険者名称の取得
     * @param t 受給者台帳
     * @param 通知文情報通知文 通知文情報通知文
     * @return 先頭情報
     */
    public SentoEntity set先頭情報(IdoChushutsuDaichoNewEntity t, DonyuKeitaiCode 導入形態コード,
            RString 保険者番号の取得, RString 保険者名称の取得, RString 通知文情報通知文) {
        SentoEntity 先頭Entity = new SentoEntity();
        set先頭Entity(先頭Entity, t, 導入形態コード, 保険者番号の取得, 保険者名称の取得, 通知文情報通知文);
        return 先頭Entity;
    }

    /**
     * set要介護認定情報List
     *
     * @param 導入形態コード 導入形態コード
     * @param t 受給者台帳
     * @param listEntity listEntity
     * @return 先頭情報
     */
    public List<NinteiKekkaJohoEntity> set要介護認定情報(IdoChushutsuDaichoNewEntity t,
            DonyuKeitaiCode 導入形態コード, List<NinteiKekkaJohoEntity> listEntity) {
        if (t.get要介護認定情報() != null && t.get要介護認定情報().get受給者台帳_被保険者番号1() != null
                && !t.get要介護認定情報().get受給者台帳_被保険者番号1().isEmpty()) {
            NinteiKekkaJohoEntity 要介護認定 = new NinteiKekkaJohoEntity();
            要介護認定.set認定区分(RString.EMPTY);
            要介護認定.set認定日(t.get要介護認定情報().get受給者台帳_認定年月日1());
            要介護認定.set申請事由(JukyuShinseiJiyu.toValue(t.get要介護認定情報().get受給者台帳_受給申請事由1().getColumnValue()).get名称());
            要介護認定情報設定(要介護認定, t);
            set広域単一(導入形態コード, 要介護認定, t);
            要介護認定.set調査予定日(t.get要介護認定情報().getT4123_認定調査予定年月日());
            要介護認定.set医師予定日(t.get要介護認定情報().getT4123_主治医意見書作成登録予定日());
            要介護認定.set旧措置(KyusochishaKubun.toValue(t.get要介護認定情報().is受給者台帳_旧措置者フラグ1()).get名称());
            要介護認定.set喪失日(t.get要介護認定情報().get受給者台帳_喪失年月日1());
            要介護認定.set資格取得前申請(t.get要介護認定情報().is受給者台帳_資格取得前申請フラグ1() ? new RString("取得前申請") : RString.EMPTY);
            要介護認定.set延期通知書発行日(t.get要介護認定情報().getT4101_延期通知発行年月日1());
            if (t.get要介護認定情報().getT4101_延期通知発行回数1() != null) {
                要介護認定.set延期通知書発行回数(DecimalFormatter.toコンマ区切りRString(t.get要介護認定情報().getT4101_延期通知発行回数1(), 0)
                        .concat(new RString("回")));
            }
            要介護認定.set資格証明書発行日１(t.get要介護認定情報().get受給者台帳_受給資格証明書発行年月日１1());
            要介護認定.set資格証明書発行日２(t.get要介護認定情報().get受給者台帳_受給資格証明書発行年月日２1());
            要介護認定.set申請代行事業者((t.get要介護認定情報().get受給者台帳_届出者申請者関係コード1() == null
                    || t.get要介護認定情報().get受給者台帳_届出者申請者関係コード1().isEmpty())
                    ? (t.get要介護認定情報().getX4120_事業者名称() != null
                    ? t.get要介護認定情報().getX4120_事業者名称() : RString.EMPTY) : (t.get要介護認定情報().getX4120_申請届出者氏名() != null
                    ? t.get要介護認定情報().getX4120_申請届出者氏名() : RString.EMPTY));
            要介護認定.set代行者コード((t.get要介護認定情報().get受給者台帳_届出者本人との関係1() == null
                    || t.get要介護認定情報().get受給者台帳_届出者本人との関係1().isEmpty())
                    ? (t.get要介護認定情報().getX4120_申請届出代行区分コード() != null
                    ? ShinseiTodokedeDaikoKubunCode.toValue(t.get要介護認定情報().getX4120_申請届出代行区分コード()).get名称() : RString.EMPTY)
                    : (t.get要介護認定情報().get受給者台帳_届出者本人との関係1() != null
                    ? t.get要介護認定情報().get受給者台帳_届出者本人との関係1() : RString.EMPTY));
            要介護認定.set指定医区分(t.get要介護認定情報().isT4101_指定医フラグ1() ? new RString("指定医") : RString.EMPTY);
            要介護認定.set調査委託先名(t.get要介護認定情報().getT4910_事業者名称());
            要介護認定.set調査員名(t.get要介護認定情報().getT4913_調査員氏名());
            要介護認定.set主治医医療機関名(t.get要介護認定情報().getT4911_医療機関名称());
            要介護認定.set主治医名(t.get要介護認定情報().getT4912_主治医氏名());
            要介護認定.set申請区分_申請時(t.get要介護認定情報().getT4101_認定申請区分_申請時_コード1() != null
                    ? NinteiShinseiShinseijiKubunCode.toValue(t.get要介護認定情報().getT4101_認定申請区分_申請時_コード1()).get名称() : RString.EMPTY);
            要介護認定.set申請区分_法令(t.get要介護認定情報().getT4101_認定申請区分_法令_コード1() != null
                    ? NinteiShinseiHoreiCode.toValue(t.get要介護認定情報().getT4101_認定申請区分_法令_コード1()).get名称() : RString.EMPTY);
            listEntity.add(要介護認定);
        }
        return listEntity;
    }

    /**
     * set負担限度額認定情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 負担限度額認定情報EntityList
     * @return 負担限度額認定情報EntityList
     */
    public List<FutanGendogakuNinteiJohoEntity> set負担限度額認定情報EntityList(IdoChushutsuDaichoNewEntity t,
            List<FutanGendogakuNinteiJohoEntity> listEntity) {
        if (t.get負担限度額認定情報List() != null && t.get負担限度額認定情報List().get負担限度額_被保険者番号() != null
                && !t.get負担限度額認定情報List().get負担限度額_被保険者番号().isEmpty()) {
            FutanGendogakuNinteiJohoEntity 負担限度額認定情報 = new FutanGendogakuNinteiJohoEntity();
            負担限度額認定情報.set負担限度額認定区分(RString.EMPTY);
            負担限度額認定情報.set申請年月日(t.get負担限度額認定情報List().get負担限度額_申請年月日());
            負担限度額認定情報.set申請理由(ShinseiRiyuKubun.toValue(t.get負担限度額認定情報List().get負担限度額_申請理由区分()).get名称());
            負担限度額認定情報.set決定年月日(t.get負担限度額認定情報List().get負担限度額_決定年月日());
            負担限度額認定情報.set適用年月日(t.get負担限度額認定情報List().get負担限度額_適用開始年月日());
            負担限度額認定情報.set有効期限(t.get負担限度額認定情報List().get負担限度額_適用終了年月日());
            if (t.get負担限度額認定情報List().get負担限度額_利用者負担段階() != null
                    && !t.get負担限度額認定情報List().get負担限度額_利用者負担段階().isEmpty()) {
                負担限度額認定情報.set負担段階(RiyoshaFutanDankai.toValue(t.get負担限度額認定情報List().get負担限度額_利用者負担段階()).get名称());
            }
            if (t.get負担限度額認定情報List().get負担限度額_旧措置者区分() != null
                    && !t.get負担限度額認定情報List().get負担限度額_旧措置者区分().isEmpty()) {
                負担限度額認定情報.set旧措置(KyuSochishaKubun.toValue(t.get負担限度額認定情報List().get負担限度額_旧措置者区分()).get名称());
            }
            if (t.get負担限度額認定情報List().get負担限度額_居室種別() != null
                    && !t.get負担限度額認定情報List().get負担限度額_居室種別().isEmpty()) {
                負担限度額認定情報.set居室種別(KyoshitsuShubetsu.toValue(t.get負担限度額認定情報List().get負担限度額_居室種別()).get名称());
            }
            負担限度額認定情報.set食費(t.get負担限度額認定情報List().get負担限度額_食費負担限度額() != null
                    ? DecimalFormatter.toコンマ区切りRString(t.get負担限度額認定情報List().get負担限度額_食費負担限度額(), 0).concat(円) : RString.EMPTY);
            負担限度額認定情報.setユ個(t.get負担限度額認定情報List().get負担限度額_ユニット型個室() != null
                    ? DecimalFormatter.toコンマ区切りRString(t.get負担限度額認定情報List().get負担限度額_ユニット型個室(), 0).concat(円) : RString.EMPTY);
            負担限度額認定情報.setユ準(t.get負担限度額認定情報List().get負担限度額_ユニット型準個室() != null
                    ? DecimalFormatter.toコンマ区切りRString(t.get負担限度額認定情報List().get負担限度額_ユニット型準個室(), 0).concat(円) : RString.EMPTY);
            負担限度額認定情報.set従特養(t.get負担限度額認定情報List().get負担限度額_従来型個室特養等() != null
                    ? DecimalFormatter.toコンマ区切りRString(t.get負担限度額認定情報List().get負担限度額_従来型個室特養等(), 0).concat(円) : RString.EMPTY);
            負担限度額認定情報.set従老健(t.get負担限度額認定情報List().get負担限度額_従来型個室老健療養等() != null
                    ? DecimalFormatter.toコンマ区切りRString(t.get負担限度額認定情報List().get負担限度額_従来型個室老健療養等(), 0).concat(円) : RString.EMPTY);
            負担限度額認定情報.set多床(t.get負担限度額認定情報List().get負担限度額_多床室() != null
                    ? DecimalFormatter.toコンマ区切りRString(t.get負担限度額認定情報List().get負担限度額_多床室(), 0).concat(円) : RString.EMPTY);
            負担限度額認定情報.set境界層(t.get負担限度額認定情報List().is負担限度額_境界層該当者区分() ? new RString("境界層該当者") : RString.EMPTY);
            負担限度額認定情報.set激変緩和(t.get負担限度額認定情報List().is負担限度額_激変緩和措置対象者区分() ? new RString("激変緩和対象者") : RString.EMPTY);
            listEntity.add(負担限度額認定情報);
        }
        return listEntity;
    }

    /**
     * set利用者負担減免情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 利用者負担減免情報EntityList
     * @return 利用者負担減免情報EntityList
     */
    public List<RiyoshaFutanGenmenJohoEntity> set利用者負担減免情報EntityList(IdoChushutsuDaichoNewEntity t, List<RiyoshaFutanGenmenJohoEntity> listEntity) {
        if (t.get利用者負担減免List() != null && t.get利用者負担減免List().get利用者負担減免_被保険者番号() != null
                && !t.get利用者負担減免List().get利用者負担減免_被保険者番号().isEmpty()) {
            RiyoshaFutanGenmenJohoEntity 利用者負担減免情報 = new RiyoshaFutanGenmenJohoEntity();
            利用者負担減免情報.set利用者負担減免区分(RString.EMPTY);
            利用者負担減免情報.set減免申請日(t.get利用者負担減免List().get利用者負担減免_申請年月日());
            利用者負担減免情報.set減免決定日(t.get利用者負担減免List().get利用者負担減免_決定年月日());
            利用者負担減免情報.set減免開始日(t.get利用者負担減免List().get利用者負担減免_適用開始年月日());
            利用者負担減免情報.set減免終了日(t.get利用者負担減免List().get利用者負担減免_適用終了年月日());
            利用者負担減免情報.set給付率(t.get利用者負担減免List().get利用者負担減免_給付率() != null
                    ? new RString(String.valueOf(t.get利用者負担減免List().get利用者負担減免_給付率().value())).concat(率) : RString.EMPTY);
            listEntity.add(利用者負担減免情報);
        }
        return listEntity;
    }

    /**
     * set社福法人軽減情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 社福法人軽減情報EntityList
     * @return 社福法人軽減情報EntityList
     */
    public List<ShafuHojinKeigenJohoEntity> set社福法人軽減情報EntityList(IdoChushutsuDaichoNewEntity t, List<ShafuHojinKeigenJohoEntity> listEntity) {
        if (t.get社福法人軽減List() != null && t.get社福法人軽減List().get社福法人軽減_被保険者番号() != null
                && !t.get社福法人軽減List().get社福法人軽減_被保険者番号().isEmpty()) {
            ShafuHojinKeigenJohoEntity 社福法人軽減情報 = new ShafuHojinKeigenJohoEntity();
            社福法人軽減情報.set社福軽減区分(RString.EMPTY);
            社福法人軽減情報.set減免申請日(t.get社福法人軽減List().get社福法人軽減_申請年月日());
            社福法人軽減情報.set減免決定日(t.get社福法人軽減List().get社福法人軽減_決定年月日());
            社福法人軽減情報.set減免開始日(t.get社福法人軽減List().get社福法人軽減_適用開始年月日());
            社福法人軽減情報.set減免終了日(t.get社福法人軽減List().get社福法人軽減_適用終了年月日());
            社福法人軽減情報.set確認番号(t.get社福法人軽減List().get社福法人軽減_確認番号());
            if (t.get社福法人軽減List().get社福法人軽減_軽減率_分子() != null
                    && t.get社福法人軽減List().get社福法人軽減_軽減率_分母() != null
                    && !t.get社福法人軽減List().get社福法人軽減_軽減率_分母().equals(Decimal.ZERO)) {
                社福法人軽減情報.set軽減率(new RString(String.valueOf(t.get社福法人軽減List().get社福法人軽減_軽減率_分子()
                        .divide(t.get社福法人軽減List().get社福法人軽減_軽減率_分母()).multiply(NO_100))));
            }
            社福法人軽減情報.set居宅限定(t.get社福法人軽減List().is社福法人軽減_居宅サービス限定() ? 有り : RString.EMPTY);
            社福法人軽減情報.set居_食限定(t.get社福法人軽減List().is社福法人軽減_居住費食費のみ() ? 有り : RString.EMPTY);
            社福法人軽減情報.set旧措限定(t.get社福法人軽減List().is社福法人軽減_旧措置者ユニット型個室のみ() ? 有り : RString.EMPTY);
            listEntity.add(社福法人軽減情報);
        }
        return listEntity;
    }

    /**
     * set訪問介護等減額情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 訪問介護等減額情報EntityList
     * @return 訪問介護等減額情報EntityList
     */
    public List<HomonKaigoGenmenJohoEntity> set訪問介護等減額情報EntityList(IdoChushutsuDaichoNewEntity t, List<HomonKaigoGenmenJohoEntity> listEntity) {
        if (t.get訪問介護等減額情報List() != null && t.get訪問介護等減額情報List().get訪問介護等減額_被保険者番号() != null
                && !t.get訪問介護等減額情報List().get訪問介護等減額_被保険者番号().isEmpty()) {
            HomonKaigoGenmenJohoEntity 訪問介護等減額情報 = new HomonKaigoGenmenJohoEntity();
            訪問介護等減額情報.set訪問介護利用者負担減額区分(RString.EMPTY);
            訪問介護等減額情報.set減免申請日(t.get訪問介護等減額情報List().get訪問介護等減額_申請年月日());
            訪問介護等減額情報.set減免決定日(t.get訪問介護等減額情報List().get訪問介護等減額_決定年月日());
            訪問介護等減額情報.set減免開始日(t.get訪問介護等減額情報List().get訪問介護等減額_適用開始年月日());
            訪問介護等減額情報.set減免終了日(t.get訪問介護等減額情報List().get訪問介護等減額_適用終了年月日());
            訪問介護等減額情報.set給付率(t.get訪問介護等減額情報List().get訪問介護等減額_給付率() != null
                    ? new RString(String.valueOf(t.get訪問介護等減額情報List().get訪問介護等減額_給付率().value())).concat(率) : RString.EMPTY);
            if (t.get訪問介護等減額情報List().get訪問介護等減額_法別区分() != null
                    && !t.get訪問介護等減額情報List().get訪問介護等減額_法別区分().isEmpty()) {
                訪問介護等減額情報.set法別(HobetsuKubun.toValue(t.get訪問介護等減額情報List().get訪問介護等減額_法別区分()));
            }
            訪問介護等減額情報.set受給者番号(t.get訪問介護等減額情報List().get訪問介護等減額_公費受給者番号());
            listEntity.add(訪問介護等減額情報);
        }
        return listEntity;
    }

    /**
     * set標準負担減額情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 標準負担減額情報EntityList
     * @return 標準負担減額情報EntityList
     */
    public List<HyojunFutanGengakuJohoEntity> set標準負担減額情報EntityList(IdoChushutsuDaichoNewEntity t, List<HyojunFutanGengakuJohoEntity> listEntity) {
        if (t.get標準負担減額List() != null && t.get標準負担減額List().get標準負担減額_被保険者番号() != null
                && !t.get標準負担減額List().get標準負担減額_被保険者番号().isEmpty()) {
            HyojunFutanGengakuJohoEntity 標準負担減額情報 = new HyojunFutanGengakuJohoEntity();
            標準負担減額情報.set標準負担減額区分(RString.EMPTY);
            標準負担減額情報.set減免申請日(t.get標準負担減額List().get標準負担減額_申請年月日());
            標準負担減額情報.set減免決定日(t.get標準負担減額List().get標準負担減額_決定年月日());
            標準負担減額情報.set減免開始日(t.get標準負担減額List().get標準負担減額_適用開始年月日());
            標準負担減額情報.set減免終了日(t.get標準負担減額List().get標準負担減額_適用終了年月日());
            if (t.get標準負担減額List().get標準負担減額_減額後金額() != null) {
                標準負担減額情報.set負担額(new RString(String.valueOf(t.get標準負担減額List().get標準負担減額_減額後金額())));
            }
            listEntity.add(標準負担減額情報);
        }
        return listEntity;
    }

    /**
     * set特別地域加算減免情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 特別地域加算減免情報EntityList
     * @return 特別地域加算減免情報EntityList
     */
    public List<TokubetsuChiikiKasanGenmenJohoEntity> set特別地域加算減免情報EntityList(IdoChushutsuDaichoNewEntity t,
            List<TokubetsuChiikiKasanGenmenJohoEntity> listEntity) {
        if (t.get特別地域加算List() != null && t.get特別地域加算List().get特別地域加算_被保険者番号() != null
                && !t.get特別地域加算List().get特別地域加算_被保険者番号().isEmpty()) {
            TokubetsuChiikiKasanGenmenJohoEntity 特別地域加算減免情報 = new TokubetsuChiikiKasanGenmenJohoEntity();
            特別地域加算減免情報.set特別地域加算減免区分(RString.EMPTY);
            特別地域加算減免情報.set申請年月日(t.get特別地域加算List().get特別地域加算_申請年月日());
            特別地域加算減免情報.set決定年月日(t.get特別地域加算List().get特別地域加算_決定年月日());
            特別地域加算減免情報.set適用年月日(t.get特別地域加算List().get特別地域加算_適用開始年月日());
            特別地域加算減免情報.set有効期限(t.get特別地域加算List().get特別地域加算_適用終了年月日());
            特別地域加算減免情報.set減額率(t.get特別地域加算List().get特別地域加算_減額率() != null
                    ? new RString(String.valueOf(t.get特別地域加算List().get特別地域加算_減額率())).concat(率) : RString.EMPTY);
            特別地域加算減免情報.set確認番号(t.get特別地域加算List().get特別地域加算_確認番号());
            listEntity.add(特別地域加算減免情報);
        }
        return listEntity;
    }

    /**
     * set施設入退所情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 施設入退所情報EntityList
     * @return 施設入退所情報EntityList
     */
    public List<ShisetsuNyutaishojohoEntity> set施設入退所情報EntityList(IdoChushutsuDaichoNewEntity t, List<ShisetsuNyutaishojohoEntity> listEntity) {
        if (t.get施設入退所List() != null && t.get施設入退所List().get施設入退所_識別コード() != null
                && !t.get施設入退所List().get施設入退所_識別コード().isEmpty()) {
            ShisetsuNyutaishojohoEntity 施設入退所情報 = new ShisetsuNyutaishojohoEntity();
            施設入退所情報.set施設入退所区分(RString.EMPTY);
            施設入退所情報.set施設入所日(t.get施設入退所List().get施設入退所_入所年月日());
            施設入退所情報.set施設退所日(t.get施設入退所List().get施設入退所_退所年月日());
            施設入退所情報.set施設コード(t.get施設入退所List().get施設入退所_入所施設コード());
            施設入退所情報.set入所施設名称(t.get施設入退所List().get施設入退所_事業者名称());
            if (t.get施設入退所List().get施設入退所_電話番号() != null
                    && !t.get施設入退所List().get施設入退所_電話番号().isEmpty()) {
                施設入退所情報.set電話番号(t.get施設入退所List().get施設入退所_電話番号());
            }
            listEntity.add(施設入退所情報);
        }
        return listEntity;
    }

    /**
     * set居宅計画届出情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 居宅計画届出情報EntityList
     * @return 居宅計画届出情報EntityList
     */
    public List<ItakuKeikakuTodokedejohoEntity> set居宅計画届出情報EntityList(IdoChushutsuDaichoNewEntity t,
            List<ItakuKeikakuTodokedejohoEntity> listEntity) {
        if (t.get居宅計画届出List() != null && t.get居宅計画届出List().get居宅計画届出_被保険者番号() != null
                && !t.get居宅計画届出List().get居宅計画届出_被保険者番号().isEmpty()) {
            ItakuKeikakuTodokedejohoEntity 居宅計画届出情報 = new ItakuKeikakuTodokedejohoEntity();
            居宅計画届出情報.set居宅計画区分(RString.EMPTY);
            居宅計画届出情報.set対象年月(t.get居宅計画届出List().get居宅計画届出_対象年月());
            if (t.get居宅計画届出List().get居宅計画届出_届出区分() != null && !t.get居宅計画届出List().get居宅計画届出_届出区分().isEmpty()) {
                区分判定(居宅計画届出情報, t.get居宅計画届出List().get居宅計画届出_届出区分());
            }
            if (t.get居宅計画届出List().get居宅計画届出_作成区分コード() != null
                    && !t.get居宅計画届出List().get居宅計画届出_作成区分コード().isEmpty()) {
                居宅計画届出情報.set作成(t.get居宅計画届出List().get居宅計画届出_作成区分コード().equals(区分_3) ? new RString("自己作成") : RString.EMPTY);
            }
            居宅計画届出情報.set計画届出日(t.get居宅計画届出List().get居宅計画届出_届出年月日());
            居宅計画届出情報.set変更日(t.get居宅計画届出List().get居宅計画届出_計画変更年月日());
            居宅計画届出情報.set適用開始日(t.get居宅計画届出List().get居宅計画届出_適用開始年月日());
            居宅計画届出情報.set適用終了日(t.get居宅計画届出List().get居宅計画届出_適用終了年月日());
            居宅計画届出情報.set事業所番号(t.get居宅計画届出List().get居宅計画届出_計画事業者番号() != null
                    ? t.get居宅計画届出List().get居宅計画届出_計画事業者番号() : RString.EMPTY);
            居宅計画届出情報.set事業所名称(t.get居宅計画届出List().get居宅計画届出_事業者名称() != null
                    ? t.get居宅計画届出List().get居宅計画届出_事業者名称() : RString.EMPTY);
            居宅計画届出情報.set電話番号(t.get居宅計画届出List().get居宅計画届出_電話番号() != null
                    ? t.get居宅計画届出List().get居宅計画届出_電話番号() : RString.EMPTY);
            listEntity.add(居宅計画届出情報);
        }
        return listEntity;
    }

    /**
     * set特例施設入退所情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 特例施設入退所情報EntityList
     * @return 特例施設入退所情報EntityList
     */
    public List<TokureiShisetuNyutaishojohoEntity> set特例施設入退所情報EntityList(IdoChushutsuDaichoNewEntity t,
            List<TokureiShisetuNyutaishojohoEntity> listEntity) {
        if (t.get特例施設入退所List() != null && t.get特例施設入退所List().get特例施設入退所_事業者番号() != null
                && !t.get特例施設入退所List().get特例施設入退所_事業者番号().isEmpty()) {
            TokureiShisetuNyutaishojohoEntity 特例施設入退所情報 = new TokureiShisetuNyutaishojohoEntity();
            特例施設入退所情報.set特例施設入退所区分(RString.EMPTY);
            特例施設入退所情報.set入所日(t.get特例施設入退所List().get特例施設入退所_有効開始年月日());
            特例施設入退所情報.set退所日(t.get特例施設入退所List().get特例施設入退所_有効終了年月日());
            特例施設入退所情報.set事業所番号(t.get特例施設入退所List().get特例施設入退所_事業者番号());
            特例施設入退所情報.set事業所(t.get特例施設入退所List().get特例施設入退所_事業者名称());
            if (t.get特例施設入退所List().get特例施設入退所_電話番号() != null
                    && !t.get特例施設入退所List().get特例施設入退所_電話番号().isEmpty()) {
                特例施設入退所情報.set電話番号(t.get特例施設入退所List().get特例施設入退所_電話番号());
            }
            listEntity.add(特例施設入退所情報);
        }
        return listEntity;

    }

    /**
     * set支払方法変更情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 支払方法変更情報EntityList
     * @return 支払方法変更情報EntityList
     */
    public List<ShiharaHohoHenkojohoEntity> set支払方法変更情報EntityList(IdoChushutsuDaichoNewEntity t, List<ShiharaHohoHenkojohoEntity> listEntity) {
        if (t.get支払方法変更List() != null && t.get支払方法変更List().get支払方法変更_被保険者番号() != null
                && !t.get支払方法変更List().get支払方法変更_被保険者番号().isEmpty()) {
            ShiharaHohoHenkojohoEntity 支払方法変更情報 = new ShiharaHohoHenkojohoEntity();
            支払方法変更情報.set支払方法変更区分(RString.EMPTY);
            if (t.get支払方法変更List().get支払方法変更_登録区分() != null) {
                支払方法変更情報.set給付制限(t.get支払方法変更List().get支払方法変更_登録区分().equals(ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード())
                        ? ShiharaiHenkoTorokuKubun._空 : ShiharaiHenkoTorokuKubun.toValue(t.get支払方法変更List().get支払方法変更_登録区分()));
            }
            支払方法変更情報.set開始日(t.get支払方法変更List().get支払方法変更_適用開始年月日());
            支払方法変更情報.set終了日(t.get支払方法変更List().get支払方法変更_適用終了年月日());
            支払方法変更情報.set終了事由(ShiharaiHenkoShuryoKubun.toValue(t.get支払方法変更List().get支払方法変更_終了区分()));
            支払方法変更情報.set差止状況((t.get支払方法変更List().get支払方法変更_管理区分() != null
                    && t.get支払方法変更List().get支払方法変更_管理区分().equals(区分_2)) ? new RString("差止") : RString.EMPTY);
            支払方法変更情報.set提供年月(t.get支払方法変更List().get支払方法変更_差止サービス提供年月());
            支払方法変更情報.set整理番号(t.get支払方法変更List().get支払方法変更_差止償還整理番号());
            if (t.get支払方法変更List().get支払方法変更_差止解除年月日() != null) {
                支払方法変更情報.set控除(t.get支払方法変更List().get支払方法変更_差止解除年月日().isEmpty() ? RString.EMPTY : new RString("控除"));
            }
            listEntity.add(支払方法変更情報);
        }
        return listEntity;
    }

    /**
     * set給付額減額情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 給付額減額情報EntityList
     * @return 給付額減額情報EntityList
     */
    public List<KyufugakuGengakujohoEntity> set給付額減額情報EntityList(IdoChushutsuDaichoNewEntity t, List<KyufugakuGengakujohoEntity> listEntity) {
        if (t.get給付額減額情報List() != null && t.get給付額減額情報List().get給付額減額情報_被保険者番号() != null
                && !t.get給付額減額情報List().get給付額減額情報_被保険者番号().isEmpty()) {
            KyufugakuGengakujohoEntity 給付額減額情報 = new KyufugakuGengakujohoEntity();
            給付額減額情報.set給付額減額区分(RString.EMPTY);
            給付額減額情報.set給付制限(t.get給付額減額情報List().get給付額減額情報_登録区分().equals(ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード())
                    ? ShiharaiHenkoTorokuKubun._１号給付額減額登録 : ShiharaiHenkoTorokuKubun._空);
            給付額減額情報.set開始日(t.get給付額減額情報List().get給付額減額情報_適用開始年月日());
            給付額減額情報.set終了日(t.get給付額減額情報List().get給付額減額情報_適用終了年月日());
            給付額減額情報.set給付率(t.get給付額減額情報List().get給付額減額情報_給付率() == null
                    ? RString.EMPTY : new RString(t.get給付額減額情報List().get給付額減額情報_給付率().toString()).concat(率));
            給付額減額情報.set徴収権消滅期間(t.get給付額減額情報List().get給付額減額情報_徴収権消滅期間() == null
                    ? RString.EMPTY : new RString(t.get給付額減額情報List().get給付額減額情報_徴収権消滅期間().toString()));
            給付額減額情報.set納付済期間(t.get給付額減額情報List().get給付額減額情報_納付済期間() == null
                    ? RString.EMPTY : new RString(t.get給付額減額情報List().get給付額減額情報_納付済期間().toString()));
            給付額減額情報.set減額期間(t.get給付額減額情報List().get給付額減額情報_納付済減額期間() == null
                    ? RString.EMPTY : new RString(t.get給付額減額情報List().get給付額減額情報_納付済減額期間().toString()));
            listEntity.add(給付額減額情報);
        }
        return listEntity;
    }

    /**
     * set資格情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 資格情報EntityList
     * @return 資格情報EntityList
     */
    public List<ShikakujohoEntity> set資格情報EntityList(IdoChushutsuDaichoNewEntity t, List<ShikakujohoEntity> listEntity) {
        if (t.get資格情報List() != null && t.get資格情報List().get資格情報_被保険者番号() != null
                && !t.get資格情報List().get資格情報_被保険者番号().isEmpty()) {
            ShikakujohoEntity 資格情報 = new ShikakujohoEntity();
            資格情報.set資格区分(RString.EMPTY);
            資格情報.set資格取得日(t.get資格情報List().get資格情報_資格取得年月日());
            資格情報.set取得届出日(t.get資格情報List().get資格情報_資格取得届出年月日());
            if (t.get資格情報List().get資格情報_資格取得事由コード() != null && !t.get資格情報List().get資格情報_資格取得事由コード().isEmpty()) {
                資格情報.set取得事由(ShikakuShutokuJiyu.toValue(t.get資格情報List().get資格情報_資格取得事由コード()));
            }
            資格情報.set資格喪失日(t.get資格情報List().get資格情報_資格喪失年月日());
            資格情報.set喪失届出日(t.get資格情報List().get資格情報_資格喪失届出年月日());
            if (t.get資格情報List().get資格情報_資格喪失事由コード() != null && !t.get資格情報List().get資格情報_資格喪失事由コード().isEmpty()) {
                資格情報.set喪失事由(ShikakuSoshitsuJiyu.toValue(t.get資格情報List().get資格情報_資格喪失事由コード()));
            }
            資格情報.set変更年月日(t.get資格情報List().get資格情報_資格変更年月日());
            資格情報.set変更届出日(t.get資格情報List().get資格情報_資格変更届出年月日());
            if (t.get資格情報List().get資格情報_資格変更事由コード() != null && !t.get資格情報List().get資格情報_資格変更事由コード().isEmpty()) {
                資格情報.set変更事由(ShikakuHenkoJiyu.toValue(t.get資格情報List().get資格情報_資格変更事由コード()));
            }
            資格情報.set適用開始日(t.get資格情報List().get資格情報_適用年月日());
            資格情報.set適用届出日(t.get資格情報List().get資格情報_適用届出年月日());
            if (t.get資格情報List().get資格情報_住所地特例適用事由コード() != null && !t.get資格情報List().get資格情報_住所地特例適用事由コード().isEmpty()) {
                資格情報.set適用事由(ShikakuJutokuTekiyoJiyu.toValue(t.get資格情報List().get資格情報_住所地特例適用事由コード()));
            }

            資格情報.set解除開始日(t.get資格情報List().get資格情報_解除年月日());
            資格情報.set解除届出日(t.get資格情報List().get資格情報_解除届出年月日());
            if (t.get資格情報List().get資格情報_住所地特例解除事由コード() != null && !t.get資格情報List().get資格情報_住所地特例解除事由コード().isEmpty()) {
                資格情報.set解除事由(ShikakuJutokuKaijoJiyu.toValue(t.get資格情報List().get資格情報_住所地特例解除事由コード()));
            }
            listEntity.add(資格情報);
        }
        return listEntity;

    }

    /**
     * set老齢福祉年金情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 老齢福祉年金情報EntityList
     * @return 老齢福祉年金情報EntityList
     */
    public List<RoreiFukushiNenkinjohoEntity> set老齢福祉年金情報EntityList(IdoChushutsuDaichoNewEntity t, List<RoreiFukushiNenkinjohoEntity> listEntity) {
        if (t.get老齢福祉年金List() != null && t.get老齢福祉年金List().get老齢福祉年金_識別コード() != null
                && !t.get老齢福祉年金List().get老齢福祉年金_識別コード().isEmpty()) {
            RoreiFukushiNenkinjohoEntity 老齢福祉年金情報 = new RoreiFukushiNenkinjohoEntity();
            老齢福祉年金情報.set老齢福祉年金区分(RString.EMPTY);
            老齢福祉年金情報.set老福開始日(t.get老齢福祉年金List().get老齢福祉年金_受給開始年月日());
            老齢福祉年金情報.set老福終了日(t.get老齢福祉年金List().get老齢福祉年金_受給廃止年月日());
            listEntity.add(老齢福祉年金情報);
        }
        return listEntity;
    }

    /**
     * set生活保護情報EntityList
     *
     * @param t 受給者台帳
     * @param listEntity 生活保護情報EntityList
     * @return 生活保護情報EntityList
     */
    public List<SeikatsuHogojohoEntity> set生活保護情報EntityList(IdoChushutsuDaichoNewEntity t, List<SeikatsuHogojohoEntity> listEntity) {
        if (t.get生活保護情報List() != null && t.get生活保護情報List().get生活保護情報_識別コード() != null
                && !t.get生活保護情報List().get生活保護情報_識別コード().isEmpty()) {
            SeikatsuHogojohoEntity 生活保護情報 = new SeikatsuHogojohoEntity();
            生活保護情報.set生活保護区分(RString.EMPTY);
            生活保護情報.set生保開始日(t.get生活保護情報List().get生活保護情報_受給開始日());
            生活保護情報.set生保終了日(t.get生活保護情報List().get生活保護情報_受給廃止日());
            生活保護情報.set生保種別((t.get生活保護情報List().get生活保護情報_扶助種類コード() != null
                    && !t.get生活保護情報List().get生活保護情報_扶助種類コード().isEmpty())
                    ? SeikatsuHogoFujoShuruiCodeType.toValue(t.get生活保護情報List().get生活保護情報_扶助種類コード()).toRString() : RString.EMPTY);
            listEntity.add(生活保護情報);
        }
        return listEntity;
    }

    /**
     * update処理日付管理マスタ
     *
     * @param parameter 受給者台帳
     * @return dbT7022entity dbT7022entity
     */
    public ShoriDateKanriEntity update処理日付管理マスタ(IdoChushutsuDaichoProcessParameter parameter) {
        ShoriDateKanriEntity dbT7022entity = new ShoriDateKanriEntity();
        dbT7022entity.setSubGyomuCode(SubGyomuCode.DBD介護受給);
        dbT7022entity.setShoriName(ShoriName.受給者台帳.get名称());
        dbT7022entity.setShichosonCode(new LasdecCode(parameter.get市町村コード().toString()));
        dbT7022entity.setNendoNaiRenban(new RString("0001"));
        if (parameter.get今回抽出開始年月日() != null && parameter.get今回抽出開始時分秒() != null) {
            dbT7022entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.get今回抽出開始年月日(), parameter.get今回抽出開始時分秒()));
        }
        if (parameter.get今回抽出終了年月日() != null && parameter.get今回抽出終了時分秒() != null) {
            dbT7022entity.setTaishoShuryoTimestamp(new YMDHMS(parameter.get今回抽出終了年月日(), parameter.get今回抽出終了時分秒()));
        }
        dbT7022entity.setLastUpdateTimestamp(RDate.getNowDateTime());
        dbT7022entity.setLastUpdateReamsLoginId(ControlDataHolder.getUserId());
        return dbT7022entity;
    }

    /**
     * create検索条件一時テーブル情報
     *
     * @param t t
     * @param resultEntity resultEntity
     */
    public void create検索条件一時テーブル情報(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        set検索条件一時テーブル情報1(t, resultEntity);
        set検索条件一時テーブル情報2(t, resultEntity);
        set検索条件一時テーブル情報3(t, resultEntity);
        set検索条件一時テーブル情報4(t, resultEntity);
        set検索条件一時テーブル情報5(t, resultEntity);
        set検索条件一時テーブル情報6(t, resultEntity);
        set検索条件一時テーブル情報7(t, resultEntity);
        set検索条件一時テーブル情報8(t, resultEntity);
        set検索条件一時テーブル情報9(t, resultEntity);
    }

    private void 区分判定(ItakuKeikakuTodokedejohoEntity 居宅計画届出情報, RString 届出区分) {
        if (届出区分.equals(区分_1)) {
            居宅計画届出情報.set区分(new RString("新規"));
        } else if (届出区分.equals(区分_2)) {
            居宅計画届出情報.set区分(new RString("変更"));
        } else if (届出区分.equals(区分_3)) {
            居宅計画届出情報.set区分(new RString("暫定"));
        }
    }

    private void set先頭Entity(SentoEntity 先頭Entity, IdoChushutsuDaichoNewEntity t,
            DonyuKeitaiCode 導入形態コード, RString 保険者番号の取得, RString 保険者名称の取得,
            RString 通知文情報通知文) {
        先頭Entity.set保険者番号(保険者番号の取得);
        先頭Entity.set保険者名称(保険者名称の取得);
        if (導入形態コード.equals(DonyuKeitaiCode.事務構成市町村)
                || 導入形態コード.equals(DonyuKeitaiCode.事務広域)) {
            先頭Entity.set証記載保険者コード(new RString(t.get先頭情報().get受給者台帳_市町村コード().code市町村()));
            先頭Entity.set証記載保険者名(t.get先頭情報().getT7051_市町村名称());
        }
        if (導入形態コード.equals(DonyuKeitaiCode.事務単一)) {
            先頭Entity.set証記載保険者コード(保険者番号の取得);
            先頭Entity.set証記載保険者名(保険者名称の取得);
        }
        先頭Entity.set被保険者番号(t.get先頭情報().get受給者台帳_被保険者番号().value());
        先頭Entity.set被保険者名(t.get先頭情報().getPsm_名称());
        先頭Entity.set被保険者名カナ(t.get先頭情報().getPsm_カナ名称());
        先頭Entity.set性別((t.get先頭情報().getPsm_性別コード() != null && !t.get先頭情報().getPsm_性別コード().isEmpty())
                ? Seibetsu.toValue(t.get先頭情報().getPsm_性別コード()).get名称() : RString.EMPTY);
        先頭Entity.set生年月日(t.get先頭情報().getPsm_生年月日());
        先頭Entity.set住所コード(t.get先頭情報().getPsm_全国住所コード());
        先頭Entity.set住所(t.get先頭情報().getPsm_住所());
        先頭Entity.set世帯コード(t.get先頭情報().getPsm_世帯コード());
        先頭Entity.set住民コード((t.get先頭情報().getPsm_識別コード() != null
                && !t.get先頭情報().getPsm_識別コード().isEmpty()) ? t.get先頭情報().getPsm_識別コード().getColumnValue() : RString.EMPTY);
        先頭Entity設定(先頭Entity, t);
        先頭Entity.set備考(通知文情報通知文);
    }

    private void 先頭Entity設定(SentoEntity 先頭Entity, IdoChushutsuDaichoNewEntity t) {
        if (t.get先頭情報().get受給者台帳_データ区分() != null && !t.get先頭情報().get受給者台帳_データ区分().isEmpty()) {
            if (t.get先頭情報().get受給者台帳_データ区分().substring(0, 1).equals(区分_1)) {
                先頭Entity.set現状態(new RString("職権取消者"));
            } else if (t.get先頭情報().get受給者台帳_データ区分().substring(0, 1).equals(区分_2)
                    || t.get先頭情報().get受給者台帳_データ区分().substring(0, 1).equals(new RString("9"))) {
                先頭Entity.set現状態(new RString("受給資格者"));
            } else if (t.get先頭情報().get受給者台帳_データ区分().substring(0, 1).equals(区分_3)) {
                先頭Entity.set現状態(new RString("認定取消者"));
            } else if (t.get先頭情報().get受給者台帳_データ区分().substring(0, 1).equals(区分_4)) {
                先頭Entity.set現状態(new RString("申請取消者"));
            }
        }
        先頭Entity.set行政区コード(t.get先頭情報().getPsm_行政区コード());
        先頭Entity.set行政区名称(t.get先頭情報().getPsm_行政区名称());
        先頭Entity.set連絡先区分1(new RString("連絡先1"));
        if (t.get先頭情報().getPsm_連絡先1() != null
                && !t.get先頭情報().getPsm_連絡先1().isEmpty()) {
            先頭Entity.set連絡先1(t.get先頭情報().getPsm_連絡先1());
        }
        先頭Entity.set連絡先区分2(new RString("連絡先2"));
        if (t.get先頭情報().getPsm_連絡先2() != null
                && !t.get先頭情報().getPsm_連絡先2().isEmpty()) {
            先頭Entity.set連絡先2(t.get先頭情報().getPsm_連絡先2());
        }
        先頭Entity.set老健市町村コード(t.get先頭情報().getT7005_老人保健市町村コード());
        先頭Entity.set老健市町村名称(t.get先頭情報().getT7051_市町村名称());
        先頭Entity.set老健受給者番号(t.get先頭情報().getT7005_老人保健受給者番号());
        先頭Entity.set地区タイトル1(t.get先頭情報().getPsm_地区名1());
        先頭Entity.set地区タイトル2(t.get先頭情報().getPsm_地区名2());
        先頭Entity.set地区タイトル3(t.get先頭情報().getPsm_地区名3());
        先頭Entity.set地区コード1(t.get先頭情報().getPsm_地区コード1());
        先頭Entity.set地区コード2(t.get先頭情報().getPsm_地区コード2());
        先頭Entity.set地区コード3(t.get先頭情報().getPsm_地区コード3());
        if (t.get先頭情報().getX1008_医療保険種別コード() != null) {
            先頭Entity.set医療種別(CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.医療保険種類.getコード(),
                    new Code(t.get先頭情報().getX1008_医療保険種別コード()), FlexibleDate.getNowDate()));
        }
        先頭Entity.set医療保険者番号(t.get先頭情報().getX1008_医療保険者番号());
        先頭Entity.set医療保険者名称(t.get先頭情報().getX1008_医療保険者名称());
        先頭Entity.set記号番号(t.get先頭情報().getX1008_医療保険記号番号());
        先頭Entity.set直近管理票(t.get先頭情報().getX3015_サービス提供年月());
        先頭Entity.set直近実績(t.get先頭情報().getX3017_サービス提供年月());
        先頭Entity.set直近高額(t.get先頭情報().getX3056_サービス提供年月());
        先頭Entity.set直近償還(t.get先頭情報().getX3034_サービス提供年月());
        if (t.get先頭情報().getX2002_調定年度() != null && !t.get先頭情報().getX2002_調定年度().isEmpty()
                && t.get先頭情報().getX2002_保険料段階() != null && !t.get先頭情報().getX2002_保険料段階().isEmpty()) {
            先頭Entity.set直近所得段階(new FlexibleYear(t.get先頭情報().getX2002_調定年度()).wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString()
                    .concat(RString.HALF_SPACE).concat(new RString("第"))
                    .concat(t.get先頭情報().getX2002_保険料段階()).concat(new RString("段階")));
        }
        先頭Entity.set調査先住所(t.get先頭情報().getT4101_訪問調査先郵便番号());
        先頭Entity.set調査先名称(t.get先頭情報().getT4101_訪問調査先名称());
        if (t.get先頭情報().getT4101_訪問調査先電話番号() != null
                && !t.get先頭情報().getT4101_訪問調査先電話番号().isEmpty()) {
            先頭Entity.set調査先電話番号(t.get先頭情報().getT4101_訪問調査先電話番号());
        }
    }

    private void set広域単一(DonyuKeitaiCode 導入形態コード, NinteiKekkaJohoEntity 要介護認定, IdoChushutsuDaichoNewEntity t) {
        if (導入形態コード.equals(DonyuKeitaiCode.事務構成市町村)
                || 導入形態コード.equals(DonyuKeitaiCode.事務広域)) {
            set広域(要介護認定, t);
        }
        if (導入形態コード.equals(DonyuKeitaiCode.事務単一)) {
            set単一(要介護認定, t);
        }
    }

    private void set広域(NinteiKekkaJohoEntity 要介護認定, IdoChushutsuDaichoNewEntity t) {
        要介護認定.set認定申請日(t.get要介護認定情報().getT4003_認定申請日());
        要介護認定.set調査依頼日(t.get要介護認定情報().getT4003_調査委託年月日());
        要介護認定.set調査実施日(t.get要介護認定情報().getT4003_調査終了年月日());
        要介護認定.set医師依頼日(t.get要介護認定情報().getT4003_意見書依頼年月日());
        要介護認定.set医師取寄日(t.get要介護認定情報().getT4003_意見書取寄せ年月日());
        要介護認定.set資料作成日(t.get要介護認定情報().getT4003_審査会資料作成年月日());
        要介護認定.set審査予定日(t.get要介護認定情報().getT4003_審査会予定年月日());
        要介護認定.set二次判定日(t.get要介護認定情報().getT4003_二次判定日());
        if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_99A)) {
            要介護認定.set一次要介護度(t.get要介護認定情報().getT4003_一次判定結果() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode99
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果()).get名称()) : RString.EMPTY);
            要介護認定.set一次要介護度_重(t.get要介護認定情報().getT4003_一次判定結果重み() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode99
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果重み()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_02A)) {
            要介護認定.set一次要介護度(t.get要介護認定情報().getT4003_一次判定結果() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode02
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果()).get名称()) : RString.EMPTY);
            要介護認定.set一次要介護度_重(t.get要介護認定情報().getT4003_一次判定結果重み() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode02
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果重み()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_06A)) {
            要介護認定.set一次要介護度(t.get要介護認定情報().getT4003_一次判定結果() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode06
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果()).get名称()) : RString.EMPTY);
            要介護認定.set一次要介護度_重(t.get要介護認定情報().getT4003_一次判定結果重み() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode06
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果重み()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_09A)
                || t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_09B)) {
            要介護認定.set一次要介護度(t.get要介護認定情報().getT4003_一次判定結果() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode09
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果()).get名称()) : RString.EMPTY);
            要介護認定.set一次要介護度_重(t.get要介護認定情報().getT4003_一次判定結果重み() != null
                    ? 要介護認定一次判定結果コード.concat(IchijiHanteiKekkaCode09
                            .toValue(t.get要介護認定情報().getT4003_一次判定結果重み()).get名称()) : RString.EMPTY);
        }
        要介護認定.set一次判定日(t.get要介護認定情報().getT4003_一次判定日());
        要介護認定.set特定疾病(t.get要介護認定情報().getT4003_特定疾病コード() != null
                ? TokuteiShippei.toValue(t.get要介護認定情報().getT4003_特定疾病コード()).get名称() : RString.EMPTY);
        要介護認定.set調査委託先コード(t.get要介護認定情報().getT4003_調査委託先コード());
        要介護認定.set調査員コード(t.get要介護認定情報().getT4003_調査員コード());
        要介護認定.set主治医医療機関コード(t.get要介護認定情報().getT4003_医療機関コード());
        要介護認定.set主治医コード(t.get要介護認定情報().getT4003_主治医コード());
        要介護認定.set認定審査会意見(t.get要介護認定情報().getT4003_審査会意見());
    }

    private void set単一(NinteiKekkaJohoEntity 要介護認定, IdoChushutsuDaichoNewEntity t) {
        要介護認定.set認定申請日(t.get要介護認定情報().getT4101_認定申請年月日());
        要介護認定.set調査依頼日(t.get要介護認定情報().getX4102_認定調査依頼年月日());
        要介護認定.set調査実施日(t.get要介護認定情報().getX4102_認定調査実施年月日());
        要介護認定.set医師依頼日(t.get要介護認定情報().getX4102_主治医意見書作成依頼年月日());
        要介護認定.set医師取寄日(t.get要介護認定情報().getX4102_主治医意見書受領年月日());
        要介護認定.set資料作成日(t.get要介護認定情報().getX4102_介護認定審査会資料作成年月日());
        要介護認定.set審査予定日(t.get要介護認定情報().getT4123_認定審査会予定年月日());
        要介護認定.set二次判定日(t.get要介護認定情報().getX4102_二次判定年月日());
        if (t.get要介護認定情報().getX4102_要介護認定一次判定結果コード() != null) {
            set一次要介護度(要介護認定, t);
        }
        if (t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算() != null) {
            set一次要介護度_重(要介護認定, t);
        }
        要介護認定.set一次判定日(t.get要介護認定情報().getX4102_要介護認定一次判定年月日() != null
                ? t.get要介護認定情報().getX4102_要介護認定一次判定年月日() : FlexibleDate.EMPTY);
        要介護認定.set特定疾病(t.get要介護認定情報().getT4101_２号特定疾病コード() != null
                ? TokuteiShippei.toValue(t.get要介護認定情報().getT4101_２号特定疾病コード()).get名称() : RString.EMPTY);
        要介護認定.set調査委託先コード(t.get要介護認定情報().getT4101_認定調査委託先コード() != null
                ? t.get要介護認定情報().getT4101_認定調査委託先コード() : RString.EMPTY);
        要介護認定.set調査員コード(t.get要介護認定情報().getT4101_認定調査員コード());
        要介護認定.set主治医医療機関コード(t.get要介護認定情報().getT4101_主治医医療機関コード());
        要介護認定.set主治医コード(t.get要介護認定情報().getT4101_主治医コード());
        要介護認定.set認定審査会意見(t.get要介護認定情報().getX4102_介護認定審査会意見());
    }

    private void set要介護度(NinteiKekkaJohoEntity 要介護認定, IdoChushutsuDaichoNewEntity t) {
        if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_99A)) {
            要介護認定.set要介護度(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード1() != null
                    ? 要介護状態区分コード.concat(YokaigoJotaiKubun99
                            .toValue(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード1()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_02A)) {
            要介護認定.set要介護度(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード1() != null
                    ? 要介護状態区分コード.concat(YokaigoJotaiKubun02
                            .toValue(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード1()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_06A)) {
            要介護認定.set要介護度(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード1() != null
                    ? 要介護状態区分コード.concat(YokaigoJotaiKubun06
                            .toValue(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード1()).get名称()) : RString.EMPTY);
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_09A)
                || t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_09B)) {
            要介護認定.set要介護度(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード1() != null
                    ? 要介護状態区分コード.concat(YokaigoJotaiKubun09
                            .toValue(t.get要介護認定情報().get受給者台帳_要介護認定状態区分コード1()).get名称()) : RString.EMPTY);
        }
    }

    private void 要介護認定情報設定(NinteiKekkaJohoEntity 要介護認定, IdoChushutsuDaichoNewEntity t) {
        if (t.get要介護認定情報().get受給者台帳_データ区分1() != null && !t.get要介護認定情報().get受給者台帳_データ区分1().isEmpty()) {
            要介護認定.set異動事由(Datakubun.toValue(t.get要介護認定情報().get受給者台帳_データ区分1()).get名称());
        }
        set要介護度(要介護認定, t);
        要介護認定.set認定開始日(t.get要介護認定情報().get受給者台帳_認定有効期間開始年月日1());
        要介護認定.set認定終了日(t.get要介護認定情報().get受給者台帳_認定有効期間終了年月日1());
        if (t.get要介護認定情報().get受給者台帳_支給限度単位数1() != null) {
            要介護認定.set訪問限度額(DecimalFormatter.toコンマ区切りRString(t.get要介護認定情報().get受給者台帳_支給限度単位数1(), 0)
                    .concat(new RString("単位")));
        }
        要介護認定.set訪問開始日(t.get要介護認定情報().get受給者台帳_支給限度有効開始年月日1());
        要介護認定.set訪問終了日(t.get要介護認定情報().get受給者台帳_支給限度有効終了年月日1());
        if (t.get要介護認定情報().get受給者台帳_短期入所支給限度日数1() != null) {
            要介護認定.set短期限度額(DecimalFormatter.toコンマ区切りRString(t.get要介護認定情報().get受給者台帳_短期入所支給限度日数1(), 0)
                    .concat(new RString("日")));
        }
        要介護認定.set短期開始日(t.get要介護認定情報().get受給者台帳_短期入所支給限度開始年月日1());
        要介護認定.set短期終了日(t.get要介護認定情報().get受給者台帳_短期入所支給限度終了年月日1());
    }

    private void set一次要介護度(NinteiKekkaJohoEntity 要介護認定, IdoChushutsuDaichoNewEntity t) {
        if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_99A)) {
            要介護認定.set一次要介護度(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode99.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_02A)) {
            要介護認定.set一次要介護度(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode02.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_06A)) {
            要介護認定.set一次要介護度(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode06.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_09A)
                || t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_09B)) {
            要介護認定.set一次要介護度(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode09.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード()).get名称()));
        }
    }

    private void set一次要介護度_重(NinteiKekkaJohoEntity 要介護認定, IdoChushutsuDaichoNewEntity t) {
        if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_99A)) {
            要介護認定.set一次要介護度_重(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode99.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_02A)) {
            要介護認定.set一次要介護度_重(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode02.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_06A)) {
            要介護認定.set一次要介護度_重(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode06.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算()).get名称()));
        } else if (t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_09A)
                || t.get要介護認定情報().getT4101_厚労省IF識別コード1().equals(区分_09B)) {
            要介護認定.set一次要介護度_重(要介護認定一次判定結果コード
                    .concat(IchijiHanteiKekkaCode09.toValue(t.get要介護認定情報().getX4102_要介護認定一次判定結果コード認知症加算()).get名称()));
        }
    }

    private void set検索条件一時テーブル情報1(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        resultEntity.setTemp_T4001shichosonCode((t.get受給者台帳_市町村コード() != null && !t.get受給者台帳_市町村コード().isEmpty())
                ? t.get受給者台帳_市町村コード() : LasdecCode.EMPTY);
        resultEntity.setTemp_T4001hihokenshaNo((t.get受給者台帳_被保険者番号() != null && !t.get受給者台帳_被保険者番号().isEmpty())
                ? t.get受給者台帳_被保険者番号() : HihokenshaNo.EMPTY);
        resultEntity.setTemp_T4001rirekiNo(t.get受給者台帳_履歴番号());
        resultEntity.setTemp_T4001edaban(t.get受給者台帳_枝番());
        resultEntity.setTemp_T4001shikibetsuCode((t.get受給者台帳_識別コード() != null && !t.get受給者台帳_識別コード().isEmpty())
                ? t.get受給者台帳_識別コード() : ShikibetsuCode.EMPTY);
        resultEntity.setTemp_T4001ninteiYMD((t.get受給者台帳_認定年月日() != null && !t.get受給者台帳_認定年月日().isEmpty())
                ? t.get受給者台帳_認定年月日() : FlexibleDate.EMPTY);
        resultEntity.setTemp_T4001jukyuShinseiJiyu((t.get受給者台帳_受給申請事由() != null && !t.get受給者台帳_受給申請事由().isEmpty())
                ? t.get受給者台帳_受給申請事由() : Code.EMPTY);
        resultEntity.setTemp_T4001dataKubun((t.get受給者台帳_データ区分() != null && !t.get受給者台帳_データ区分().isEmpty())
                ? t.get受給者台帳_データ区分() : RString.EMPTY);
        resultEntity.setTemp_T4001yokaigoJotaiKubunCode((t.get受給者台帳_要介護認定状態区分コード() != null
                && !t.get受給者台帳_要介護認定状態区分コード().isEmpty())
                ? t.get受給者台帳_要介護認定状態区分コード() : RString.EMPTY);
        resultEntity.setTemp_T4001ninteiYukoKikanKaishiYMD((t.get受給者台帳_認定有効期間開始年月日() != null
                && !t.get受給者台帳_認定有効期間開始年月日().isEmpty())
                ? t.get受給者台帳_認定有効期間開始年月日() : FlexibleDate.EMPTY);
    }

    private void set検索条件一時テーブル情報2(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        resultEntity.setTemp_T4001ninteiYukoKikanShuryoYMD((t.get受給者台帳_認定有効期間終了年月日() != null
                && !t.get受給者台帳_認定有効期間終了年月日().isEmpty())
                ? t.get受給者台帳_認定有効期間終了年月日() : FlexibleDate.EMPTY);
        resultEntity.setTemp_T4001shikyuGendoTanisu(t.get受給者台帳_支給限度単位数());
        resultEntity.setTemp_T4001shikyuGendoKaishiYMD((t.get受給者台帳_支給限度有効開始年月日() != null
                && !t.get受給者台帳_支給限度有効開始年月日().isEmpty())
                ? t.get受給者台帳_支給限度有効開始年月日() : FlexibleDate.EMPTY);
        resultEntity.setTemp_T4001shikyuGendoShuryoYMD((t.get受給者台帳_支給限度有効終了年月日() != null
                && !t.get受給者台帳_支給限度有効終了年月日().isEmpty())
                ? t.get受給者台帳_支給限度有効終了年月日() : FlexibleDate.EMPTY);
        resultEntity.setTemp_T4001tankiSikyuGendoNissu(t.get受給者台帳_短期入所支給限度日数());
        resultEntity.setTemp_T4001tankiShikyuGendoKaishiYMD((t.get受給者台帳_短期入所支給限度開始年月日() != null
                && !t.get受給者台帳_短期入所支給限度開始年月日().isEmpty())
                ? t.get受給者台帳_短期入所支給限度開始年月日() : FlexibleDate.EMPTY);
        resultEntity.setTemp_T4001tankiShikyuGendoShuryoYMD((t.get受給者台帳_短期入所支給限度終了年月日() != null
                && !t.get受給者台帳_短期入所支給限度終了年月日().isEmpty())
                ? t.get受給者台帳_短期入所支給限度終了年月日() : FlexibleDate.EMPTY);
        resultEntity.setTemp_T4001kyuSochishaFlag(t.is受給者台帳_旧措置者フラグ());
        resultEntity.setTemp_T4001soshitsuYMD((t.get受給者台帳_喪失年月日() != null && !t.get受給者台帳_喪失年月日().isEmpty())
                ? t.get受給者台帳_喪失年月日() : FlexibleDate.EMPTY);
        resultEntity.setTemp_T4001shikakuShutokuMaeShinseiFlag(t.is受給者台帳_資格取得前申請フラグ());
        resultEntity.setTemp_T4001jukyuShikakuShomeishoHakkoYMD1((t.get受給者台帳_受給資格証明書発行年月日１() != null
                && !t.get受給者台帳_受給資格証明書発行年月日１().isEmpty())
                ? t.get受給者台帳_受給資格証明書発行年月日１() : FlexibleDate.EMPTY);
        resultEntity.setTemp_T4001jukyuShikakuShomeishoHakkoYMD2((t.get受給者台帳_受給資格証明書発行年月日２() != null
                && !t.get受給者台帳_受給資格証明書発行年月日２().isEmpty())
                ? t.get受給者台帳_受給資格証明書発行年月日２() : FlexibleDate.EMPTY);
    }

    private void set検索条件一時テーブル情報3(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        resultEntity.setTemp_T4001shinseishaKankeiCode((t.get受給者台帳_届出者申請者関係コード() != null
                && !t.get受給者台帳_届出者申請者関係コード().isEmpty())
                ? t.get受給者台帳_届出者申請者関係コード() : RString.EMPTY);
        resultEntity.setTemp_T4001homninKankei((t.get受給者台帳_届出者本人との関係() != null
                && !t.get受給者台帳_届出者本人との関係().isEmpty())
                ? t.get受給者台帳_届出者本人との関係() : RString.EMPTY);
        resultEntity.setT4101_shinseishoKanriNo((t.getT4101_申請書管理番号() != null && !t.getT4101_申請書管理番号().isEmpty())
                ? t.getT4101_申請書管理番号() : RString.EMPTY);
        resultEntity.setT4101_koroshoIfShikibetsuCode((t.getT4101_厚労省IF識別コード() != null
                && !t.getT4101_厚労省IF識別コード().isEmpty())
                ? t.getT4101_厚労省IF識別コード() : RString.EMPTY);
        resultEntity.setT4101_enkiTsuchiHakkoYMD((t.getT4101_延期通知発行年月日() != null && !t.getT4101_延期通知発行年月日().isEmpty())
                ? t.getT4101_延期通知発行年月日() : FlexibleDate.EMPTY);
        resultEntity.setT4101_enkiTsuchiHakkoKaisu(t.getT4101_延期通知発行回数());
    }

    private void set検索条件一時テーブル情報4(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        resultEntity.setT4101_shiteiiFlag(t.isT4101_指定医フラグ());
        resultEntity.setT4101_ninteiShinseiShinseijiKubunCode((t.getT4101_認定申請区分_申請時_コード() != null
                && !t.getT4101_認定申請区分_申請時_コード().isEmpty())
                ? t.getT4101_認定申請区分_申請時_コード() : RString.EMPTY);
        resultEntity.setT4101_ninteiShinseiHoreiKubunCode((t.getT4101_認定申請区分_法令_コード() != null
                && !t.getT4101_認定申請区分_法令_コード().isEmpty())
                ? t.getT4101_認定申請区分_法令_コード() : RString.EMPTY);
        resultEntity.setT4101_homonChosasakiYubinNo((t.getT4101_訪問調査先郵便番号() != null && !t.getT4101_訪問調査先郵便番号().isEmpty())
                ? t.getT4101_訪問調査先郵便番号() : RString.EMPTY);
        resultEntity.setT4101_homonChosasakiJusho((t.getT4101_訪問調査先住所() != null && !t.getT4101_訪問調査先住所().isEmpty())
                ? t.getT4101_訪問調査先住所() : RString.EMPTY);
        resultEntity.setT4101_homonChosasakiName((t.getT4101_訪問調査先名称() != null && !t.getT4101_訪問調査先名称().isEmpty())
                ? t.getT4101_訪問調査先名称() : RString.EMPTY);
        resultEntity.setT4101_homonChosasakiTelNo((t.getT4101_訪問調査先電話番号() != null && !t.getT4101_訪問調査先電話番号().isEmpty())
                ? t.getT4101_訪問調査先電話番号() : RString.EMPTY);
    }

    private void set検索条件一時テーブル情報5(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        resultEntity.setPsm_rirekiNo(t.getPsm_履歴番号());
        resultEntity.setPsm_kanjiShimei(t.getPsm_名称());
        resultEntity.setPsm_kanaShimei(t.getPsm_カナ名称());
        resultEntity.setPsm_honsekiZenkokuJushoCode(t.getPsm_全国住所コード());
        resultEntity.setPsm_honsekiJusho(t.getPsm_住所());
        resultEntity.setPsm_seibetsuCode(t.getPsm_性別コード());
        resultEntity.setPsm_seinengappiYMD(t.getPsm_生年月日());
        resultEntity.setPsm_setaiCode(t.getPsm_世帯コード());
        resultEntity.setPsm_shikibetsuCode(t.getPsm_識別コード());
        resultEntity.setPsm_gyoseikuCode(t.getPsm_行政区コード());
        resultEntity.setPsm_gyoseikuName(t.getPsm_行政区名称());
        resultEntity.setPsm_renrakusaki1(t.getPsm_連絡先1());
        resultEntity.setPsm_renrakusaki2(t.getPsm_連絡先2());
        resultEntity.setPsm_chikuCode1(t.getPsm_地区コード1());
        resultEntity.setPsm_chikuName1(t.getPsm_地区名1());
        resultEntity.setPsm_chikuCode2(t.getPsm_地区コード2());
        resultEntity.setPsm_chikuName2(t.getPsm_地区名2());
        resultEntity.setPsm_chikuCode3(t.getPsm_地区コード3());
        resultEntity.setPsm_chikuName3(t.getPsm_地区名3());
        resultEntity.setPsm_choikiCode(t.getPsm_町域コード());
        resultEntity.setPsm_shoriYMD(t.getPsm_処理年月日());
    }

    private void set検索条件一時テーブル情報6(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        resultEntity.setT7005_shikibetsuCode((t.getT7005_識別コード() != null && !t.getT7005_識別コード().isEmpty())
                ? t.getT7005_識別コード() : RString.EMPTY);
        resultEntity.setT7005_rojinHokenShichosonCode((t.getT7005_老人保健市町村コード() != null && !t.getT7005_老人保健市町村コード().isEmpty())
                ? t.getT7005_老人保健市町村コード() : RString.EMPTY);
        resultEntity.setT7005_rojinHokenJukyushaNo((t.getT7005_老人保健受給者番号() != null && !t.getT7005_老人保健受給者番号().isEmpty())
                ? t.getT7005_老人保健受給者番号() : RString.EMPTY);
        resultEntity.setT7051_shichosonShokibetsuID((t.getT7051_市町村識別ID() != null && !t.getT7051_市町村識別ID().isEmpty())
                ? t.getT7051_市町村識別ID() : RString.EMPTY);
        resultEntity.setT7051_shichosonMeisho((t.getT7051_市町村名称() != null && !t.getT7051_市町村名称().isEmpty())
                ? t.getT7051_市町村名称() : RString.EMPTY);
    }

    private void set検索条件一時テーブル情報7(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        resultEntity.setX1008_shikibetsuCode((t.getX1008_識別コード() != null && !t.getX1008_識別コード().isEmpty())
                ? t.getX1008_識別コード() : RString.EMPTY);
        resultEntity.setX1008_rirekiNo(t.getX1008_履歴番号());
        resultEntity.setX1008_iryoHokenShubetsuCode((t.getX1008_医療保険種別コード() != null && !t.getX1008_医療保険種別コード().isEmpty())
                ? t.getX1008_医療保険種別コード() : RString.EMPTY);
        resultEntity.setX1008_iryoHokenshaNo((t.getX1008_医療保険者番号() != null && !t.getX1008_医療保険者番号().isEmpty())
                ? t.getX1008_医療保険者番号() : RString.EMPTY);
        resultEntity.setX1008_iryoHokenshaMeisho((t.getX1008_医療保険者名称() != null && !t.getX1008_医療保険者名称().isEmpty())
                ? t.getX1008_医療保険者名称() : RString.EMPTY);
        resultEntity.setX1008_iryoHokenKigoNo((t.getX1008_医療保険記号番号() != null && !t.getX1008_医療保険記号番号().isEmpty())
                ? t.getX1008_医療保険記号番号() : RString.EMPTY);
    }

    private void set検索条件一時テーブル情報8(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        resultEntity.setX3015_serviceTeikyoYM((t.getX3015_サービス提供年月() != null && !t.getX3015_サービス提供年月().isEmpty())
                ? t.getX3015_サービス提供年月() : FlexibleYearMonth.EMPTY);
        resultEntity.setX3017_serviceTeikyoYM((t.getX3017_サービス提供年月() != null && !t.getX3017_サービス提供年月().isEmpty())
                ? t.getX3017_サービス提供年月() : FlexibleYearMonth.EMPTY);
        resultEntity.setX3056_hihokenshaNo((t.getX3056_被保険者番号() != null && !t.getX3056_被保険者番号().isEmpty())
                ? t.getX3056_被保険者番号() : RString.EMPTY);
        resultEntity.setX3056_serviceTeikyoYM((t.getX3056_サービス提供年月() != null && !t.getX3056_サービス提供年月().isEmpty())
                ? t.getX3056_サービス提供年月() : FlexibleYearMonth.EMPTY);
        resultEntity.setX3056_shoKisaiHokenshaNo((t.getX3056_証記載保険者番号() != null && !t.getX3056_証記載保険者番号().isEmpty())
                ? t.getX3056_証記載保険者番号() : RString.EMPTY);
        resultEntity.setX3056_rirekiNo(t.getX3056_履歴番号());
        resultEntity.setX3034_hiHokenshaNo((t.getX3034_被保険者番号() != null && !t.getX3034_被保険者番号().isEmpty())
                ? t.getX3034_被保険者番号() : RString.EMPTY);
        resultEntity.setX3034_serviceTeikyoYM((t.getX3034_サービス提供年月() != null && !t.getX3034_サービス提供年月().isEmpty())
                ? t.getX3034_サービス提供年月() : FlexibleYearMonth.EMPTY);
        resultEntity.setX3034_seiriNo((t.getX3034_整理番号() != null && !t.getX3034_整理番号().isEmpty())
                ? t.getX3034_整理番号() : RString.EMPTY);
    }

    private void set検索条件一時テーブル情報9(SenTouEntity t, JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity) {
        resultEntity.setX2002_choteiNendo((t.getX2002_調定年度() != null && !t.getX2002_調定年度().isEmpty())
                ? t.getX2002_調定年度() : RString.EMPTY);
        resultEntity.setX2002_fukaNendo((t.getX2002_賦課年度() != null && !t.getX2002_賦課年度().isEmpty())
                ? t.getX2002_賦課年度() : RString.EMPTY);
        resultEntity.setX2002_tsuchishoNo((t.getX2002_通知書番号() != null && !t.getX2002_通知書番号().isEmpty())
                ? t.getX2002_通知書番号() : RString.EMPTY);
        resultEntity.setX2002_rirekiNo(t.getX2002_履歴番号());
        resultEntity.setX2002_hokenryoDankai((t.getX2002_保険料段階() != null && !t.getX2002_保険料段階().isEmpty())
                ? t.getX2002_保険料段階() : RString.EMPTY);
        resultEntity.setRank_number(t.getRank_number());
    }
}
