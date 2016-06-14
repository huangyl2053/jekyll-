/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shakaifukushihojinkeigen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigenBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shakaifukushihojinkeigen.ShakaifukuRiyoshaFutanKeigenToJotai;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenMapperParameter;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenManager;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 社会福祉法人等利用者負担軽減申請の更新処理クラスです。
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
public class ShakaiFukushiHojinKeigenManager {

    private final ShafukuRiyoshaFutanKeigenManager manager;
    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");
    private final RString 承認する = new RString("1");

    /**
     * コンストラクタです。
     */
    ShakaiFukushiHojinKeigenManager() {
        this.manager = ShafukuRiyoshaFutanKeigenManager.createInstance();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請のIntanceを作成します。
     *
     * @return ShakaiFukushiHojinKeigenManager
     */
    public static ShakaiFukushiHojinKeigenManager createIntance() {
        return InstanceProvider.create(ShakaiFukushiHojinKeigenManager.class);
    }

    /**
     * 更新処理です。
     *
     * @param 情報と状態ArrayList 情報と状態
     * @param isメニューID isメニューID
     */
    @Transaction
    public void 更新処理(ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList, boolean isメニューID) {
        boolean isすべて履歴番号変更 = false;
        if (!isメニューID && !情報と状態ArrayList.isEmpty()) {
            ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 = 情報と状態ArrayList.get(情報と状態ArrayList.size() - 1);
            if (!情報と状態.get状態().isEmpty() && 情報と状態.get新履歴番号() == 0) {
                isすべて履歴番号変更 = true;
            }
        }
        for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態ArrayList) {
            RString 状態 = 情報と状態.get状態();
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
            int 履歴番号 = 情報と状態.get新履歴番号();
            if (isすべて履歴番号変更) {
                履歴番号 = 履歴番号 + 1;
                if (状態_削除.equals(状態)) {
                    削除処理(社会福祉法人等利用者負担軽減情報);
                } else if (状態_追加.equals(状態)) {
                    追加処理(get社会福祉法人等利用者負担軽減情報ByChange履歴番号(社会福祉法人等利用者負担軽減情報, 履歴番号), isメニューID);
                } else {
                    削除処理(社会福祉法人等利用者負担軽減情報);
                    追加処理(get社会福祉法人等利用者負担軽減情報ByChange履歴番号(社会福祉法人等利用者負担軽減情報, 履歴番号), isメニューID);
                }
                continue;
            }
            if (状態_削除.equals(状態)) {
                削除処理(社会福祉法人等利用者負担軽減情報);
            } else if (状態_修正.equals(状態)) {
                if (履歴番号 == 社会福祉法人等利用者負担軽減情報.get履歴番号()) {
                    修正処理(社会福祉法人等利用者負担軽減情報, isメニューID);
                } else {
                    削除処理(社会福祉法人等利用者負担軽減情報);
                    追加処理(get社会福祉法人等利用者負担軽減情報ByChange履歴番号(社会福祉法人等利用者負担軽減情報, 履歴番号), isメニューID);
                }
            } else if (状態_追加.equals(状態)) {
                追加処理(get社会福祉法人等利用者負担軽減情報ByChange履歴番号(社会福祉法人等利用者負担軽減情報, 履歴番号), isメニューID);
            } else if (履歴番号 != 社会福祉法人等利用者負担軽減情報.get履歴番号()) {
                削除処理(社会福祉法人等利用者負担軽減情報);
                追加処理(get社会福祉法人等利用者負担軽減情報ByChange履歴番号(社会福祉法人等利用者負担軽減情報, 履歴番号), isメニューID);
            }
        }
    }

