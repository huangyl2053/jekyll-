/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshanotsukiban;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 被保険者番号付番の処理サービスクラスです。
 */
public class HihokenshanotsukibanFinder {

    private static RString ICHI = new RString("1");
    private static RString NI = new RString("2");
    private static RString MI = new RString("3");
    private static RString SHI = new RString("4");
    private static RString GO = new RString("5");
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
            DbT7037ShoKofuKaishuDac dbT7037Dac
    ) {
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
     * @param 識別コード ShikibetsuCode
     * @return HihokenshaNo HihokenshaNo
     */
    @Transaction
    public HihokenshaNo getHihokenshanotsukiban(
            ShikibetsuCode 識別コード
    ) {
        HihokenshaNo 被保険者番号;

        DbT1001HihokenshaDaichoEntity entityDbT1001 = dbT1001Dac.selectHihokenshaNo(識別コード);
        if (entityDbT1001 == null) {
            DbT7037ShoKofuKaishuEntity entityDbT7037 = dbT7037Dac.selectHihokenshaNo(識別コード);
            if (entityDbT7037 == null) {
                被保険者番号 = HihokenshanotsukibanFinder.getHubanHouhou(識別コード);
            }
            被保険者番号 = entityDbT7037.getHihokenshaNo();
        }
        被保険者番号 = entityDbT1001.getHihokenshaNo();
        if (被保険者番号.getColumnValue().length() != 10) {

//            throw new ApplicationException(
//                    UrzErrorMessage.桁数が不正.getMessage());
        }
        return 被保険者番号;
    }

    private static HihokenshaNo getHubanHouhou(ShikibetsuCode 識別コード) {

        HihokenshaNo 被保険者番号 = null;
        // TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「付番方法」がない、 QA回答まち。
        RString hubanhouhou = new RString("");
//                BusinessConfig.get(HihokenshaNoFubanHoho.付番方法, SubGyomuCode.DBA介護資格);

        if (ICHI.equals(hubanhouhou)) {
            被保険者番号 = new HihokenshaNo(識別コード.toString().substring(
                    識別コード.toString().length() - 10,
                    識別コード.toString().length()).trim());
        }

        if (NI.equals(hubanhouhou)) {

            //TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「被保険者番号自動採番」がない、 QA回答まち。
//            RString hubanNo = Saiban.get(SubGyomuCode.DBA介護資格, HihokenshaNoFubanHoho.被保険者番号自動採番).nextString();
//            被保険者番号 = SaibanHanyokeyName.被保険者番号自動採番;
        }
        if (MI.equals(hubanhouhou)) {
            被保険者番号 = new HihokenshaNo("");
        }

        if (SHI.equals(hubanhouhou)) {
            //TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_付番元情報」がない、 QA回答まち。
            RString 付番元 = new RString("");
//            RString 付番元 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_付番元情報, SubGyomuCode.DBA介護資格);
            //TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_付番元情報_開始位置」がない、 QA回答まち。
            RString 開始位置 = new RString("");
//            RString 開始位置 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_付番元情報_開始位置, SubGyomuCode.DBA介護資格);
            //TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_付番元情報_有効桁数」がない、 QA回答まち。
            RString 有効桁数 = new RString("");
//            RString 有効桁数 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_付番元情報_有効桁数, SubGyomuCode.DBA介護資格);
            //TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_前付与番号_桁数」がない、 QA回答まち。
            RString 前付与番号桁数 = new RString("");
//            RString 前付与番号桁数 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_前付与番号_桁数, SubGyomuCode.DBA介護資格);
            //TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_前付与番号」がない、 QA回答まち。
            RString 前付与番号 = new RString("");
//            RString 前付与番号 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_前付与番号, SubGyomuCode.DBA介護資格);
            //TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_後付与番号_桁数」がない、 QA回答まち。
            RString 後付与番号桁数 = new RString("");
//            RString 後付与番号桁数 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_後付与番号_桁数, SubGyomuCode.DBA介護資格);
            //TODO 袁献輝 EnumクラスHihokenshaNoFubanHohoに「カスタマイズ付番_後付与番号」がない、 QA回答まち。
            RString 後付与番号 = new RString("");
            //            RString 後付与番号 = BusinessConfig.get(HihokenshaNoFubanHoho.カスタマイズ付番_後付与番号, SubGyomuCode.DBA介護資格);

            int 付番元情報開始位置 = Integer.parseInt(開始位置.toString());
            int 付番元情報有効桁数 = Integer.parseInt(有効桁数.toString());

            RString KUUHAKU = new RString("");

            if (ICHI.equals(付番元)) {
                付番元 = 付番元.substring(付番元.length() - 10, 付番元.length()).trim();
            }
            if (NI.equals(付番元)) {
                //TODO 袁献輝 EnumクラスSaibanHanyokeyNameがない、 QA回答まち。
//                被保険者番号 = Saiban.get(SubGyomuCode.DBA介護資格, SaibanHanyokeyName.被保険者番号自動採番).nextString(); //
            }
            if ((!KUUHAKU.equals(開始位置) || 開始位置.isEmpty())
                    && (!KUUHAKU.equals(有効桁数) || 有効桁数.isEmpty())
                    && (!KUUHAKU.equals(前付与番号桁数) || 前付与番号桁数.isEmpty())
                    && (!KUUHAKU.equals(後付与番号桁数) || 後付与番号桁数.isEmpty())) {

                if ((前付与番号.length() != 前付与番号桁数.length())
                        || (後付与番号.length() != 後付与番号桁数.length())) {
                    //TODO
//                    throw new ApplicationException(
//                            UrzErrorMessage.桁数が不正.getMessage());
                } else {
                    StringBuilder hihokenshaNo = new StringBuilder();
                    hihokenshaNo.append(前付与番号);
                    hihokenshaNo.append(付番元.substring(付番元情報開始位置, 付番元情報有効桁数));
                    hihokenshaNo.append(後付与番号);
                    被保険者番号 = new HihokenshaNo(hihokenshaNo.toString());
                }
            }
            if ((!KUUHAKU.equals(開始位置) | 開始位置.isEmpty())
                    && (!KUUHAKU.equals(有効桁数) || 有効桁数.isEmpty())
                    && (!KUUHAKU.equals(前付与番号桁数) || 前付与番号桁数.isEmpty())) {

                if (前付与番号.length() != 前付与番号桁数.length()) {
                    //TODO
//                    throw new ApplicationException(
//                            UrzErrorMessage.桁数が不正.getMessage());
                } else {
                    StringBuilder hihokenshaNo = new StringBuilder();
                    hihokenshaNo.append(前付与番号);
                    hihokenshaNo.append(付番元.substring(付番元情報開始位置, 付番元情報有効桁数));
                    被保険者番号 = new HihokenshaNo(hihokenshaNo.toString());
                }
            }
            if ((!KUUHAKU.equals(開始位置) || 開始位置.isEmpty())
                    && (!KUUHAKU.equals(有効桁数) || 有効桁数.isEmpty())
                    && (!KUUHAKU.equals(後付与番号) || 後付与番号.isEmpty())) {

                if (後付与番号.length() != 後付与番号桁数.length()) {
                    //TODO
//                    throw new ApplicationException(
//                            UrzErrorMessage.桁数が不正.getMessage());
                } else {
                    StringBuilder hihokenshaNo = new StringBuilder();
                    hihokenshaNo.append(付番元.substring(付番元情報開始位置, 付番元情報有効桁数));
                    hihokenshaNo.append(後付与番号);
                    被保険者番号 = new HihokenshaNo(hihokenshaNo.toString());
                }
            }
            if ((!KUUHAKU.equals(開始位置) || 開始位置.isEmpty())
                    && (!KUUHAKU.equals(有効桁数) || 有効桁数.isEmpty())) {

                被保険者番号 = new HihokenshaNo(付番元.substring(付番元情報開始位置, 付番元情報有効桁数));
            }

            if ((!KUUHAKU.equals(開始位置) || 開始位置.isEmpty())
                    && (!KUUHAKU.equals(有効桁数) || 有効桁数.isEmpty())
                    && (!KUUHAKU.equals(前付与番号桁数) || 前付与番号桁数.isEmpty())
                    && (!KUUHAKU.equals(後付与番号桁数) || 後付与番号桁数.isEmpty())) {
                被保険者番号 = new HihokenshaNo(付番元);
            }
        }

        if (GO.equals(hubanhouhou)) {
            //TODO 袁献輝 EnumクラスSaibanHanyokeyNameがない、 QA回答まち。
//            被保険者番号 = Saiban.get(SubGyomuCode.DBA介護資格, SaibanHanyokeyName.被保険者番号自動MCD).nextString();
        }
        return 被保険者番号;
    }
}
