/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.homonkaigogemmen;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuToJotai;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.homonkaigogemmen.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.homonkaigogemmen.IHomonKaigoRiryoshaFutangakuGengakuMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitFactory;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitKind;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 訪問介護利用者負担額減額申請（画面）です。
 *
 * @reamsid_L DBD-3730-030 wangjie2
 */
public class HomonKaigoRiryoshaFutangakuGengakuService {

    private final MapperProvider mapperProvider;
    private static final int 給付率_94 = 94;
    private static final int 給付率_97 = 97;
    private static final int 給付率_100 = 100;
    private static final int 減免期限_年 = 2003;
    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");

    /**
     * コンストラクタです。
     */
    HomonKaigoRiryoshaFutangakuGengakuService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 訪問介護利用者負担額減額申請（画面）のIntanceを作成します。
     *
     * @return HomonKaigoRiryoshaFutangakuGengakuService
     */
    public static HomonKaigoRiryoshaFutangakuGengakuService createIntance() {
        return InstanceProvider.create(HomonKaigoRiryoshaFutangakuGengakuService.class);
    }

    /**
     * 訪問介護利用者負担額減額情報の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List< 訪問介護利用者負担額減額の情報>
     */
    @Transaction
    public List<HomonKaigoRiyoshaFutangakuGengaku> load訪問介護利用者負担額減額申請All(HihokenshaNo 被保険者番号) {
        List<HomonKaigoRiyoshaFutangakuGengaku> 訪問介護利用者負担額減額の情報List = new ArrayList<>();
        ShakaiFukushiHojinKeigenParameter 検索条件 = new ShakaiFukushiHojinKeigenParameter(
                被保険者番号, GemmenGengakuShurui.訪問介護利用者負担額減額.getコード());
        IHomonKaigoRiryoshaFutangakuGengakuMapper mapper = mapperProvider.create(IHomonKaigoRiryoshaFutangakuGengakuMapper.class);
        List<HomonKaigoRiyoshaFutangakuGengakuEntity> entityList = mapper.get訪問介護利用者負担額減額の情報List(検索条件);
        if (entityList != null && !entityList.isEmpty()) {
            for (HomonKaigoRiyoshaFutangakuGengakuEntity entity : entityList) {
                訪問介護利用者負担額減額の情報List.add(new HomonKaigoRiyoshaFutangakuGengaku(entity));
            }
        }
        return 訪問介護利用者負担額減額の情報List;
    }

    /**
     * 指定の法別区分(DBDEnum.法別区分)より、公費負担者番号を生成して返します。
     *
     * @param 法別区分 法別区分
     * @return 公費負担者番号
     */
    public RString create公費負担者番号(HobetsuKubun 法別区分) {
        if (null == 法別区分) {
            return RString.EMPTY;
        }
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 地方公共団体コード = RString.EMPTY;
        if (地方公共団体 != null) {
            地方公共団体コード = 地方公共団体.get地方公共団体コード().code検査数字無しRString();
        }
        return appendModulus10(法別区分.getコード().concat(地方公共団体コード));
    }

    /**
     * 指定の文字列（数値のみ）に対して、モジュラス10により計算されるチェックディジットを付与して返却します。
     *
     * @param 対象文字列 対象文字列
     * @return チェックディジット付与後文字列
     */
    public RString appendModulus10(RString 対象文字列) {
        if (null == 対象文字列 || 対象文字列.isEmpty()) {
            return RString.EMPTY;
        }
        return CheckDigitFactory.getInstance(CheckDigitKind.Modulus10).appendModulus(対象文字列);
    }

