/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払い費支給申請のビジネスです。
 *
 * @reamsid_L DBC-1030-200 shaotw
 */
public class SyokanbaraihiShikyuShinseiManager {

    private static final RString 設定可_必須 = new RString("1");
    private static final RString 未入力 = new RString("0");
    private static final RString 必要な分申請書入力済 = new RString("1");
    private static final RString 申請書入力未済あり_エラー = new RString("2");
    private static final RString 決定情報入力未済あり_ワーニング = new RString("3");

    private final DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;

    /**
     * コンストラクタです。
     */
    SyokanbaraihiShikyuShinseiManager() {
        this.識別番号管理Dac = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SyokanbaraihiShikyuShinseiKetteManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SyokanbaraihiShikyuShinseiKetteManager}のインスタンス
     */
    public static SyokanbaraihiShikyuShinseiManager createInstance() {
        return InstanceProvider.create(SyokanbaraihiShikyuShinseiManager.class);
    }

    /**
     * 証明書入力済チェックを行います。
     *
     * @param 証明書入力済フラグ 証明書入力済フラグ
     * @param 識別番号 識別番号
     * @param サービス年月 サービス年月
     * @return 証明書入力完了フラグ（"1"：入力完了 "2"：入力未完了）
     */
    public ShomeishoNyuryokuKanryoKubunType 証明書InputCheck(ShomeishoNyuryokuFlag 証明書入力済フラグ, RString 識別番号, FlexibleYearMonth サービス年月) {
        ShikibetsuNoKanri shikibetsuNoKanri = getShikibetsuNoKanri(サービス年月, 識別番号);

        if (!基本証明書InputCheck(証明書入力済フラグ.get基本情報_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!明細証明書InputCheck(証明書入力済フラグ.get給付費明細_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!特定診療費証明書InputCheck(証明書入力済フラグ.get特定診療費_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!居宅計画費証明書InputCheck(証明書入力済フラグ.getサービス計画費_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!特定入所者証明書InputCheck(証明書入力済フラグ.get特定入所者費用_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!明細住所地特例証明書InputCheck(証明書入力済フラグ.get給付費明細住特_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!所定疾患施設療養証明書InputCheck(証明書入力済フラグ.get緊急時所定疾患_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!緊急時施設療養証明書InputCheck(証明書入力済フラグ.get緊急時施設療養費_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!食事費用証明書InputCheck(証明書入力済フラグ.get食事費用_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!集計証明書InputCheck(証明書入力済フラグ.get請求額集計_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }
        if (!社会福祉法人軽減証明書InputCheck(証明書入力済フラグ.get社福軽減額_証明書入力済フラグ(), shikibetsuNoKanri)) {
            return ShomeishoNyuryokuKanryoKubunType.入力未完了;
        }

        return ShomeishoNyuryokuKanryoKubunType.入力完了;
    }

    private boolean 基本証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get基本設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 明細証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get明細設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 特定診療費証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 居宅計画費証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 特定入所者証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 明細住所地特例証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 所定疾患施設療養証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 緊急時施設療養証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 食事費用証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 集計証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get集計設定区分())) {
                return false;
            }
        }
        return true;
    }

    private boolean 社会福祉法人軽減証明書InputCheck(ShomeishoNyuryokuKubunType 証明書入力済フラグ, ShikibetsuNoKanri shikibetsuNoKanri) {
        if (証明書入力済フラグ == null) {
            return true;
        }
        if (shikibetsuNoKanri != null) {
            if (未入力.equals(証明書入力済フラグ.getCode()) && 設定可_必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 識別番号管理情報取得する。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号 識別番号
     * @return ShikibetsuNoKanri
     */
    private ShikibetsuNoKanri getShikibetsuNoKanri(FlexibleYearMonth サービス提供年月,
            RString 識別番号) {
        DbT3118ShikibetsuNoKanriEntity entity = 識別番号管理Dac.select識別番号管理(識別番号, サービス提供年月);
        if (entity == null) {
            return null;
        }
        return new ShikibetsuNoKanri(entity);
    }

    /**
     * 非償還決定情報の申請書入力済チェック
     *
     * @param 申請書入力済フラグ RString
     * @return 申請書入力済区分
     */
    public RString shinseishoInputCheck(RString 申請書入力済フラグ) {
        RString 出力_申請書入力済区分 = 必要な分申請書入力済;
        if (未入力.equals(申請書入力済フラグ)) {
            出力_申請書入力済区分 = 申請書入力未済あり_エラー;
        }
        return 出力_申請書入力済区分;
    }

    /**
     * 償還決定情報の申請書入力済チェック
     *
     * @param 申請書入力済フラグ RString
     * @return 申請書入力済区分
     */
    public RString 償還決定情報InputCheck(RString 申請書入力済フラグ) {
        RString 出力_申請書入力済区分 = 必要な分申請書入力済;
        if (未入力.equals(申請書入力済フラグ)) {
            出力_申請書入力済区分 = 決定情報入力未済あり_ワーニング;
        }
        return 出力_申請書入力済区分;
    }

    /**
     * データ登録更新
     */
    public void データ登録更新() {
        //TODO QA697
    }
}
