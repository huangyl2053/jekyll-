/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban;

import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBA;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 被保険者番号付番の処理サービスクラスです。
 *
 * @reamsid_L DBU-0320-010 linghuhang
 */
public class HihokenshanotsukibanFinder {

    private static final int 付番方法_LENGTH = 10;
    private static final int 識別コード_LENGTH = 5;
    private static final RString 付番方法_住民コード付番 = new RString("1");
    private static final RString 付番方法_自動連番付番 = new RString("2");
    private static final RString 付番方法_任意手入力付番 = new RString("3");
    private static final RString 付番方法_カスタマイズ付番 = new RString("4");
    private static final RString 付番方法_自動連番_MCD10付番 = new RString("5");
    private static final RString 付番元情報_住民コード = new RString("1");
    private static final RString 付番元情報_自動連番 = new RString("2");
    private static final HihokenshaNo 被保険者番号_空白 = new HihokenshaNo("          ");
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final DbT7037ShoKofuKaishuDac dbT7037Dac;

    /**
     * コンストラクタです。
     */
    public HihokenshanotsukibanFinder() {
        dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        dbT7037Dac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dbT100Dac DbT1001HihokenshaDaichoDac
     * @param dbT7037Dac DbT7037ShoKofuKaishuDac
     */
    HihokenshanotsukibanFinder(
            DbT1001HihokenshaDaichoDac dbT100Dac,
            DbT7037ShoKofuKaishuDac dbT7037Dac) {
        this.dbT1001Dac = dbT100Dac;
        this.dbT7037Dac = dbT7037Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshanotsukibanFinder}のインスタンスを返します。
     *
     * @return HihokenshanotsukibanFinder
     */
    public static HihokenshanotsukibanFinder createInstance() {
        return InstanceProvider.create(HihokenshanotsukibanFinder.class);
    }

    /**
     * 識別コードによって被保険者番号を得ます。
     *
     * @param shikibetsuCode 識別コード
     * @return HihokenshaNo 被保険者番号
     */
    @Transaction
    public HihokenshaNo getHihokenshanotsukiban(ShikibetsuCode shikibetsuCode) {
        HihokenshaNo 被保険者番号;
        DbT1001HihokenshaDaichoEntity entityDbT1001 = dbT1001Dac.selectHihokenshaNo(shikibetsuCode);
        if (entityDbT1001 == null) {
            DbT7037ShoKofuKaishuEntity entityDbT7037 = dbT7037Dac.selectHihokenshaNo(shikibetsuCode);
            if (entityDbT7037 == null) {
                被保険者番号 = getHubanHouhou(shikibetsuCode);
            } else {
                被保険者番号 = entityDbT7037.getHihokenshaNo();
            }
        } else {
            被保険者番号 = entityDbT1001.getHihokenshaNo();
        }
        System.out.println("識別コード：" + shikibetsuCode.getColumnValue());
        System.out.println("被保険者番号：" + 被保険者番号.getColumnValue());

        if (被保険者番号.getColumnValue().length() != 付番方法_LENGTH) {
            throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage());
        } else {
            return 被保険者番号;
        }
    }