    private ShakaifukuRiyoshaFutanKeigen get社会福祉法人等利用者負担軽減情報ByChange履歴番号(
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報, int 履歴番号) {
        ShakaifukuRiyoshaFutanKeigen new社会福祉法人等利用者負担軽減情報 = new ShakaifukuRiyoshaFutanKeigen(
                社会福祉法人等利用者負担軽減情報.get証記載保険者番号(),
                社会福祉法人等利用者負担軽減情報.get被保険者番号(),
                履歴番号);
        ShakaifukuRiyoshaFutanKeigenBuilder builder = new社会福祉法人等利用者負担軽減情報.createBuilderForEdit();
        builder.set申請年月日(社会福祉法人等利用者負担軽減情報.get申請年月日());
        builder.set申請事由(社会福祉法人等利用者負担軽減情報.get申請事由());
        if (社会福祉法人等利用者負担軽減情報.get決定区分() != null) {
            builder.set決定区分(社会福祉法人等利用者負担軽減情報.get決定区分());
        }
        if (社会福祉法人等利用者負担軽減情報.get決定区分() != null) {
            builder.set決定年月日(社会福祉法人等利用者負担軽減情報.get決定年月日());
        }
        if (社会福祉法人等利用者負担軽減情報.get適用開始年月日() != null) {
            builder.set適用開始年月日(社会福祉法人等利用者負担軽減情報.get適用開始年月日());
        }
        if (社会福祉法人等利用者負担軽減情報.get適用終了年月日() != null) {
            builder.set適用終了年月日(社会福祉法人等利用者負担軽減情報.get適用終了年月日());
        }
        if (社会福祉法人等利用者負担軽減情報.get減免区分() != null) {
            builder.set減免区分(社会福祉法人等利用者負担軽減情報.get減免区分());
        }
        if (社会福祉法人等利用者負担軽減情報.get軽減率_分子() != null) {
            builder.set軽減率_分子(社会福祉法人等利用者負担軽減情報.get軽減率_分子());
        }
        if (社会福祉法人等利用者負担軽減情報.get軽減率_分母() != null) {
            builder.set軽減率_分母(社会福祉法人等利用者負担軽減情報.get軽減率_分母());
        }
        builder.set生保扶助見直し特例有無(社会福祉法人等利用者負担軽減情報.is生保扶助見直し特例有無());
        builder.set居宅サービス限定(社会福祉法人等利用者負担軽減情報.is居宅サービス限定());
        builder.set居住費_食費のみ(社会福祉法人等利用者負担軽減情報.is居住費_食費のみ());
        builder.set旧措置者ユニット型個室のみ(社会福祉法人等利用者負担軽減情報.is旧措置者ユニット型個室のみ());
        if (社会福祉法人等利用者負担軽減情報.get確認番号() != null) {
            builder.set確認番号(社会福祉法人等利用者負担軽減情報.get確認番号());
        }
        if (社会福祉法人等利用者負担軽減情報.get非承認理由() != null) {
            builder.set非承認理由(社会福祉法人等利用者負担軽減情報.get非承認理由());
        }
        builder.set生活保護受給有無(社会福祉法人等利用者負担軽減情報.is生活保護受給有無());
        builder.set老齢福祉年金受給有無(社会福祉法人等利用者負担軽減情報.is老齢福祉年金受給有無());
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 社会福祉法人等利用者負担軽減情報.getGemmenGengakuShinseiList();
        for (GemmenGengakuShinsei gemmenGengakuShinsei : gemmenGengakuShinseiList) {
            builder.setGemmenGengakuShinsei(get減免減額申請ByChange履歴番号(gemmenGengakuShinsei, 履歴番号));
        }
        return builder.build();
    }

    private GemmenGengakuShinsei get減免減額申請ByChange履歴番号(GemmenGengakuShinsei gemmenGengakuShinsei, int 履歴番号) {
        GemmenGengakuShinsei newGemmenGengakuShinsei = new GemmenGengakuShinsei(
                gemmenGengakuShinsei.get証記載保険者番号(),
                gemmenGengakuShinsei.get被保険者番号(),
                GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード(),
                履歴番号);
        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder = newGemmenGengakuShinsei.createBuilderForEdit();
        if (gemmenGengakuShinsei.get申請届出代行区分() != null) {
            gemmenGengakuShinseiBuilder.set申請届出代行区分(gemmenGengakuShinsei.get申請届出代行区分());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名(gemmenGengakuShinsei.get申請届出者氏名());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名カナ() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名カナ(gemmenGengakuShinsei.get申請届出者氏名カナ());
        }
        if (gemmenGengakuShinsei.get申請届出者続柄() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者続柄(gemmenGengakuShinsei.get申請届出者続柄());
        }
        if (gemmenGengakuShinsei.get申請届出代行事業者番号() != null && !gemmenGengakuShinsei.get申請届出代行事業者番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出代行事業者番号(gemmenGengakuShinsei.get申請届出代行事業者番号());
        }
        if (gemmenGengakuShinsei.get事業者区分() != null) {
            gemmenGengakuShinseiBuilder.set事業者区分(gemmenGengakuShinsei.get事業者区分());
        }
        if (gemmenGengakuShinsei.get申請届出者郵便番号() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者郵便番号(gemmenGengakuShinsei.get申請届出者郵便番号());
        }
        if (gemmenGengakuShinsei.get申請届出者住所() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者住所(gemmenGengakuShinsei.get申請届出者住所());
        }
        if (gemmenGengakuShinsei.get申請届出者電話番号() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者電話番号(gemmenGengakuShinsei.get申請届出者電話番号());
        }
        return gemmenGengakuShinseiBuilder.build();
    }

