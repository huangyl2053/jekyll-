/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.hihokenshanotsukiban;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 被保険者番号付番の処理サービスクラスです。
 */
public class HihokenshanotsukibanFinder {

    private static final int HANTEIYOU_10 = 10;
    private static final RString HANTEIYOU_ICHI = new RString("1");
    private static final RString HANTEIYOU_NI = new RString("2");
    private static final RString HANTEIYOU_SAN = new RString("3");
    private static final RString HANTEIYOU_YONN = new RString("4");
    private static final RString HANTEIYOU_GO = new RString("5");
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
     * @param 識別コード 識別コード
     * @return HihokenshaNo HihokenshaNo
     */
    @Transaction
    public HihokenshaNo getHihokenshanotsukiban(ShikibetsuCode 識別コード) {
        HihokenshaNo 被保険者番号;
        DbT1001HihokenshaDaichoEntity entityDbT1001 = dbT1001Dac.selectHihokenshaNo(識別コード);
        if (entityDbT1001 == null) {
            DbT7037ShoKofuKaishuEntity entityDbT7037 = dbT7037Dac.selectHihokenshaNo(識別コード);
            if (entityDbT7037 == null) {
                被保険者番号 = HihokenshanotsukibanFinder.getHubanHouhou(識別コード);
            } else {
                被保険者番号 = entityDbT7037.getHihokenshaNo();
            }
        } else {
            被保険者番号 = entityDbT1001.getHihokenshaNo();
        }
        if (被保険者番号.getColumnValue().length() != HANTEIYOU_10) {
            throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage());
        }
        return 被保険者番号;
    }

    private static HihokenshaNo getHubanHouhou(ShikibetsuCode 識別コード) {
        HihokenshaNo 被保険者番号 = null;
        // TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「付番方法」がない 2015/12/15。
        RString 付番方法 = new RString("");
        // RString 付番方法 = BusinessConfig.get(HihokenshaNoFubanHoho.付番方法, SubGyomuCode.DBA介護資格);
        if (HANTEIYOU_ICHI.equals(付番方法)) {
            被保険者番号 = new HihokenshaNo(識別コード.getColumnValue().substring(
                    識別コード.getColumnValue().length() - HANTEIYOU_10, 識別コード.getColumnValue().length()).trim());
        }
        if (HANTEIYOU_NI.equals(付番方法)) {
            //TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「被保険者番号自動採番」がない 2015/12/15。
//            RString hubanNo = Saiban.get(SubGyomuCode.DBA介護資格,HihokenshaNoFubanHoho.被保険者番号自動採番).nextString();
//            被保険者番号 = SaibanHanyokeyName.被保険者番号自動採番;
        }
        if (HANTEIYOU_SAN.equals(付番方法)) {
            被保険者番号 = new HihokenshaNo("");
        }
        if (HANTEIYOU_YONN.equals(付番方法)) {
            // TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_付番元情報」がない 2015/12/15。
            RString 付番元 = new RString("");
            // RString 付番元 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_付番元情報,SubGyomuCode.DBA介護資格);
            // TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_付番元情報_開始位置」がない 2015/12/15。
            RString 開始位置 = new RString("");
            // RString 開始位置 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_付番元情報_開始位置,SubGyomuCode.DBA介護資格);
            // TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_付番元情報_有効桁数」がない 2015/12/15。
            RString 有効桁数 = new RString("");
            // RString 有効桁数 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_付番元情報_有効桁数,SubGyomuCode.DBA介護資格);
            // TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_前付与番号_桁数」がない 2015/12/15。
            RString 前付与番号桁数 = new RString("");
            // RString 前付与番号桁数 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_前付与番号_桁数,SubGyomuCode.DBA介護資格);
            // TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_前付与番号」がない 2015/12/15。
            RString 前付与番号 = new RString("");
            // RString 前付与番号 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_前付与番号,SubGyomuCode.DBA介護資格);
            // TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_後付与番号_桁数」がない 2015/12/15。
            RString 後付与番号桁数 = new RString("");
            // RString 後付与番号桁数 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_後付与番号_桁数,SubGyomuCode.DBA介護資格);
            // TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_後付与番号」がない 2015/12/15。
            RString 後付与番号 = new RString("");
            // RString 後付与番号 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_後付与番号,SubGyomuCode.DBA介護資格);

            int 付番元情報開始位置 = Integer.parseInt(開始位置.toString());
            int 付番元情報有効桁数 = Integer.parseInt(有効桁数.toString());

            if (HANTEIYOU_ICHI.equals(付番元)) {
                付番元 = 付番元.substring(付番元.length() - HANTEIYOU_10, 付番元.length()).trim();
            }
            if (HANTEIYOU_NI.equals(付番元)) {
                // TODO 袁献輝 EnumクラスSaibanHanyokeyNameがない、 2015/12/15。
                // 被保険者番号 = Saiban.get(SubGyomuCode.DBA介護資格,SaibanHanyokeyName.被保険者番号自動採番).nextString();
            }
            if (開始位置.isEmpty() && 有効桁数.isEmpty() && 前付与番号桁数.isEmpty() && 後付与番号桁数.isEmpty()) {
                if ((前付与番号.length() != 前付与番号桁数.length()) || (後付与番号.length() != 後付与番号桁数.length())) {
                    throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage());
                } else {
                    StringBuilder hihokenshaNo = new StringBuilder();
                    hihokenshaNo.append(前付与番号);
                    hihokenshaNo.append(付番元.substring(付番元情報開始位置, 付番元情報有効桁数));
                    hihokenshaNo.append(後付与番号);
                    被保険者番号 = new HihokenshaNo(hihokenshaNo.toString());
                }
            } else if (開始位置.isEmpty() && 有効桁数.isEmpty() && 前付与番号桁数.isEmpty()) {
                if (前付与番号.length() != 前付与番号桁数.length()) {
                    throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage());
                } else {
                    StringBuilder hihokenshaNo = new StringBuilder();
                    hihokenshaNo.append(前付与番号);
                    hihokenshaNo.append(付番元.substring(付番元情報開始位置, 付番元情報有効桁数));
                    被保険者番号 = new HihokenshaNo(hihokenshaNo.toString());
                }
            } else if (開始位置.isEmpty() && 有効桁数.isEmpty() && 後付与番号.isEmpty()) {
                if (後付与番号.length() != 後付与番号桁数.length()) {
                    throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage());
                } else {
                    StringBuilder hihokenshaNo = new StringBuilder();
                    hihokenshaNo.append(付番元.substring(付番元情報開始位置, 付番元情報有効桁数));
                    hihokenshaNo.append(後付与番号);
                    被保険者番号 = new HihokenshaNo(hihokenshaNo.toString());
                }
            } else if (開始位置.isEmpty() && 有効桁数.isEmpty()) {

                被保険者番号 = new HihokenshaNo(付番元.substring(付番元情報開始位置, 付番元情報有効桁数));
            }

            if (!開始位置.isEmpty() && !有効桁数.isEmpty() && !前付与番号桁数.isEmpty() && !後付与番号桁数.isEmpty()) {
                被保険者番号 = new HihokenshaNo(付番元);
            }
        }
        if (HANTEIYOU_GO.equals(付番方法)) {
            // TODO 袁献輝 EnumクラスSaibanHanyokeyNameがない 2015/12/15。
            // 被保険者番号 = Saiban.get(SubGyomuCode.DBA介護資格,SaibanHanyokeyName.被保険者番号自動MCD).nextString();
        }
        return 被保険者番号;
    }
}
