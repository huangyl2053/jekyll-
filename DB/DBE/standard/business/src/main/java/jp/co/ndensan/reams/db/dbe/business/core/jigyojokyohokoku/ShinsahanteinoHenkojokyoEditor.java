/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyo;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsahanteinoHenkojokyoEditor {

    private static final RString 非該当 = new RString("01");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private static final RString なし = new RString(0);
    private final ShinsahanteinoHenkojokyo henkojokyo;

    /**
     * コンストラクタです。
     *
     * @param henkojokyo ShinsahanteinoHenkojokyo
     */
    public ShinsahanteinoHenkojokyoEditor(ShinsahanteinoHenkojokyo henkojokyo) {
        this.henkojokyo = henkojokyo;
    }

    /**
     * 審査判定の変更状況を設定します。
     *
     * @param 変更状況情報 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set更新申請３ヶ月(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_３ヶ月_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_３ヶ月_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_３ヶ月_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_３ヶ月_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_３ヶ月_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_３ヶ月_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_３ヶ月_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_３ヶ月_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_３ヶ月_計(new RString(getIntValue(henkojokyo.get更新_３ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get更新_３ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_３ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護5())));
    }

    /**
     * 審査判定の変更状況を設定します。
     *
     * @param 変更状況情報 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set更新申請６ヶ月(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_６ヶ月_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_６ヶ月_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_６ヶ月_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_６ヶ月_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_６ヶ月_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_６ヶ月_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_６ヶ月_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_６ヶ月_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_６ヶ月_計(new RString(getIntValue(henkojokyo.get更新_６ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護5())));
    }

    /**
     * 審査判定の変更状況を設定します。
     *
     * @param 変更状況情報 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set更新申請１２ヶ月(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_１２ヶ月_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_１２ヶ月_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_１２ヶ月_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_１２ヶ月_計(new RString(getIntValue(henkojokyo.get更新_１２ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護5())));
    }

    /**
     * 審査判定の変更状況を設定します。
     *
     * @param 変更状況情報 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set更新申請２４ヶ月(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_２４ヶ月_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_２４ヶ月_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_２４ヶ月_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_２４ヶ月_計(new RString(getIntValue(henkojokyo.get更新_２４ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護5())));
    }

    /**
     * 審査判定の変更状況を設定します。
     *
     * @param 変更状況情報 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set更新申請その他(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_その他_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_その他_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_その他_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_その他_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_その他_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_その他_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_その他_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_その他_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_その他_計(new RString(getIntValue(henkojokyo.get更新_その他_二次判定非該当())
                + getIntValue(henkojokyo.get更新_その他_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_その他_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護5())));
    }

    /**
     * 審査判定の変更状況を設定します。
     *
     */
    public void set更新申請() {
        henkojokyo.set更新申請_二次判定非該当(new RString(getIntValue(henkojokyo.get更新_３ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get更新_その他_二次判定非該当())));
        henkojokyo.set更新申請_二次判定要支援1(new RString(getIntValue(henkojokyo.get更新_３ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_その他_二次判定要支援1())));
        henkojokyo.set更新申請_二次判定要支援2(new RString(getIntValue(henkojokyo.get更新_３ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_その他_二次判定要支援2())));
        henkojokyo.set更新申請_二次判定要介護1(new RString(getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護1())));
        henkojokyo.set更新申請_二次判定要介護2(new RString(getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護2())));
        henkojokyo.set更新申請_二次判定要介護3(new RString(getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護3())));
        henkojokyo.set更新申請_二次判定要介護4(new RString(getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護4())));
        henkojokyo.set更新申請_二次判定要介護5(new RString(getIntValue(henkojokyo.get更新_３ヶ月_二次判定要介護5())
                + getIntValue(henkojokyo.get更新_６ヶ月_二次判定要介護5())
                + getIntValue(henkojokyo.get更新_１２ヶ月_二次判定要介護5())
                + getIntValue(henkojokyo.get更新_２４ヶ月_二次判定要介護5())
                + getIntValue(henkojokyo.get更新_その他_二次判定要介護5())));
        henkojokyo.set更新申請_計(new RString(getIntValue(henkojokyo.get更新_３ヶ月_計())
                + getIntValue(henkojokyo.get更新_６ヶ月_計())
                + getIntValue(henkojokyo.get更新_１２ヶ月_計())
                + getIntValue(henkojokyo.get更新_２４ヶ月_計())
                + getIntValue(henkojokyo.get更新_その他_計())));
    }

    /**
     * 審査判定の変更状況を設定します。
     *
     * @param 新規３ヶ月結果情報 List<SinsakaiHanteiJyokyoEntity>
     * @param 新規６ヶ月結果情報 List<SinsakaiHanteiJyokyoEntity>
     * @param 新規１２ヶ月結果情報 List<SinsakaiHanteiJyokyoEntity>
     * @param 新規２４ヶ月結果情報 List<SinsakaiHanteiJyokyoEntity>
     * @param 新規その他結果情報 List<SinsakaiHanteiJyokyoEntity>
     * @param 区分変更３ヶ月結果情報 List<SinsakaiHanteiJyokyoEntity>
     * @param 区分変更６ヶ月結果情報 List<SinsakaiHanteiJyokyoEntity>
     * @param 区分変更１２ヶ月結果情報 List<SinsakaiHanteiJyokyoEntity>
     * @param 区分変更２４ヶ月結果情報 List<SinsakaiHanteiJyokyoEntity>
     * @param 区分変更その他結果情報 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set新規区分変更エリア(List<SinsakaiHanteiJyokyoEntity> 新規３ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 新規６ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 新規１２ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 新規２４ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 新規その他結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更３ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更６ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更１２ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更２４ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更その他結果情報) {
        int 新規３ヶ月非該当 = get被保険者数(新規３ヶ月結果情報, 非該当);
        int 新規３ヶ月要支援1 = get被保険者数(新規３ヶ月結果情報, 要支援1);
        int 新規３ヶ月要支援2 = get被保険者数(新規３ヶ月結果情報, 要支援2);
        int 新規３ヶ月要介護1 = get被保険者数(新規３ヶ月結果情報, 要介護1);
        int 新規３ヶ月要介護2 = get被保険者数(新規３ヶ月結果情報, 要介護2);
        int 新規３ヶ月要介護3 = get被保険者数(新規３ヶ月結果情報, 要介護3);
        int 新規３ヶ月要介護4 = get被保険者数(新規３ヶ月結果情報, 要介護4);
        int 新規３ヶ月要介護5 = get被保険者数(新規３ヶ月結果情報, 要介護5);
        int 新規６ヶ月非該当 = get被保険者数(新規６ヶ月結果情報, 非該当);
        int 新規６ヶ月要支援1 = get被保険者数(新規６ヶ月結果情報, 要支援1);
        int 新規６ヶ月要支援2 = get被保険者数(新規６ヶ月結果情報, 要支援2);
        int 新規６ヶ月要介護1 = get被保険者数(新規６ヶ月結果情報, 要介護1);
        int 新規６ヶ月要介護2 = get被保険者数(新規６ヶ月結果情報, 要介護2);
        int 新規６ヶ月要介護3 = get被保険者数(新規６ヶ月結果情報, 要介護3);
        int 新規６ヶ月要介護4 = get被保険者数(新規６ヶ月結果情報, 要介護4);
        int 新規６ヶ月要介護5 = get被保険者数(新規６ヶ月結果情報, 要介護5);
        int 新規１２ヶ月非該当 = get被保険者数(新規１２ヶ月結果情報, 非該当);
        int 新規１２ヶ月要支援1 = get被保険者数(新規１２ヶ月結果情報, 要支援1);
        int 新規１２ヶ月要支援2 = get被保険者数(新規１２ヶ月結果情報, 要支援2);
        int 新規１２ヶ月要介護1 = get被保険者数(新規１２ヶ月結果情報, 要介護1);
        int 新規１２ヶ月要介護2 = get被保険者数(新規１２ヶ月結果情報, 要介護2);
        int 新規１２ヶ月要介護3 = get被保険者数(新規１２ヶ月結果情報, 要介護3);
        int 新規１２ヶ月要介護4 = get被保険者数(新規１２ヶ月結果情報, 要介護4);
        int 新規１２ヶ月要介護5 = get被保険者数(新規１２ヶ月結果情報, 要介護5);
        int 新規２４ヶ月非該当 = get被保険者数(新規２４ヶ月結果情報, 非該当);
        int 新規２４ヶ月要支援1 = get被保険者数(新規２４ヶ月結果情報, 要支援1);
        int 新規２４ヶ月要支援2 = get被保険者数(新規２４ヶ月結果情報, 要支援2);
        int 新規２４ヶ月要介護1 = get被保険者数(新規２４ヶ月結果情報, 要介護1);
        int 新規２４ヶ月要介護2 = get被保険者数(新規２４ヶ月結果情報, 要介護2);
        int 新規２４ヶ月要介護3 = get被保険者数(新規２４ヶ月結果情報, 要介護3);
        int 新規２４ヶ月要介護4 = get被保険者数(新規２４ヶ月結果情報, 要介護4);
        int 新規２４ヶ月要介護5 = get被保険者数(新規２４ヶ月結果情報, 要介護5);
        int 新規その他非該当 = get被保険者数(新規その他結果情報, 非該当);
        int 新規その他要支援1 = get被保険者数(新規その他結果情報, 要支援1);
        int 新規その他要支援2 = get被保険者数(新規その他結果情報, 要支援2);
        int 新規その他要介護1 = get被保険者数(新規その他結果情報, 要介護1);
        int 新規その他要介護2 = get被保険者数(新規その他結果情報, 要介護2);
        int 新規その他要介護3 = get被保険者数(新規その他結果情報, 要介護3);
        int 新規その他要介護4 = get被保険者数(新規その他結果情報, 要介護4);
        int 新規その他要介護5 = get被保険者数(新規その他結果情報, 要介護5);
        int 区分３ヶ月非該当 = get被保険者数(区分変更３ヶ月結果情報, 非該当);
        int 区分３ヶ月要支援1 = get被保険者数(区分変更３ヶ月結果情報, 要支援1);
        int 区分３ヶ月要支援2 = get被保険者数(区分変更３ヶ月結果情報, 要支援2);
        int 区分３ヶ月要介護1 = get被保険者数(区分変更３ヶ月結果情報, 要介護1);
        int 区分３ヶ月要介護2 = get被保険者数(区分変更３ヶ月結果情報, 要介護2);
        int 区分３ヶ月要介護3 = get被保険者数(区分変更３ヶ月結果情報, 要介護3);
        int 区分３ヶ月要介護4 = get被保険者数(区分変更３ヶ月結果情報, 要介護4);
        int 区分３ヶ月要介護5 = get被保険者数(区分変更３ヶ月結果情報, 要介護5);
        int 区分６ヶ月非該当 = get被保険者数(区分変更６ヶ月結果情報, 非該当);
        int 区分６ヶ月要支援1 = get被保険者数(区分変更６ヶ月結果情報, 要支援1);
        int 区分６ヶ月要支援2 = get被保険者数(区分変更６ヶ月結果情報, 要支援2);
        int 区分６ヶ月要介護1 = get被保険者数(区分変更６ヶ月結果情報, 要介護1);
        int 区分６ヶ月要介護2 = get被保険者数(区分変更６ヶ月結果情報, 要介護2);
        int 区分６ヶ月要介護3 = get被保険者数(区分変更６ヶ月結果情報, 要介護3);
        int 区分６ヶ月要介護4 = get被保険者数(区分変更６ヶ月結果情報, 要介護4);
        int 区分６ヶ月要介護5 = get被保険者数(区分変更６ヶ月結果情報, 要介護5);
        int 区分１２ヶ月非該当 = get被保険者数(区分変更１２ヶ月結果情報, 非該当);
        int 区分１２ヶ月要支援1 = get被保険者数(区分変更１２ヶ月結果情報, 要支援1);
        int 区分１２ヶ月要支援2 = get被保険者数(区分変更１２ヶ月結果情報, 要支援2);
        int 区分１２ヶ月要介護1 = get被保険者数(区分変更１２ヶ月結果情報, 要介護1);
        int 区分１２ヶ月要介護2 = get被保険者数(区分変更１２ヶ月結果情報, 要介護2);
        int 区分１２ヶ月要介護3 = get被保険者数(区分変更１２ヶ月結果情報, 要介護3);
        int 区分１２ヶ月要介護4 = get被保険者数(区分変更１２ヶ月結果情報, 要介護4);
        int 区分１２ヶ月要介護5 = get被保険者数(区分変更１２ヶ月結果情報, 要介護5);
        int 区分２４ヶ月非該当 = get被保険者数(区分変更２４ヶ月結果情報, 非該当);
        int 区分２４ヶ月要支援1 = get被保険者数(区分変更２４ヶ月結果情報, 要支援1);
        int 区分２４ヶ月要支援2 = get被保険者数(区分変更２４ヶ月結果情報, 要支援2);
        int 区分２４ヶ月要介護1 = get被保険者数(区分変更２４ヶ月結果情報, 要介護1);
        int 区分２４ヶ月要介護2 = get被保険者数(区分変更２４ヶ月結果情報, 要介護2);
        int 区分２４ヶ月要介護3 = get被保険者数(区分変更２４ヶ月結果情報, 要介護3);
        int 区分２４ヶ月要介護4 = get被保険者数(区分変更２４ヶ月結果情報, 要介護4);
        int 区分２４ヶ月要介護5 = get被保険者数(区分変更２４ヶ月結果情報, 要介護5);
        int 区分その他非該当 = get被保険者数(区分変更その他結果情報, 非該当);
        int 区分その他要支援1 = get被保険者数(区分変更その他結果情報, 要支援1);
        int 区分その他要支援2 = get被保険者数(区分変更その他結果情報, 要支援2);
        int 区分その他要介護1 = get被保険者数(区分変更その他結果情報, 要介護1);
        int 区分その他要介護2 = get被保険者数(区分変更その他結果情報, 要介護2);
        int 区分その他要介護3 = get被保険者数(区分変更その他結果情報, 要介護3);
        int 区分その他要介護4 = get被保険者数(区分変更その他結果情報, 要介護4);
        int 区分その他要介護5 = get被保険者数(区分変更その他結果情報, 要介護5);
        henkojokyo.set新規申請_二次判定非該当(new RString(新規３ヶ月非該当 + 新規６ヶ月非該当 + 新規１２ヶ月非該当 + 新規２４ヶ月非該当 + 新規その他非該当));
        henkojokyo.set新規申請_二次判定要支援1(new RString(新規３ヶ月要支援1 + 新規６ヶ月要支援1 + 新規１２ヶ月要支援1 + 新規２４ヶ月要支援1 + 新規その他要支援1));
        henkojokyo.set新規申請_二次判定要支援2(new RString(新規３ヶ月要支援2 + 新規６ヶ月要支援2 + 新規１２ヶ月要支援2 + 新規２４ヶ月要支援2 + 新規その他要支援2));
        henkojokyo.set新規申請_二次判定要介護1(new RString(新規３ヶ月要介護1 + 新規６ヶ月要介護1 + 新規１２ヶ月要介護1 + 新規２４ヶ月要介護1 + 新規その他要介護1));
        henkojokyo.set新規申請_二次判定要介護2(new RString(新規３ヶ月要介護2 + 新規６ヶ月要介護2 + 新規１２ヶ月要介護2 + 新規２４ヶ月要介護2 + 新規その他要介護2));
        henkojokyo.set新規申請_二次判定要介護3(new RString(新規３ヶ月要介護3 + 新規６ヶ月要介護3 + 新規１２ヶ月要介護3 + 新規２４ヶ月要介護3 + 新規その他要介護3));
        henkojokyo.set新規申請_二次判定要介護4(new RString(新規３ヶ月要介護4 + 新規６ヶ月要介護4 + 新規１２ヶ月要介護4 + 新規２４ヶ月要介護4 + 新規その他要介護4));
        henkojokyo.set新規申請_二次判定要介護5(new RString(新規３ヶ月要介護5 + 新規６ヶ月要介護5 + 新規１２ヶ月要介護5 + 新規２４ヶ月要介護5 + 新規その他要介護5));
        set新規申請_計();
        henkojokyo.set新規_区分変更申請_二次判定非該当(new RString(区分３ヶ月非該当 + 区分６ヶ月非該当 + 区分１２ヶ月非該当 + 区分２４ヶ月非該当 + 区分その他非該当));
        henkojokyo.set新規_区分変更申請_二次判定要支援1(new RString(区分３ヶ月要支援1 + 区分６ヶ月要支援1 + 区分１２ヶ月要支援1 + 区分２４ヶ月要支援1 + 区分その他要支援1));
        henkojokyo.set新規_区分変更申請_二次判定要支援2(new RString(区分３ヶ月要支援2 + 区分６ヶ月要支援2 + 区分１２ヶ月要支援2 + 区分２４ヶ月要支援2 + 区分その他要支援2));
        henkojokyo.set新規_区分変更申請_二次判定要介護1(new RString(区分３ヶ月要介護1 + 区分６ヶ月要介護1 + 区分１２ヶ月要介護1 + 区分２４ヶ月要介護1 + 区分その他要介護1));
        henkojokyo.set新規_区分変更申請_二次判定要介護2(new RString(区分３ヶ月要介護2 + 区分６ヶ月要介護2 + 区分１２ヶ月要介護2 + 区分２４ヶ月要介護2 + 区分その他要介護2));
        henkojokyo.set新規_区分変更申請_二次判定要介護3(new RString(区分３ヶ月要介護3 + 区分６ヶ月要介護3 + 区分１２ヶ月要介護3 + 区分２４ヶ月要介護3 + 区分その他要介護3));
        henkojokyo.set新規_区分変更申請_二次判定要介護4(new RString(区分３ヶ月要介護4 + 区分６ヶ月要介護4 + 区分１２ヶ月要介護4 + 区分２４ヶ月要介護4 + 区分その他要介護4));
        henkojokyo.set新規_区分変更申請_二次判定要介護5(new RString(区分３ヶ月要介護5 + 区分６ヶ月要介護5 + 区分１２ヶ月要介護5 + 区分２４ヶ月要介護5 + 区分その他要介護5));
        set新規_区分変更申請_計();
        henkojokyo.set新規_３ヶ月_二次判定非該当(new RString(新規３ヶ月非該当 + 区分３ヶ月非該当));
        henkojokyo.set新規_３ヶ月_二次判定要支援1(new RString(新規３ヶ月要支援1 + 区分３ヶ月要支援1));
        henkojokyo.set新規_３ヶ月_二次判定要支援2(new RString(新規３ヶ月要支援2 + 区分３ヶ月要支援2));
        henkojokyo.set新規_３ヶ月_二次判定要介護1(new RString(新規３ヶ月要介護1 + 区分３ヶ月要介護1));
        henkojokyo.set新規_３ヶ月_二次判定要介護2(new RString(新規３ヶ月要介護2 + 区分３ヶ月要介護2));
        henkojokyo.set新規_３ヶ月_二次判定要介護3(new RString(新規３ヶ月要介護3 + 区分３ヶ月要介護3));
        henkojokyo.set新規_３ヶ月_二次判定要介護4(new RString(新規３ヶ月要介護4 + 区分３ヶ月要介護4));
        henkojokyo.set新規_３ヶ月_二次判定要介護5(new RString(新規３ヶ月要介護5 + 区分３ヶ月要介護5));
        set新規_３ヶ月_計();
        henkojokyo.set新規_６ヶ月_二次判定非該当(new RString(新規６ヶ月非該当 + 区分６ヶ月非該当));
        henkojokyo.set新規_６ヶ月_二次判定要支援1(new RString(新規６ヶ月要支援1 + 区分６ヶ月要支援1));
        henkojokyo.set新規_６ヶ月_二次判定要支援2(new RString(新規６ヶ月要支援2 + 区分６ヶ月要支援2));
        henkojokyo.set新規_６ヶ月_二次判定要介護1(new RString(新規６ヶ月要介護1 + 区分６ヶ月要介護1));
        henkojokyo.set新規_６ヶ月_二次判定要介護2(new RString(新規６ヶ月要介護2 + 区分６ヶ月要介護2));
        henkojokyo.set新規_６ヶ月_二次判定要介護3(new RString(新規６ヶ月要介護3 + 区分６ヶ月要介護3));
        henkojokyo.set新規_６ヶ月_二次判定要介護4(new RString(新規６ヶ月要介護4 + 区分６ヶ月要介護4));
        henkojokyo.set新規_６ヶ月_二次判定要介護5(new RString(新規６ヶ月要介護5 + 区分６ヶ月要介護5));
        set新規_６ヶ月_計();
        henkojokyo.set新規_１２ヶ月_二次判定非該当(new RString(新規１２ヶ月非該当 + 区分１２ヶ月非該当));
        henkojokyo.set新規_１２ヶ月_二次判定要支援1(new RString(新規１２ヶ月要支援1 + 区分１２ヶ月要支援1));
        henkojokyo.set新規_１２ヶ月_二次判定要支援2(new RString(新規１２ヶ月要支援2 + 区分１２ヶ月要支援2));
        henkojokyo.set新規_１２ヶ月_二次判定要介護1(new RString(新規１２ヶ月要介護1 + 区分１２ヶ月要介護1));
        henkojokyo.set新規_１２ヶ月_二次判定要介護2(new RString(新規１２ヶ月要介護2 + 区分１２ヶ月要介護2));
        henkojokyo.set新規_１２ヶ月_二次判定要介護3(new RString(新規１２ヶ月要介護3 + 区分１２ヶ月要介護3));
        henkojokyo.set新規_１２ヶ月_二次判定要介護4(new RString(新規１２ヶ月要介護4 + 区分１２ヶ月要介護4));
        henkojokyo.set新規_１２ヶ月_二次判定要介護5(new RString(新規１２ヶ月要介護5 + 区分１２ヶ月要介護5));
        set新規_１２ヶ月_計();
        henkojokyo.set新規_２４ヶ月_二次判定非該当(new RString(新規２４ヶ月非該当 + 区分２４ヶ月非該当));
        henkojokyo.set新規_２４ヶ月_二次判定要支援1(new RString(新規２４ヶ月要支援1 + 区分２４ヶ月要支援1));
        henkojokyo.set新規_２４ヶ月_二次判定要支援2(new RString(新規２４ヶ月要支援2 + 区分２４ヶ月要支援2));
        henkojokyo.set新規_２４ヶ月_二次判定要介護1(new RString(新規２４ヶ月要介護1 + 区分２４ヶ月要介護1));
        henkojokyo.set新規_２４ヶ月_二次判定要介護2(new RString(新規２４ヶ月要介護2 + 区分２４ヶ月要介護2));
        henkojokyo.set新規_２４ヶ月_二次判定要介護3(new RString(新規２４ヶ月要介護3 + 区分２４ヶ月要介護3));
        henkojokyo.set新規_２４ヶ月_二次判定要介護4(new RString(新規２４ヶ月要介護4 + 区分２４ヶ月要介護4));
        henkojokyo.set新規_２４ヶ月_二次判定要介護5(new RString(新規２４ヶ月要介護5 + 区分２４ヶ月要介護5));
        set新規_２４ヶ月_計();
        henkojokyo.set新規_その他_二次判定非該当(new RString(新規その他非該当 + 区分その他非該当));
        henkojokyo.set新規_その他_二次判定要支援1(new RString(新規その他要支援1 + 区分その他要支援1));
        henkojokyo.set新規_その他_二次判定要支援2(new RString(新規その他要支援2 + 区分その他要支援2));
        henkojokyo.set新規_その他_二次判定要介護1(new RString(新規その他要介護1 + 区分その他要介護1));
        henkojokyo.set新規_その他_二次判定要介護2(new RString(新規その他要介護2 + 区分その他要介護2));
        henkojokyo.set新規_その他_二次判定要介護3(new RString(新規その他要介護3 + 区分その他要介護3));
        henkojokyo.set新規_その他_二次判定要介護4(new RString(新規その他要介護4 + 区分その他要介護4));
        henkojokyo.set新規_その他_二次判定要介護5(new RString(新規その他要介護5 + 区分その他要介護5));
        set新規_その他_計();
    }

    /**
     * 審査判定の変更状況を設定します。
     *
     * @param 新規区分変更延長件数 List<SinsakaiHanteiJyokyoEntity>
     * @param 更新申請延長件数 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set認定有効期間延長件数(List<SinsakaiHanteiJyokyoEntity> 新規区分変更延長件数,
            List<SinsakaiHanteiJyokyoEntity> 更新申請延長件数) {
        int 新規区分変更要支援1 = get被保険者数(新規区分変更延長件数, 要支援1);
        int 新規区分変更要支援2 = get被保険者数(新規区分変更延長件数, 要支援2);
        int 新規区分変更要介護1 = get被保険者数(新規区分変更延長件数, 要介護1);
        int 新規区分変更要介護2 = get被保険者数(新規区分変更延長件数, 要介護2);
        int 新規区分変更要介護3 = get被保険者数(新規区分変更延長件数, 要介護3);
        int 新規区分変更要介護4 = get被保険者数(新規区分変更延長件数, 要介護4);
        int 新規区分変更要介護5 = get被保険者数(新規区分変更延長件数, 要介護5);
        int 更新申請要支援1 = get被保険者数(更新申請延長件数, 要支援1);
        int 更新申請要支援2 = get被保険者数(更新申請延長件数, 要支援2);
        int 更新申請要介護1 = get被保険者数(更新申請延長件数, 要介護1);
        int 更新申請要介護2 = get被保険者数(更新申請延長件数, 要介護2);
        int 更新申請要介護3 = get被保険者数(更新申請延長件数, 要介護3);
        int 更新申請要介護4 = get被保険者数(更新申請延長件数, 要介護4);
        int 更新申請要介護5 = get被保険者数(更新申請延長件数, 要介護5);
        henkojokyo.set更新_認定有効期間延長件数_二次判定非該当(なし);
        henkojokyo.set更新_認定有効期間延長件数_二次判定要支援1(new RString(更新申請要支援1));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要支援2(new RString(更新申請要支援2));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護1(new RString(更新申請要介護1));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護2(new RString(更新申請要介護2));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護3(new RString(更新申請要介護3));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護4(new RString(更新申請要介護4));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護5(new RString(更新申請要介護5));
        set更新_認定有効期間延長件数_計();
        henkojokyo.set新規_認定有効期間延長件数_二次判定非該当(なし);
        henkojokyo.set新規_認定有効期間延長件数_二次判定要支援1(new RString(新規区分変更要支援1));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要支援2(new RString(新規区分変更要支援2));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護1(new RString(新規区分変更要介護1));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護2(new RString(新規区分変更要介護2));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護3(new RString(新規区分変更要介護3));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護4(new RString(新規区分変更要介護4));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護5(new RString(新規区分変更要介護5));
        set新規_認定有効期間延長件数_計();
    }

    /**
     * 審査判定の変更状況を設定します。
     *
     * @param 新規区分変更延長件数 List<SinsakaiHanteiJyokyoEntity>
     * @param 更新申請要支援要支援延長件数 List<SinsakaiHanteiJyokyoEntity>
     * @param 更新申請要支援要介護延長件数 List<SinsakaiHanteiJyokyoEntity>
     * @param 更新申請要介護要支援延長件数 List<SinsakaiHanteiJyokyoEntity>
     * @param 更新申請要介護要介護延長件数 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set認定有効期間延長件数(List<SinsakaiHanteiJyokyoEntity> 新規区分変更延長件数,
            List<SinsakaiHanteiJyokyoEntity> 更新申請要支援要支援延長件数,
            List<SinsakaiHanteiJyokyoEntity> 更新申請要支援要介護延長件数,
            List<SinsakaiHanteiJyokyoEntity> 更新申請要介護要支援延長件数,
            List<SinsakaiHanteiJyokyoEntity> 更新申請要介護要介護延長件数) {
        int 新規区分変更要支援1 = get被保険者数(新規区分変更延長件数, 要支援1);
        int 新規区分変更要支援2 = get被保険者数(新規区分変更延長件数, 要支援2);
        int 新規区分変更要介護1 = get被保険者数(新規区分変更延長件数, 要介護1);
        int 新規区分変更要介護2 = get被保険者数(新規区分変更延長件数, 要介護2);
        int 新規区分変更要介護3 = get被保険者数(新規区分変更延長件数, 要介護3);
        int 新規区分変更要介護4 = get被保険者数(新規区分変更延長件数, 要介護4);
        int 新規区分変更要介護5 = get被保険者数(新規区分変更延長件数, 要介護5);
        int 更新申請要支援要支援要支援1 = get被保険者数(更新申請要支援要支援延長件数, 要支援1);
        int 更新申請要支援要支援要支援2 = get被保険者数(更新申請要支援要支援延長件数, 要支援2);
        int 更新申請要支援要介護要介護1 = get被保険者数(更新申請要支援要介護延長件数, 要介護1);
        int 更新申請要支援要介護要介護2 = get被保険者数(更新申請要支援要介護延長件数, 要介護2);
        int 更新申請要支援要介護要介護3 = get被保険者数(更新申請要支援要介護延長件数, 要介護3);
        int 更新申請要支援要介護要介護4 = get被保険者数(更新申請要支援要介護延長件数, 要介護4);
        int 更新申請要支援要介護要介護5 = get被保険者数(更新申請要支援要介護延長件数, 要介護5);
        int 更新申請要介護要支援要支援1 = get被保険者数(更新申請要介護要支援延長件数, 要支援1);
        int 更新申請要介護要支援要支援2 = get被保険者数(更新申請要介護要支援延長件数, 要支援2);
        int 更新申請要介護要介護要介護1 = get被保険者数(更新申請要介護要介護延長件数, 要介護1);
        int 更新申請要介護要介護要介護2 = get被保険者数(更新申請要介護要介護延長件数, 要介護2);
        int 更新申請要介護要介護要介護3 = get被保険者数(更新申請要介護要介護延長件数, 要介護3);
        int 更新申請要介護要介護要介護4 = get被保険者数(更新申請要介護要介護延長件数, 要介護4);
        int 更新申請要介護要介護要介護5 = get被保険者数(更新申請要介護要介護延長件数, 要介護5);
        henkojokyo.set更新_認定有効期間延長件数_二次判定非該当(なし);
        henkojokyo.set更新_認定有効期間延長件数_二次判定要支援1(new RString(更新申請要支援要支援要支援1 + 更新申請要介護要支援要支援1));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要支援2(new RString(更新申請要支援要支援要支援2 + 更新申請要介護要支援要支援2));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護1(new RString(更新申請要支援要介護要介護1 + 更新申請要介護要介護要介護1));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護2(new RString(更新申請要支援要介護要介護2 + 更新申請要介護要介護要介護2));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護3(new RString(更新申請要支援要介護要介護3 + 更新申請要介護要介護要介護3));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護4(new RString(更新申請要支援要介護要介護4 + 更新申請要介護要介護要介護4));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護5(new RString(更新申請要支援要介護要介護5 + 更新申請要介護要介護要介護5));
        set更新_認定有効期間延長件数_計();
        henkojokyo.set新規_認定有効期間延長件数_二次判定非該当(なし);
        henkojokyo.set新規_認定有効期間延長件数_二次判定要支援1(new RString(新規区分変更要支援1));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要支援2(new RString(新規区分変更要支援2));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護1(new RString(新規区分変更要介護1));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護2(new RString(新規区分変更要介護2));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護3(new RString(新規区分変更要介護3));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護4(new RString(新規区分変更要介護4));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護5(new RString(新規区分変更要介護5));
        set新規_認定有効期間延長件数_計();
    }

    private void set更新_認定有効期間延長件数_計() {
        henkojokyo.set更新_認定有効期間延長件数_計(new RString(getIntValue(henkojokyo.get更新_認定有効期間延長件数_二次判定非該当())
                + getIntValue(henkojokyo.get更新_認定有効期間延長件数_二次判定要支援1())
                + getIntValue(henkojokyo.get更新_認定有効期間延長件数_二次判定要支援2())
                + getIntValue(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護1())
                + getIntValue(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護2())
                + getIntValue(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護3())
                + getIntValue(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護4())
                + getIntValue(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護5())));
    }

    private void set新規_認定有効期間延長件数_計() {
        henkojokyo.set新規_認定有効期間延長件数_計(new RString(getIntValue(henkojokyo.get新規_認定有効期間延長件数_二次判定非該当())
                + getIntValue(henkojokyo.get新規_認定有効期間延長件数_二次判定要支援1())
                + getIntValue(henkojokyo.get新規_認定有効期間延長件数_二次判定要支援2())
                + getIntValue(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護1())
                + getIntValue(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護2())
                + getIntValue(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護3())
                + getIntValue(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護4())
                + getIntValue(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護5())));
    }

    private void set新規申請_計() {
        henkojokyo.set新規申請_計(new RString(getIntValue(henkojokyo.get新規申請_二次判定非該当())
                + getIntValue(henkojokyo.get新規申請_二次判定要支援1())
                + getIntValue(henkojokyo.get新規申請_二次判定要支援2())
                + getIntValue(henkojokyo.get新規申請_二次判定要介護1())
                + getIntValue(henkojokyo.get新規申請_二次判定要介護2())
                + getIntValue(henkojokyo.get新規申請_二次判定要介護3())
                + getIntValue(henkojokyo.get新規申請_二次判定要介護4())
                + getIntValue(henkojokyo.get新規申請_二次判定要介護5())));
    }

    private void set新規_区分変更申請_計() {
        henkojokyo.set新規_区分変更申請_計(new RString(getIntValue(henkojokyo.get新規_区分変更申請_二次判定非該当())
                + getIntValue(henkojokyo.get新規_区分変更申請_二次判定要支援1())
                + getIntValue(henkojokyo.get新規_区分変更申請_二次判定要支援2())
                + getIntValue(henkojokyo.get新規_区分変更申請_二次判定要介護1())
                + getIntValue(henkojokyo.get新規_区分変更申請_二次判定要介護2())
                + getIntValue(henkojokyo.get新規_区分変更申請_二次判定要介護3())
                + getIntValue(henkojokyo.get新規_区分変更申請_二次判定要介護4())
                + getIntValue(henkojokyo.get新規_区分変更申請_二次判定要介護5())));
    }

    private void set新規_３ヶ月_計() {
        henkojokyo.set新規_３ヶ月_計(new RString(getIntValue(henkojokyo.get新規_３ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get新規_３ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get新規_３ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get新規_３ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get新規_３ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get新規_３ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get新規_３ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get新規_３ヶ月_二次判定要介護5())));
    }

    private void set新規_６ヶ月_計() {
        henkojokyo.set新規_６ヶ月_計(new RString(getIntValue(henkojokyo.get新規_６ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get新規_６ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get新規_６ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get新規_６ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get新規_６ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get新規_６ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get新規_６ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get新規_６ヶ月_二次判定要介護5())));
    }

    private void set新規_１２ヶ月_計() {
        henkojokyo.set新規_１２ヶ月_計(new RString(getIntValue(henkojokyo.get新規_１２ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get新規_１２ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get新規_１２ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get新規_１２ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get新規_１２ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get新規_１２ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get新規_１２ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get新規_１２ヶ月_二次判定要介護5())));
    }

    private void set新規_２４ヶ月_計() {
        henkojokyo.set新規_２４ヶ月_計(new RString(getIntValue(henkojokyo.get新規_２４ヶ月_二次判定非該当())
                + getIntValue(henkojokyo.get新規_２４ヶ月_二次判定要支援1())
                + getIntValue(henkojokyo.get新規_２４ヶ月_二次判定要支援2())
                + getIntValue(henkojokyo.get新規_２４ヶ月_二次判定要介護1())
                + getIntValue(henkojokyo.get新規_２４ヶ月_二次判定要介護2())
                + getIntValue(henkojokyo.get新規_２４ヶ月_二次判定要介護3())
                + getIntValue(henkojokyo.get新規_２４ヶ月_二次判定要介護4())
                + getIntValue(henkojokyo.get新規_２４ヶ月_二次判定要介護5())));
    }

    private void set新規_その他_計() {
        henkojokyo.set新規_その他_計(new RString(getIntValue(henkojokyo.get新規_その他_二次判定非該当())
                + getIntValue(henkojokyo.get新規_その他_二次判定要支援1())
                + getIntValue(henkojokyo.get新規_その他_二次判定要支援2())
                + getIntValue(henkojokyo.get新規_その他_二次判定要介護1())
                + getIntValue(henkojokyo.get新規_その他_二次判定要介護2())
                + getIntValue(henkojokyo.get新規_その他_二次判定要介護3())
                + getIntValue(henkojokyo.get新規_その他_二次判定要介護4())
                + getIntValue(henkojokyo.get新規_その他_二次判定要介護5())));
    }

    private int get被保険者数(List<SinsakaiHanteiJyokyoEntity> 判定状況, RString 二次判定要介護状態区分コード) {
        for (SinsakaiHanteiJyokyoEntity sinsakaiHanteiJyokyoEntity : 判定状況) {
            if (二次判定要介護状態区分コード.equals(sinsakaiHanteiJyokyoEntity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
                return sinsakaiHanteiJyokyoEntity.getHihokenshaCount();
            }
        }
        return 0;
    }

    private int getIntValue(RString 被保険者数) {
        if (RString.isNullOrEmpty(被保険者数)) {
            return 0;
        }
        return Integer.parseInt(被保険者数.toString());
    }
}