    private void 修正処理(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報, boolean isメニューID) {
        ShakaifukuRiyoshaFutanKeigen 修正社会福祉法人等利用者負担軽減情報
                = manager.get社会福祉法人等利用者負担軽減(ShafukuRiyoshaFutanKeigenMapperParameter.createSelectByKeyParam(
                                社会福祉法人等利用者負担軽減情報.get証記載保険者番号(),
                                社会福祉法人等利用者負担軽減情報.get被保険者番号(),
                                社会福祉法人等利用者負担軽減情報.get履歴番号()));
        ShakaifukuRiyoshaFutanKeigenBuilder builder = 修正社会福祉法人等利用者負担軽減情報.createBuilderForEdit();
        edit修正社会福祉法人等利用者負担軽減情報(社会福祉法人等利用者負担軽減情報, builder, isメニューID);
        List<GemmenGengakuShinsei> 減免減額申請リスト = 修正社会福祉法人等利用者負担軽減情報.getGemmenGengakuShinseiList();
        GemmenGengakuShinsei 減免減額申請 = get減免減額申請By減免減額種類(減免減額申請リスト, GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード());
        if (null == 減免減額申請) {
            減免減額申請 = new GemmenGengakuShinsei(
                    修正社会福祉法人等利用者負担軽減情報.get証記載保険者番号(),
                    修正社会福祉法人等利用者負担軽減情報.get被保険者番号(),
                    GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード(),
                    修正社会福祉法人等利用者負担軽減情報.get履歴番号());
        }
        builder.setGemmenGengakuShinsei(get修正減免減額申請(
                社会福祉法人等利用者負担軽減情報.getGemmenGengakuShinseiList().get(0),
                減免減額申請));
        manager.save(builder.build());
    }

    private GemmenGengakuShinsei get減免減額申請By減免減額種類(List<GemmenGengakuShinsei> 減免減額申請リスト, RString 減免減額種類) {
        if (null == 減免減額申請リスト) {
            return null;
        }
        for (GemmenGengakuShinsei 減免減額申請 : 減免減額申請リスト) {
            if (減免減額種類.equals(減免減額申請.get減免減額種類())) {
                return 減免減額申請;
            }
        }
        return null;
    }

    private void edit修正社会福祉法人等利用者負担軽減情報(
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報,
            ShakaifukuRiyoshaFutanKeigenBuilder builder, boolean isメニューID) {
        if (isメニューID) {
            builder.set申請年月日(社会福祉法人等利用者負担軽減情報.get申請年月日());
            if (社会福祉法人等利用者負担軽減情報.get申請事由() != null) {
                builder.set申請事由(社会福祉法人等利用者負担軽減情報.get申請事由());
            }
        } else {
            builder.set申請事由(社会福祉法人等利用者負担軽減情報.get申請事由());
            RString 決定区分 = 社会福祉法人等利用者負担軽減情報.get決定区分();
            builder.set決定区分(決定区分);
            builder.set決定年月日(社会福祉法人等利用者負担軽減情報.get決定年月日());
            if (承認する.equals(決定区分)) {
                builder.set生保扶助見直し特例有無(社会福祉法人等利用者負担軽減情報.is生保扶助見直し特例有無());
                builder.set減免区分(社会福祉法人等利用者負担軽減情報.get減免区分());
                builder.set軽減率_分子(社会福祉法人等利用者負担軽減情報.get軽減率_分子());
                builder.set軽減率_分母(社会福祉法人等利用者負担軽減情報.get軽減率_分母());
                builder.set適用開始年月日(社会福祉法人等利用者負担軽減情報.get適用開始年月日());
                builder.set適用終了年月日(社会福祉法人等利用者負担軽減情報.get適用終了年月日());
                builder.set居宅サービス限定(社会福祉法人等利用者負担軽減情報.is居宅サービス限定());
                builder.set居住費_食費のみ(社会福祉法人等利用者負担軽減情報.is居住費_食費のみ());
                builder.set旧措置者ユニット型個室のみ(社会福祉法人等利用者負担軽減情報.is旧措置者ユニット型個室のみ());
                builder.set確認番号(社会福祉法人等利用者負担軽減情報.get確認番号());
                builder.set非承認理由(RString.EMPTY);
            } else {
                builder.set非承認理由(null == 社会福祉法人等利用者負担軽減情報.get非承認理由()
                        ? RString.EMPTY : 社会福祉法人等利用者負担軽減情報.get非承認理由());
                builder.set生保扶助見直し特例有無(false);
                builder.set減免区分(RString.EMPTY);
                builder.set適用開始年月日(FlexibleDate.EMPTY);
                builder.set適用終了年月日(FlexibleDate.EMPTY);
                builder.set軽減率_分子(null);
                builder.set軽減率_分母(null);
                builder.set居宅サービス限定(false);
                builder.set居住費_食費のみ(false);
                builder.set旧措置者ユニット型個室のみ(false);
                builder.set確認番号(RString.EMPTY);
            }
        }
    }

