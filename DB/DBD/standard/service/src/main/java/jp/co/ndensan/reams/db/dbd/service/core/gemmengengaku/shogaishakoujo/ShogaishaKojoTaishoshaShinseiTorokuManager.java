/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shogaishakoujo;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujo;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujoToJotai;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 障がい者控除対象者申請登録の更新処理クラスです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
public class ShogaishaKojoTaishoshaShinseiTorokuManager {

    private final ShogaishaKoujoManager manager;
    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");

    /**
     * コンストラクタです。
     */
    ShogaishaKojoTaishoshaShinseiTorokuManager() {
        this.manager = ShogaishaKoujoManager.createInstance();
    }

    /**
     * 障がい者控除対象者申請登録のIntanceを作成します。
     *
     * @return ShogaishaKojoTaishoshaShinseiToroku
     */
    public static ShogaishaKojoTaishoshaShinseiTorokuManager createIntance() {
        return InstanceProvider.create(ShogaishaKojoTaishoshaShinseiTorokuManager.class);
    }

    /**
     * 更新処理です。
     *
     * @param 情報と状態ArrayList 情報と状態
     * @param is申請メニューID is申請メニューID
     */
    @Transaction
    public void 更新処理(ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList, boolean is申請メニューID) {
        boolean isすべて履歴番号変更 = false;
        if (!is申請メニューID && !情報と状態ArrayList.isEmpty()) {
            ShogaishaKoujoToJotai 情報と状態 = 情報と状態ArrayList.get(情報と状態ArrayList.size() - 1);
            if (!情報と状態.get状態().isEmpty() && 情報と状態.get新履歴番号() == 0) {
                isすべて履歴番号変更 = true;
            }
        }
        RString 障がい者控除コード = GemmenGengakuShurui.障がい者控除.getコード();
        for (ShogaishaKoujoToJotai 情報と状態 : 情報と状態ArrayList) {
            RString 状態 = 情報と状態.get状態();
            ShogaishaKoujo 障がい書控除申請登録情報 = 情報と状態.get障がい書控除申請登録情報();
            int 履歴番号 = 情報と状態.get新履歴番号();
            if (isすべて履歴番号変更) {
                履歴番号 = 履歴番号 + 1;
                if (状態_削除.equals(状態)) {
                    manager.delete障がい書控除申請登録情報By減免減額種類(障がい書控除申請登録情報, 障がい者控除コード);
                } else if (状態_追加.equals(状態)) {
                    manager.save(get障がい書控除申請登録情報ByChange履歴番号(障がい書控除申請登録情報, 履歴番号));
                } else {
                    manager.delete障がい書控除申請登録情報By減免減額種類(障がい書控除申請登録情報, 障がい者控除コード);
                    manager.save(get障がい書控除申請登録情報ByChange履歴番号(障がい書控除申請登録情報, 履歴番号));
                }
                continue;
            }
            if (状態_削除.equals(状態)) {
                manager.delete障がい書控除申請登録情報By減免減額種類(障がい書控除申請登録情報, 障がい者控除コード);
            } else if (状態_修正.equals(状態)) {
                if (履歴番号 == 障がい書控除申請登録情報.get履歴番号()) {
                    manager.save(障がい書控除申請登録情報);
                } else {
                    manager.delete障がい書控除申請登録情報By減免減額種類(障がい書控除申請登録情報, 障がい者控除コード);
                    manager.save(get障がい書控除申請登録情報ByChange履歴番号(障がい書控除申請登録情報, 履歴番号));
                }
            } else if (状態_追加.equals(状態)) {
                manager.save(get障がい書控除申請登録情報ByChange履歴番号(障がい書控除申請登録情報, 履歴番号));
            } else if (履歴番号 != 障がい書控除申請登録情報.get履歴番号()) {
                manager.delete障がい書控除申請登録情報By減免減額種類(障がい書控除申請登録情報, 障がい者控除コード);
                manager.save(get障がい書控除申請登録情報ByChange履歴番号(障がい書控除申請登録情報, 履歴番号));
            }
        }
    }

    private ShogaishaKoujo get障がい書控除申請登録情報ByChange履歴番号(ShogaishaKoujo 障がい書控除申請登録情報, int 履歴番号) {
        ShogaishaKoujo new障がい書控除申請登録情報
                = new ShogaishaKoujo(障がい書控除申請登録情報.get証記載保険者番号(), 障がい書控除申請登録情報.get被保険者番号(), 履歴番号);
        ShogaishaKoujoBuilder builder = new障がい書控除申請登録情報.createBuilderForEdit();
        GemmenGengakuShinsei 減免減額申請 = 障がい書控除申請登録情報.getGemmenGengakuShinseiList().get(0);
        GemmenGengakuShinsei new減免減額申請 = new GemmenGengakuShinsei(減免減額申請.get証記載保険者番号(),
                減免減額申請.get被保険者番号(), GemmenGengakuShurui.障がい者控除.getコード(), 履歴番号);
        GemmenGengakuShinseiBuilder 減免減額申請builder = new減免減額申請.createBuilderForEdit();
        set減免減額申請(減免減額申請builder, 減免減額申請);
        builder.setGemmenGengakuShinsei(減免減額申請builder.build());
        builder.set基準日(障がい書控除申請登録情報.get基準日());
        builder.set把握日(障がい書控除申請登録情報.get把握日());
        builder.set決定年月日(障がい書控除申請登録情報.get決定年月日());
        builder.set申請年月日(障がい書控除申請登録情報.get申請年月日());
        builder.set資格喪失年月日(障がい書控除申請登録情報.get資格喪失年月日());
        builder.set適用終了年月日(障がい書控除申請登録情報.get適用終了年月日());
        builder.set適用開始年月日(障がい書控除申請登録情報.get適用開始年月日());
        builder.set対象年度(障がい書控除申請登録情報.get対象年度());
        builder.set決定区分(障がい書控除申請登録情報.get決定区分());
        builder.set申請事由(障がい書控除申請登録情報.get申請事由());
        builder.set給付率(障がい書控除申請登録情報.get給付率());
        builder.set認定内容(障がい書控除申請登録情報.get認定内容());
        builder.set認定区分(障がい書控除申請登録情報.get認定区分());
        builder.set認知症高齢者の日常生活自立度コード(障がい書控除申請登録情報.get認知症高齢者の日常生活自立度コード());
        builder.set資格喪失事由コード(障がい書控除申請登録情報.get資格喪失事由コード());
        builder.set障がい高齢者の日常生活自立度コード(障がい書控除申請登録情報.get障がい高齢者の日常生活自立度コード());
        builder.set非承認理由(障がい書控除申請登録情報.get非承認理由());
        builder.set認定証発行対象外フラグ(障がい書控除申請登録情報.is認定証発行対象外フラグ());
        builder.set障がい者手帳有無(障がい書控除申請登録情報.is障がい者手帳有無());
        return builder.build();
    }

    private void set減免減額申請(GemmenGengakuShinseiBuilder builder, GemmenGengakuShinsei 減免減額申請) {
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
    }

}