    /**
     * 指定の法別区分(DBDEnum.法別区分)と適用日より、給付率を判断して返します。
     *
     * @param 法別区分 法別区分
     * @param 適用開始日 適用開始日
     * @return 給付率
     * @throws NullPointerException
     * パラメータのいずれかがnullの場合、NullPointerExceptionをスローする。
     * @throws IllegalArgumentException
     * 適用開始日.isEmpty()の場合、IllegalArgumentExceptionをスローする。
     */
    public int decide給付率(HobetsuKubun 法別区分, FlexibleDate 適用開始日) {
        requireNonNull(適用開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始日"));
        requireNonNull(法別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("法別区分"));
        if (適用開始日.isEmpty()) {
            throw new IllegalArgumentException("適用開始日");
        }
        if (HobetsuKubun.障害時ホームヘルプ.equals(法別区分)) {
            return 給付率_97;
        } else if (HobetsuKubun.障害ヘルプ全額免除.equals(法別区分)) {
            return 給付率_100;
        } else {
            RString 減免期限_月日
                    = DbBusinessConfig.get(ConfigNameDBD.減免期限_特別減免, new RDate(減免期限_年), SubGyomuCode.DBD介護受給);
            FlexibleDate 減免期限_年月日 = new FlexibleDate(new RString(減免期限_年).concat(減免期限_月日));
            if (適用開始日.isBeforeOrEquals(減免期限_年月日)) {
                return 給付率_97;
            }
            return 給付率_94;
        }
    }

    /**
     * 指定の適用日に対して、有効期限を判定し、返却します。
     *
     * @param 適用日 適用日
     * @return 有効期限
     */
    public FlexibleDate estimate有効期限(FlexibleDate 適用日) {
        if (null == 適用日 || 適用日.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        RString 減免期限_特別減免;
        try {
            減免期限_特別減免 = DbBusinessConfig.get(ConfigNameDBD.減免期限_特別減免, new RDate(適用日.toString()), SubGyomuCode.DBD介護受給);
        } catch (IllegalArgumentException e) {
            return FlexibleDate.EMPTY;
        }
        if (!減免期限_特別減免.isEmpty()) {
            FlexibleDate 有効期限候補 = new FlexibleDate(new RString(適用日.getYearValue()).concat(減免期限_特別減免));
            if (適用日.isBeforeOrEquals(有効期限候補)) {
                return 有効期限候補;
            }
            return 有効期限候補.plusYear(1);
        }
        return FlexibleDate.EMPTY;
    }

    /**
     * 指定の被保険者番号に対して、利用者となれるかどうかを判定し、返却します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 適用日 適用日
     * @return 有効期限
     */
    public boolean canBe利用者(HihokenshaNo 被保険者番号, FlexibleDate 適用日) {
        DbT4001JukyushaDaichoDac dbT4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        List<DbT4001JukyushaDaichoEntity> dbT4001EntityList
                = dbT4001Dac.selectfor受給者の判定(被保険者番号, 適用日, YukoMukoKubun.無効.getコード());
        if (!dbT4001EntityList.isEmpty()) {
            return true;
        }
        DbT3105SogoJigyoTaishoshaDac dbT3105Dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
        return !dbT3105Dac.selectFor総合事業対象者の判定(被保険者番号, 適用日).isEmpty();
    }

    /**
     * 更新処理です。
     *
     * @param 情報と状態ArrayList 情報と状態
     * @param is申請メニューID is申請メニューID
     * @param 最初申請一覧情報 最初申請一覧情報
     */
    @Transaction
    public void 更新処理(ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList,
            boolean is申請メニューID, List<HomonKaigoRiyoshaFutangakuGengaku> 最初申請一覧情報) {

        RString 訪問介護利用者負担額減額コード = GemmenGengakuShurui.訪問介護利用者負担額減額.getコード();
        HomonKaigoRiyoshaFutangakuGengakuManager manager = HomonKaigoRiyoshaFutangakuGengakuManager.createInstance();

        for (HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態 : 情報と状態ArrayList) {
            RString 状態 = 情報と状態.get状態();
            HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額情報 = 情報と状態.get訪問介護利用者負担額減額情報();
            if (!状態_追加.equals(状態)) {
                manager.delete訪問介護利用者負担額減額情報By減免減額種類(
                        get最初情報(最初申請一覧情報, 訪問介護利用者負担額減額情報), 訪問介護利用者負担額減額コード);
            }
        }

        for (HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態 : 情報と状態ArrayList) {
            RString 状態 = 情報と状態.get状態();
            HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額情報 = 情報と状態.get訪問介護利用者負担額減額情報();
            int 履歴番号 = 情報と状態.get新履歴番号();

            if (状態_追加.equals(状態) || 状態_修正.equals(状態)) {
                manager.save(get訪問介護利用者負担額減額情報ByChange履歴番号(訪問介護利用者負担額減額情報, 履歴番号, null));
            } else if (!状態_削除.equals(状態)) {
                manager.save(get訪問介護利用者負担額減額情報ByChange履歴番号(訪問介護利用者負担額減額情報,
                        履歴番号, get最初情報(最初申請一覧情報, 訪問介護利用者負担額減額情報)));
            }
        }
    }

    private HomonKaigoRiyoshaFutangakuGengaku get最初情報(List<HomonKaigoRiyoshaFutangakuGengaku> 最初申請一覧情報,
            HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額情報) {
        HomonKaigoRiyoshaFutangakuGengakuIdentifier id = 訪問介護利用者負担額減額情報.identifier();
        for (HomonKaigoRiyoshaFutangakuGengaku 最初申請情報 : 最初申請一覧情報) {
            if (id.equals(最初申請情報.identifier())) {
                return 最初申請情報;
            }
        }
        return null;
    }

    private HomonKaigoRiyoshaFutangakuGengaku get訪問介護利用者負担額減額情報ByChange履歴番号(
            HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額情報, int 履歴番号, HomonKaigoRiyoshaFutangakuGengaku 最初申請情報) {
        HomonKaigoRiyoshaFutangakuGengaku new訪問介護利用者負担額減額情報
                = new HomonKaigoRiyoshaFutangakuGengaku(訪問介護利用者負担額減額情報.get証記載保険者番号(),
                        訪問介護利用者負担額減額情報.get被保険者番号(), 履歴番号);
        HomonKaigoRiyoshaFutangakuGengakuBuilder builder = new訪問介護利用者負担額減額情報.createBuilderForEdit();
        if (null == 最初申請情報 || !最初申請情報.getGemmenGengakuShinseiList().isEmpty()) {
            GemmenGengakuShinsei 減免減額申請 = 訪問介護利用者負担額減額情報.getGemmenGengakuShinseiList().get(0);
            GemmenGengakuShinsei new減免減額申請 = new GemmenGengakuShinsei(減免減額申請.get証記載保険者番号(),
                    減免減額申請.get被保険者番号(), GemmenGengakuShurui.訪問介護利用者負担額減額.getコード(), 履歴番号);
            GemmenGengakuShinseiBuilder 減免減額申請builder = new減免減額申請.createBuilderForEdit();
            set減免減額申請(減免減額申請builder, 減免減額申請);
            builder.setGemmenGengakuShinsei(減免減額申請builder.build());
        }
        if (訪問介護利用者負担額減額情報.get決定年月日() != null) {
            builder.set決定年月日(訪問介護利用者負担額減額情報.get決定年月日());
        }
        builder.set申請年月日(訪問介護利用者負担額減額情報.get申請年月日());
        if (訪問介護利用者負担額減額情報.get適用終了年月日() != null) {
            builder.set適用終了年月日(訪問介護利用者負担額減額情報.get適用終了年月日());
        }
        if (訪問介護利用者負担額減額情報.get適用開始年月日() != null) {
            builder.set適用開始年月日(訪問介護利用者負担額減額情報.get適用開始年月日());
        }
        if (訪問介護利用者負担額減額情報.get決定区分() != null) {
            builder.set決定区分(訪問介護利用者負担額減額情報.get決定区分());
        }
        if (訪問介護利用者負担額減額情報.get申請事由() != null) {
            builder.set申請事由(訪問介護利用者負担額減額情報.get申請事由());
        }
        builder.set給付率(訪問介護利用者負担額減額情報.get給付率());
        if (訪問介護利用者負担額減額情報.get非承認理由() != null) {
            builder.set非承認理由(訪問介護利用者負担額減額情報.get非承認理由());
        }
        if (訪問介護利用者負担額減額情報.get法別区分() != null) {
            builder.set法別区分(訪問介護利用者負担額減額情報.get法別区分());
        }
        if (訪問介護利用者負担額減額情報.get公費受給者番号() != null) {
            builder.set公費受給者番号(訪問介護利用者負担額減額情報.get公費受給者番号());
        }
        if (訪問介護利用者負担額減額情報.get公費負担者番号() != null) {
            builder.set公費負担者番号(訪問介護利用者負担額減額情報.get公費負担者番号());
        }
        builder.set障害者手帳有無(訪問介護利用者負担額減額情報.is障害者手帳有無());
        if (訪問介護利用者負担額減額情報.get障害者手帳交付年月日() != null) {
            builder.set障害者手帳交付年月日(訪問介護利用者負担額減額情報.get障害者手帳交付年月日());
        }
        if (訪問介護利用者負担額減額情報.get障害者手帳番号() != null) {
            builder.set障害者手帳番号(訪問介護利用者負担額減額情報.get障害者手帳番号());
        }
        if (訪問介護利用者負担額減額情報.get障害者手帳等級() != null) {
            builder.set障害者手帳等級(訪問介護利用者負担額減額情報.get障害者手帳等級());
        }
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