    private GemmenGengakuShinsei get修正減免減額申請(
            GemmenGengakuShinsei 減免減額申請, GemmenGengakuShinsei 減免減額申請FromDb) {
        GemmenGengakuShinseiBuilder builder = 減免減額申請FromDb.createBuilderForEdit();
        if (減免減額申請.get事業者区分() != null) {
            builder.set事業者区分(減免減額申請.get事業者区分());
        } else {
            builder.set事業者区分(RString.EMPTY);
        }
        if (減免減額申請.get申請届出代行事業者番号() != null && !減免減額申請.get申請届出代行事業者番号().isEmpty()) {
            builder.set申請届出代行事業者番号(減免減額申請.get申請届出代行事業者番号());
        }
        if (減免減額申請.get申請届出代行区分() != null) {
            builder.set申請届出代行区分(減免減額申請.get申請届出代行区分());
        } else {
            builder.set申請届出代行区分(RString.EMPTY);
        }
        if (減免減額申請.get申請届出者住所() != null) {
            builder.set申請届出者住所(減免減額申請.get申請届出者住所());
        } else {
            builder.set申請届出者住所(AtenaJusho.EMPTY);
        }
        if (減免減額申請.get申請届出者氏名() != null) {
            builder.set申請届出者氏名(減免減額申請.get申請届出者氏名());
        } else {
            builder.set申請届出者氏名(AtenaMeisho.EMPTY);
        }
        if (減免減額申請.get申請届出者氏名カナ() != null) {
            builder.set申請届出者氏名カナ(減免減額申請.get申請届出者氏名カナ());
        } else {
            builder.set申請届出者氏名カナ(AtenaKanaMeisho.EMPTY);
        }
        if (減免減額申請.get申請届出者続柄() != null) {
            builder.set申請届出者続柄(減免減額申請.get申請届出者続柄());
        } else {
            builder.set申請届出者続柄(RString.EMPTY);
        }
        if (減免減額申請.get申請届出者郵便番号() != null) {
            builder.set申請届出者郵便番号(減免減額申請.get申請届出者郵便番号());
        } else {
            builder.set申請届出者郵便番号(YubinNo.EMPTY);
        }
        if (減免減額申請.get申請届出者電話番号() != null) {
            builder.set申請届出者電話番号(減免減額申請.get申請届出者電話番号());
        } else {
            builder.set申請届出者電話番号(TelNo.EMPTY);
        }
        return builder.build();
    }

    private void 削除処理(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報) {
        ShakaifukuRiyoshaFutanKeigen 削除社会福祉法人等利用者負担軽減情報
                = manager.get社会福祉法人等利用者負担軽減(ShafukuRiyoshaFutanKeigenMapperParameter.createSelectByKeyParam(
                                社会福祉法人等利用者負担軽減情報.get証記載保険者番号(),
                                社会福祉法人等利用者負担軽減情報.get被保険者番号(),
                                社会福祉法人等利用者負担軽減情報.get履歴番号()));
        manager.delete社会福祉法人等利用者負担軽減By減免減額種類(
                削除社会福祉法人等利用者負担軽減情報, GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード());
    }

    private void 追加処理(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報, boolean isメニューID) {
        if (isメニューID) {
            ShakaifukuRiyoshaFutanKeigen new社会福祉法人等利用者負担軽減情報 = new ShakaifukuRiyoshaFutanKeigen(
                    社会福祉法人等利用者負担軽減情報.get証記載保険者番号(),
                    社会福祉法人等利用者負担軽減情報.get被保険者番号(),
                    社会福祉法人等利用者負担軽減情報.get履歴番号());
            ShakaifukuRiyoshaFutanKeigenBuilder builder = new社会福祉法人等利用者負担軽減情報.createBuilderForEdit();
            builder.setGemmenGengakuShinsei(社会福祉法人等利用者負担軽減情報.getGemmenGengakuShinseiList().get(0));
            builder.set申請年月日(社会福祉法人等利用者負担軽減情報.get申請年月日());
            builder.set申請事由(社会福祉法人等利用者負担軽減情報.get申請事由());
            manager.save(builder.build());
        } else {
            manager.save(社会福祉法人等利用者負担軽減情報);
        }
    }
}
