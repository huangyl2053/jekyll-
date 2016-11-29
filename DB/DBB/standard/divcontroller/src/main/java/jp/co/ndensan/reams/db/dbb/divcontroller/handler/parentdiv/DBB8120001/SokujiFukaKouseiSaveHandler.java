/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8120001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.ChoteiJiyuParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.FukaJohoList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.KibetsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKousei;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbb.service.core.basic.GemmenManager;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.choteijiyu.ChoteiJiyuHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoGemmenTorikeshiShurui;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link SokujiFukaKouseiMainHandler}のHandlerクラスです。
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiFukaKouseiSaveHandler {

    private static final int NUMB_1 = 1;

    /**
     * 保存処理にする。
     *
     * @param is特殊処理 is特殊処理
     * @param 更正前 更正前
     * @param 更正後 更正後
     * @param 更正前後徴収方法 更正前後徴収方法
     * @return SokujiFukaKousei 即時賦課更正entity
     */
    public SokujiFukaKousei set保存処理(boolean is特殊処理,
            NendobunFukaList 更正前,
            NendobunFukaList 更正後,
            KoseiZengoChoshuHoho 更正前後徴収方法) {
        SokujiFukaKousei sokujiFukaKousei = new SokujiFukaKousei();
        if (is特殊処理) {
            FukaJoho fukaJoho = 更正後.get現年度().createBuilderForEdit()
                    .set職権区分(ShokkenKubun.該当.getコード()).build();
            ChoteiJiyuHantei choteiJiyuHantei = new ChoteiJiyuHantei();
            ChoteiJiyuParameter parameter = new ChoteiJiyuParameter();
            parameter.set現年度(更正前.get現年度());
            List<FukaJohoList> fukaJohoList = new ArrayList<>();
            FukaJohoList 更正後賦課の情報リスト = new FukaJohoList();
            更正後賦課の情報リスト.set現年度(fukaJoho);
            fukaJohoList.add(更正後賦課の情報リスト);
            parameter.set更正後賦課リスト(fukaJohoList);
            parameter.set更正前徴収方法(更正前後徴収方法.get更正前());
            parameter.set更正後徴収方法(更正前後徴収方法.get更正後());
            List<FukaJohoList> 調定事由リスト = choteiJiyuHantei.set調定事由(parameter);
            for (FukaJohoList 調定事由 : 調定事由リスト) {
                if (調定事由.get現年度().hasChanged()) {
                    更正後.set現年度(調定事由.get現年度());
                }
            }
        } else {
            boolean is調定事由を反映 = Boolean.FALSE;
            if (RString.isNullOrEmpty(更正後.get現年度().get調定事由1())) {
                is調定事由を反映 = Boolean.TRUE;
                更正後.get現年度().createBuilderForEdit().set調定事由1(ChoteiJiyuCode.期別修正による更正.getコード());
            }
            if (!is調定事由を反映 && RString.isNullOrEmpty(更正後.get現年度().get調定事由2())) {
                is調定事由を反映 = Boolean.TRUE;
                更正後.get現年度().createBuilderForEdit().set調定事由2(ChoteiJiyuCode.期別修正による更正.getコード());
            }
            if (!is調定事由を反映 && RString.isNullOrEmpty(更正後.get現年度().get調定事由3())) {
                is調定事由を反映 = Boolean.TRUE;
                更正後.get現年度().createBuilderForEdit().set調定事由3(ChoteiJiyuCode.期別修正による更正.getコード());
            }
            if (!is調定事由を反映 && RString.isNullOrEmpty(更正後.get現年度().get調定事由4())) {
                is調定事由を反映 = Boolean.TRUE;
                更正後.get現年度().createBuilderForEdit().set調定事由4(ChoteiJiyuCode.期別修正による更正.getコード());
            }
        }
        List<FukaJoho> 更新対象 = get更新対象(更正前, 更正後);
        sokujiFukaKousei.set賦課の情報リスト(更新対象);
        if (更正前後徴収方法.isHasChanged()) {
            sokujiFukaKousei.set更正後徴収方法(更正前後徴収方法.get更正後());
        }
        List<Gemmen> 減免の情報リスト = new ArrayList<>();
        GemmenManager gemmenManager = new GemmenManager();
        for (FukaJoho fukaJoho : 更新対象) {
            Decimal 減免額 = fukaJoho.get減免額() == null ? Decimal.ZERO : fukaJoho.get減免額();
            if (減免額.compareTo(Decimal.ONE) > 0) {
                Gemmen 減免情報 = gemmenManager.get介護賦課減免(fukaJoho.get調定年度(), fukaJoho.get賦課年度(), fukaJoho.get通知書番号());
                if (減免情報 == null) {
                    continue;
                }
                Gemmen 更新後の減免情報 = new Gemmen(減免情報.get調定年度(), 減免情報.get賦課年度(),
                        減免情報.get通知書番号(), 減免情報.get履歴番号().add(Decimal.ONE)).createBuilderForEdit().
                        set減免申請日(減免情報.get減免申請日()).
                        set減免決定日(減免情報.get減免決定日()).
                        set減免取消日(減免情報.get減免取消日()).
                        set減免状態区分(減免情報.get減免状態区分()).
                        set減免作成区分(減免情報.get減免作成区分()).
                        set申請事由(減免情報.get申請事由()).
                        set減免種類コード(減免情報.get減免種類コード()).
                        set減免事由(減免情報.get減免事由()).
                        set減免取消種類(new HokenryoGemmenTorikeshiShurui(減免情報.get減免取消種類コード())).
                        set減免取消事由(減免情報.get減免取消事由()).
                        set申請減免額(減免情報.get申請減免額()).
                        set決定減免額(fukaJoho.get減免額()).
                        set取消減免額(減免情報.get取消減免額()).build();
                減免の情報リスト.add(更新後の減免情報);
            }
        }
        sokujiFukaKousei.set減免の情報リスト(減免の情報リスト);
        return sokujiFukaKousei;
    }

    private List<FukaJoho> get更新対象(NendobunFukaList 更正前, NendobunFukaList 更正後) {
        List<FukaJoho> 更新対象 = new ArrayList<>();
        FukaJoho 更正前賦課;
        更正前賦課 = 更正前 == null ? null : 更正前.get現年度();
        if (更正後 != null && 更正後.get現年度() != null && is内容に異なる箇所がある(更正前賦課, 更正後.get現年度())) {
            boolean is履歴番号採番 = is履歴番号採番(更正前賦課, 更正後.get現年度());
            FukaJoho 現年度 = 更正後.get現年度();
            if (is履歴番号採番) {
                現年度 = get賦課の情報履歴番号採番(現年度);
            }
            更新対象.add(現年度);
        }
        更正前賦課 = 更正前 == null ? null : 更正前.get過年度1();
        if (更正後 != null && 更正後.get過年度1() != null && is内容に異なる箇所がある(更正前賦課, 更正後.get過年度1())) {
            boolean is履歴番号採番 = is履歴番号採番(更正前賦課, 更正後.get過年度1());
            FukaJoho 過年度1 = 更正後.get過年度1();
            if (is履歴番号採番) {
                過年度1 = get賦課の情報履歴番号採番(過年度1);
            }
            更新対象.add(過年度1);
        }
        更正前賦課 = 更正前 == null ? null : 更正前.get過年度2();
        if (更正後 != null && 更正後.get過年度2() != null && is内容に異なる箇所がある(更正前賦課, 更正後.get過年度2())) {
            boolean is履歴番号採番 = is履歴番号採番(更正前賦課, 更正後.get過年度2());
            FukaJoho 過年度2 = 更正後.get過年度2();
            if (is履歴番号採番) {
                過年度2 = get賦課の情報履歴番号採番(過年度2);
            }
            更新対象.add(過年度2);
        }
        return get更新対象追加(更正前, 更正後, 更正前賦課, 更新対象);
    }

    private List<FukaJoho> get更新対象追加(NendobunFukaList 更正前, NendobunFukaList 更正後, FukaJoho 更正前賦課, List<FukaJoho> 更新対象) {
        更正前賦課 = 更正前 == null ? null : 更正前.get過年度3();
        if (更正後 != null && 更正後.get過年度3() != null && is内容に異なる箇所がある(更正前賦課, 更正後.get過年度3())) {
            boolean is履歴番号採番 = is履歴番号採番(更正前賦課, 更正後.get過年度3());
            FukaJoho 過年度3 = 更正後.get過年度3();
            if (is履歴番号採番) {
                過年度3 = get賦課の情報履歴番号採番(過年度3);
            }
            更新対象.add(過年度3);
        }
        更正前賦課 = 更正前 == null ? null : 更正前.get過年度4();
        if (更正後 != null && 更正後.get過年度4() != null && is内容に異なる箇所がある(更正前賦課, 更正後.get過年度4())) {
            boolean is履歴番号採番 = is履歴番号採番(更正前賦課, 更正後.get過年度4());
            FukaJoho 過年度4 = 更正後.get過年度4();
            if (is履歴番号採番) {
                過年度4 = get賦課の情報履歴番号採番(過年度4);
            }
            更新対象.add(過年度4);
        }
        更正前賦課 = 更正前 == null ? null : 更正前.get過年度5();
        if (更正後 != null && 更正後.get過年度5() != null && is内容に異なる箇所がある(更正前賦課, 更正後.get過年度5())) {
            boolean is履歴番号採番 = is履歴番号採番(更正前賦課, 更正後.get過年度5());
            FukaJoho 過年度5 = 更正後.get過年度5();
            if (is履歴番号採番) {
                過年度5 = get賦課の情報履歴番号採番(過年度5);
            }
            更新対象.add(過年度5);
        }
        return 更新対象;
    }

    private FukaJoho get賦課の情報履歴番号採番(FukaJoho 賦課の情報) {
        FukaJohoBuilder fukaJohoBuilder = new FukaJoho(
                賦課の情報.get調定年度(),
                賦課の情報.get賦課年度(),
                賦課の情報.get通知書番号(),
                賦課の情報.get履歴番号() + NUMB_1).createBuilderForEdit().
                set被保険者番号(賦課の情報.get被保険者番号()).
                set識別コード(賦課の情報.get識別コード()).
                set世帯コード(賦課の情報.get世帯コード()).
                set世帯員数(賦課の情報.get世帯員数()).
                set資格取得日(賦課の情報.get資格取得日()).
                set資格取得事由(賦課の情報.get資格取得事由()).
                set資格喪失日(賦課の情報.get資格喪失日()).
                set資格喪失事由(賦課の情報.get資格喪失事由()).
                set生活保護扶助種類(賦課の情報.get生活保護扶助種類()).
                set生保開始日(賦課の情報.get生保開始日()).
                set生保廃止日(賦課の情報.get生保廃止日()).
                set老年開始日(賦課の情報.get老年開始日()).
                set老年廃止日(賦課の情報.get老年廃止日()).
                set賦課期日(賦課の情報.get賦課期日()).
                set課税区分(賦課の情報.get課税区分()).
                set世帯課税区分(賦課の情報.get世帯課税区分()).
                set合計所得金額(賦課の情報.get合計所得金額()).
                set公的年金収入額(賦課の情報.get公的年金収入額()).
                set保険料段階(賦課の情報.get保険料段階()).
                set保険料算定段階1(賦課の情報.get保険料算定段階1()).
                set算定年額保険料1(賦課の情報.get算定年額保険料1()).
                set月割開始年月1(賦課の情報.get月割開始年月1()).
                set月割終了年月1(賦課の情報.get月割終了年月1()).
                set保険料算定段階2(賦課の情報.get保険料算定段階2()).
                set算定年額保険料2(賦課の情報.get算定年額保険料2()).
                set月割開始年月2(賦課の情報.get月割開始年月2()).
                set月割終了年月2(賦課の情報.get月割終了年月2()).
                set調定日時(賦課の情報.get調定日時()).
                set調定事由1(賦課の情報.get調定事由1()).
                set調定事由2(賦課の情報.get調定事由2()).
                set調定事由3(賦課の情報.get調定事由3()).
                set調定事由4(賦課の情報.get調定事由4()).
                set更正月(賦課の情報.get更正月()).
                set減免前介護保険料_年額(賦課の情報.get減免前介護保険料_年額()).
                set減免額(賦課の情報.get減免額()).
                set確定介護保険料_年額(賦課の情報.get確定介護保険料_年額()).
                set保険料段階_仮算定時(賦課の情報.get保険料段階_仮算定時()).
                set徴収方法履歴番号(賦課の情報.get徴収方法履歴番号()).
                set異動基準日時(賦課の情報.get異動基準日時()).
                set口座区分(賦課の情報.get口座区分()).
                set境界層区分(賦課の情報.get境界層区分()).
                set職権区分(賦課の情報.get職権区分()).
                set賦課市町村コード(賦課の情報.get賦課市町村コード()).
                set特徴歳出還付額(賦課の情報.get特徴歳出還付額()).
                set普徴歳出還付額(賦課の情報.get普徴歳出還付額());
        List<Kibetsu> kibetsuList = 賦課の情報.getKibetsuList();
        for (Kibetsu kibetsu : kibetsuList) {
            ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(kibetsu.get調定ID().longValue());
            Kibetsu 介護期別 = new Kibetsu(
                    kibetsu.get調定年度(),
                    kibetsu.get賦課年度(),
                    kibetsu.get通知書番号(),
                    kibetsu.get履歴番号() + NUMB_1,
                    kibetsu.get徴収方法(),
                    kibetsu.get期()).createBuilderForEdit().
                    set調定ID(kibetsu.get調定ID()).
                    setKibetsu(kibetsu.getChoteiKyotsu(identifier)).build();
            fukaJohoBuilder.setKibetsu(介護期別);
        }
        return fukaJohoBuilder.build();
    }

    private boolean is内容に異なる箇所がある(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        if (更正前賦課 == null) {
            return 更正後賦課 != null;
        }
        return is介護賦課異なる1(更正前賦課, 更正後賦課)
                || is介護賦課異なる2(更正前賦課, 更正後賦課)
                || is介護賦課異なる3(更正前賦課, 更正後賦課)
                || is介護期別異なる(更正前賦課, 更正後賦課);
    }

    private boolean is介護期別異なる(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        for (Kibetsu kibetsu : 更正前賦課.getKibetsuList()) {
            ChoteiKyotsuIdentifier choteiKyotsuIdentifier = new ChoteiKyotsuIdentifier(kibetsu.get調定ID().longValue());
            ChoteiKyotsu 更正前介護期別 = kibetsu.getChoteiKyotsu(choteiKyotsuIdentifier);
            KibetsuIdentifier kibetsuIdentifier = new KibetsuIdentifier(更正後賦課.get調定年度(), 更正後賦課.get賦課年度(),
                    更正後賦課.get通知書番号(), 更正後賦課.get履歴番号(), kibetsu.get徴収方法(), kibetsu.get期());
            ChoteiKyotsu 更正後介護期別 = 更正後賦課.getKibetsu(kibetsuIdentifier).getChoteiKyotsu(choteiKyotsuIdentifier);
            if (is調定共通異なる(更正前介護期別, 更正後介護期別)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private boolean is調定共通異なる(ChoteiKyotsu 更正前介護期別, ChoteiKyotsu 更正後介護期別) {
        return is異なる(更正前介護期別.get収納ID().intValue(), 更正後介護期別.get収納ID().intValue())
                || is異なる(更正前介護期別.get会計年度(), 更正後介護期別.get会計年度())
                || is異なる(更正前介護期別.get処理年度(), 更正後介護期別.get処理年度())
                || is異なる(更正前介護期別.get処理番号(), 更正後介護期別.get処理番号())
                || is異なる(更正前介護期別.get更正回数(), 更正後介護期別.get更正回数())
                || is異なる(更正前介護期別.get調定事由コード(), 更正後介護期別.get調定事由コード())
                || is異なる(更正前介護期別.get調定年月日(), 更正後介護期別.get調定年月日())
                || is異なる(更正前介護期別.get調定額(), 更正後介護期別.get調定額())
                || is異なる(更正前介護期別.get消費税額(), 更正後介護期別.get消費税額())
                || is異なる(更正前介護期別.get納期限(), 更正後介護期別.get納期限())
                || is異なる(更正前介護期別.get法定納期限等(), 更正後介護期別.get法定納期限等())
                || (更正前介護期別.is賦課処理状況() != 更正後介護期別.is賦課処理状況());
    }

    private boolean is介護賦課異なる1(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        return is異なる(更正前賦課.get被保険者番号().getColumnValue(), 更正後賦課.get被保険者番号().getColumnValue())
                || is異なる(更正前賦課.get識別コード(), 更正後賦課.get識別コード())
                || is異なる(更正前賦課.get世帯コード(), 更正後賦課.get世帯コード())
                || is異なる(更正前賦課.get世帯員数(), 更正後賦課.get世帯員数())
                || is異なる(更正前賦課.get資格取得日(), 更正後賦課.get資格取得日())
                || is異なる(更正前賦課.get資格取得事由(), 更正後賦課.get資格取得事由())
                || is異なる(更正前賦課.get資格喪失日(), 更正後賦課.get資格喪失日())
                || is異なる(更正前賦課.get資格喪失事由(), 更正後賦課.get資格喪失事由())
                || is異なる(更正前賦課.get生活保護扶助種類(), 更正後賦課.get生活保護扶助種類())
                || is異なる(更正前賦課.get生保開始日(), 更正後賦課.get生保開始日())
                || is異なる(更正前賦課.get生保廃止日(), 更正後賦課.get生保廃止日())
                || is異なる(更正前賦課.get老年開始日(), 更正後賦課.get老年開始日())
                || is異なる(更正前賦課.get老年廃止日(), 更正後賦課.get老年廃止日())
                || is異なる(更正前賦課.get賦課期日(), 更正後賦課.get賦課期日())
                || is異なる(更正前賦課.get課税区分(), 更正後賦課.get課税区分())
                || is異なる(更正前賦課.get世帯課税区分(), 更正後賦課.get世帯課税区分())
                || is異なる(更正前賦課.get合計所得金額(), 更正後賦課.get合計所得金額())
                || is異なる(更正前賦課.get公的年金収入額(), 更正後賦課.get公的年金収入額());
    }

    private boolean is介護賦課異なる2(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        return is異なる(更正前賦課.get保険料段階(), 更正後賦課.get保険料段階())
                || is異なる(更正前賦課.get保険料算定段階1(), 更正後賦課.get保険料算定段階1())
                || is異なる(更正前賦課.get算定年額保険料1(), 更正後賦課.get算定年額保険料1())
                || is異なる(更正前賦課.get月割開始年月1(), 更正後賦課.get月割開始年月1())
                || is異なる(更正前賦課.get月割終了年月1(), 更正後賦課.get月割終了年月1())
                || is異なる(更正前賦課.get保険料算定段階2(), 更正後賦課.get保険料算定段階2())
                || is異なる(更正前賦課.get算定年額保険料2(), 更正後賦課.get算定年額保険料2())
                || is異なる(更正前賦課.get月割開始年月2(), 更正後賦課.get月割開始年月2())
                || is異なる(更正前賦課.get月割終了年月2(), 更正後賦課.get月割終了年月2())
                || is異なる(更正前賦課.get調定日時(), 更正後賦課.get調定日時())
                || is異なる(更正前賦課.get調定事由1(), 更正後賦課.get調定事由1())
                || is異なる(更正前賦課.get調定事由2(), 更正後賦課.get調定事由2())
                || is異なる(更正前賦課.get調定事由3(), 更正後賦課.get調定事由3())
                || is異なる(更正前賦課.get調定事由4(), 更正後賦課.get調定事由4())
                || is異なる(更正前賦課.get更正月(), 更正後賦課.get更正月())
                || is異なる(更正前賦課.get減免前介護保険料_年額(), 更正後賦課.get減免前介護保険料_年額())
                || is異なる(更正前賦課.get減免額(), 更正後賦課.get減免額())
                || is異なる(更正前賦課.get確定介護保険料_年額(), 更正後賦課.get確定介護保険料_年額());
    }

    private boolean is介護賦課異なる3(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        return is異なる(更正前賦課.get保険料段階(), 更正後賦課.get保険料段階())
                || is異なる(更正前賦課.get徴収方法履歴番号(), 更正後賦課.get徴収方法履歴番号())
                || is異なる(更正前賦課.get異動基準日時(), 更正後賦課.get異動基準日時())
                || is異なる(更正前賦課.get口座区分(), 更正後賦課.get口座区分())
                || is異なる(更正前賦課.get境界層区分(), 更正後賦課.get境界層区分())
                || is異なる(更正前賦課.get職権区分(), 更正後賦課.get職権区分())
                || is異なる(更正前賦課.get賦課市町村コード(), 更正後賦課.get賦課市町村コード())
                || is異なる(更正前賦課.get特徴歳出還付額(), 更正後賦課.get特徴歳出還付額())
                || is異なる(更正前賦課.get普徴歳出還付額(), 更正後賦課.get普徴歳出還付額());
    }

    private boolean is異なる(RString rstr1, RString rstr2) {
        if (RString.isNullOrEmpty(rstr1) && RString.isNullOrEmpty(rstr2)) {
            return Boolean.FALSE;
        }
        if (!RString.isNullOrEmpty(rstr1) && rstr1.equals(rstr2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(LasdecCode lasdecCode1, LasdecCode lasdecCode2) {
        if (lasdecCode1 == null && lasdecCode2 == null) {
            return Boolean.FALSE;
        }
        if (lasdecCode1 != null && lasdecCode1.getColumnValue().equals(lasdecCode2.getColumnValue())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(ShikibetsuCode code1, ShikibetsuCode code2) {
        if (code1 == null && code2 == null) {
            return Boolean.FALSE;
        }
        if (code1 != null && code1.getColumnValue().equals(code2.getColumnValue())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(SetaiCode code1, SetaiCode code2) {
        if (code1 == null && code2 == null) {
            return Boolean.FALSE;
        }
        if (code1 != null && code1.getColumnValue().equals(code2.getColumnValue())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(RDate date1, RDate date2) {
        if (date1 == null && date2 == null) {
            return Boolean.FALSE;
        }
        if (date1 != null && date1.equals(date2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(int num1, int num2) {
        return num1 != num2;
    }

    private boolean is異なる(long num1, long num2) {
        return num1 != num2;
    }

    private boolean is異なる(FlexibleDate date1, FlexibleDate date2) {
        if (date1 == null && date2 == null) {
            return Boolean.FALSE;
        }
        if (date1 != null && date1.equals(date2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(RYear date1, RYear date2) {
        if (date1 == null && date2 == null) {
            return Boolean.FALSE;
        }
        if (date1 != null && date1.equals(date2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(FlexibleYearMonth date1, FlexibleYearMonth date2) {
        if (date1 == null && date2 == null) {
            return Boolean.FALSE;
        }
        if (date1 != null && date1.equals(date2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(YMDHMS date1, YMDHMS date2) {
        if (date1 == null && date2 == null) {
            return Boolean.FALSE;
        }
        if (date1 != null && date1.equals(date2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(Decimal dec1, Decimal dec2) {
        if (dec1 == null && dec2 == null) {
            return Boolean.FALSE;
        }
        if (dec1 != null && dec1.equals(dec2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is履歴番号採番(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        if (更正前賦課 == null) {
            return false;
        }
        return 更正前賦課.get履歴番号() == 更正後賦課.get履歴番号();
    }
}