    private static HihokenshaNo getHubanHouhou(ShikibetsuCode 識別コード) {
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        RDate 適用基準日 = RDate.getNowDate();
        RString 付番方法 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_付番方法, 適用基準日, SubGyomuCode.DBA介護資格);
        if (付番方法_住民コード付番.equals(付番方法)) {
            被保険者番号 = new HihokenshaNo(new RString(識別コード.toString()).substring(識別コード_LENGTH).trim());
        }
        if (付番方法_自動連番付番.equals(付番方法)) {
            被保険者番号 = new HihokenshaNo(Saiban.get(SubGyomuCode.DBA介護資格, SaibanHanyokeyName.被保険者番号自動採番.getコード()).nextString().trim());
        }
        if (付番方法_任意手入力付番.equals(付番方法)) {
            return 被保険者番号_空白;
        }
        if (付番方法_カスタマイズ付番.equals(付番方法)) {
            被保険者番号 = getHubanHouhouHanteiYonn(識別コード);
        }
        if (付番方法_自動連番_MCD10付番.equals(付番方法)) {
            被保険者番号 = new HihokenshaNo(Saiban.get(SubGyomuCode.DBA介護資格, SaibanHanyokeyName.被保険者番号自動MCD.getコード()).nextString().trim());
        }
        return 被保険者番号桁数(被保険者番号);
    }

    private static HihokenshaNo 被保険者番号桁数(HihokenshaNo 被保険者番号) {

        if (被保険者番号.getColumnValue().length() < 付番方法_LENGTH) {
            被保険者番号 = new HihokenshaNo(被保険者番号.getColumnValue().padZeroToLeft(付番方法_LENGTH));
        }
        return 被保険者番号;
    }

    private static HihokenshaNo getHubanHouhouHanteiYonn(ShikibetsuCode 識別コード) {
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        RDate 適用基準日 = RDate.getNowDate();
        RString 付番元 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報, 適用基準日, SubGyomuCode.DBA介護資格);
        RString 開始位置 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_開始位置, 適用基準日, SubGyomuCode.DBA介護資格);
        RString 有効桁数 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_有効桁数, 適用基準日, SubGyomuCode.DBA介護資格);
        RString 前付与番号桁数 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号_桁数, 適用基準日, SubGyomuCode.DBA介護資格);
        RString 前付与番号 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号, 適用基準日, SubGyomuCode.DBA介護資格);
        RString 後付与番号桁数 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号_桁数, 適用基準日, SubGyomuCode.DBA介護資格);
        RString 後付与番号 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号, 適用基準日, SubGyomuCode.DBA介護資格);
        付番元 = check付番元(付番元, 識別コード);

        if (!開始位置.trim().isEmpty()
                && !有効桁数.trim().isEmpty()
                && !前付与番号桁数.trim().isEmpty()
                && !後付与番号桁数.trim().isEmpty()) {

            check前後番号与前後桁数(前付与番号, 前付与番号桁数, 後付与番号, 後付与番号桁数);
            StringBuilder hihokenshaNo = new StringBuilder(前付与番号);
            hihokenshaNo.append(付番元.substring(Integer.parseInt(開始位置.toString()),
                    Integer.parseInt(有効桁数.toString()) + Integer.parseInt(開始位置.toString())));
            hihokenshaNo.append(後付与番号);
            return new HihokenshaNo(hihokenshaNo.toString());
        }

        if ((!開始位置.trim().isEmpty())
                && (!有効桁数.trim().isEmpty())
                && (!前付与番号桁数.trim().isEmpty())) {
            check番号与桁数(前付与番号, 前付与番号桁数);
            StringBuilder hihokenshaNo = new StringBuilder(前付与番号);
            hihokenshaNo.append(付番元.substring(Integer.parseInt(開始位置.toString()),
                    Integer.parseInt(有効桁数.toString()) + Integer.parseInt(開始位置.toString())));

            return new HihokenshaNo(hihokenshaNo.toString());
        }

        if (!開始位置.trim().isEmpty()
                && !有効桁数.trim().isEmpty()
                && !後付与番号桁数.trim().isEmpty()) {
            check番号与桁数(後付与番号, 後付与番号桁数);
            StringBuilder hihokenshaNo = new StringBuilder();
            hihokenshaNo.append(付番元.substring(Integer.parseInt(開始位置.toString()),
                    Integer.parseInt(有効桁数.toString()) + Integer.parseInt(開始位置.toString())));
            hihokenshaNo.append(後付与番号);
            return new HihokenshaNo(hihokenshaNo.toString());
        }

        if (!開始位置.trim().isEmpty()
                && !有効桁数.trim().isEmpty()) {
            return new HihokenshaNo(付番元.substring(Integer.parseInt(開始位置.toString()),
                    Integer.parseInt(有効桁数.toString()) + Integer.parseInt(開始位置.toString())));
        }
        if ((開始位置.trim().isEmpty())
                && (有効桁数.trim().isEmpty())
                && (前付与番号桁数.trim().isEmpty())
                && (後付与番号桁数.trim().isEmpty())) {
            return new HihokenshaNo(付番元);
        }
        return 被保険者番号;
    }

    private static RString check付番元(RString 付番元, ShikibetsuCode 識別コード) {
        RString 付番 = RString.EMPTY;
        if (付番元情報_住民コード.equals(付番元)) {
            付番 = new RString(識別コード.toString()).substring(識別コード_LENGTH).trim();
        }
        if (付番元情報_自動連番.equals(付番元)) {
            付番 = Saiban.get(SubGyomuCode.DBA介護資格, SaibanHanyokeyName.被保険者番号自動採番.getコード()).nextString().trim();
        }
        return 付番;
    }

    private static void check前後番号与前後桁数(RString 前付与番号, RString 前付与番号桁数, RString 後付与番号, RString 後付与番号桁数) {
        if (前付与番号.length() != Integer.parseInt(前付与番号桁数.toString())
                || 後付与番号.length() != Integer.parseInt(後付与番号桁数.toString())) {
            throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage());
        }
    }

    private static void check番号与桁数(RString 番号, RString 桁数) {
        if (番号.length() != Integer.parseInt(桁数.toString())) {
            throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage());
        }
    }
}
