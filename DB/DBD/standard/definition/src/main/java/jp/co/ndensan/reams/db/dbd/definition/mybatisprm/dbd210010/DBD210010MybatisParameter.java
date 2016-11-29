/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd210010;

import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付制限対象者一覧CSVのmybatisパラメータクラスです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD210010MybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private boolean 全登録者;
    private boolean 二号差止予告登録者;
    private boolean 二号差止登録者;
    private boolean 一号償還予告登録者;
    private boolean 一号償還決定登録者;
    private boolean 一号償還決定登録者_差止中あり;
    private boolean 一号償還決定登録者_保険料控除あり;
    private boolean 一号給付制限登録者;
    private RString 出力順;
    private RString 給付制限状態;
    private FlexibleDate システム日付;
    private RString 支払方法変更管理区分;
    private RString 支払方法変更登録区分_2号予告登録者;
    private RString 支払方法変更登録区分_1号償還払い化登録;
    private RString 支払方法変更登録区分_1号給付額減額登録;
    private RDate 納期限;
    private static final int NUM5 = 5;
    private static final int NUM8 = 8;

    private boolean is管理区分_1;
    private boolean is管理区分_2;
    private boolean is管理区分_3;

    private boolean is登録区分_01;
    private boolean is登録区分_02;
    private boolean is登録区分_11;
    private boolean is登録区分_12;
    private boolean is登録区分_21;

    private boolean is終了区分_無条件;
    private boolean is終了区分_空白;
    private boolean is終了区分_空白以外;
    private boolean is終了区分_二重;

    private boolean is他の条件_1;
    private boolean is他の条件_2;
    private boolean is他の条件_2_差止登録;
    private boolean is他の条件_2_差止解除;

    private boolean is他の条件_3;
    private boolean is他の条件_システム日付期間内;
    private boolean is他の条件_システム日付期间外;

    private static final RString 全て = new RString("全て");
    private static final RString 適用中 = new RString("適用中");
    private static final RString 終了 = new RString("終了");

    /**
     *
     * @param 全登録者 boolean
     * @param 二号差止予告登録者 boolean
     * @param 二号差止登録者 boolean
     * @param 一号償還予告登録者 boolean
     * @param 一号償還決定登録者 boolean
     * @param 一号償還決定登録者_差止中あり boolean
     * @param 一号償還決定登録者_保険料控除あり boolean
     * @param 一号給付制限登録者 boolean
     * @param 出力順 RString
     * @param 給付制限状態 RString
     * @param 基準日 FlexibleDate
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public DBD210010MybatisParameter(boolean 全登録者, boolean 二号差止予告登録者, boolean 二号差止登録者, boolean 一号償還予告登録者,
            boolean 一号償還決定登録者, boolean 一号償還決定登録者_差止中あり, boolean 一号償還決定登録者_保険料控除あり, boolean 一号給付制限登録者,
            RString 出力順, RString 給付制限状態, FlexibleDate 基準日, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.全登録者 = 全登録者;
        this.二号差止登録者 = 二号差止登録者;
        this.二号差止予告登録者 = 二号差止予告登録者;
        this.一号償還予告登録者 = 一号償還予告登録者;
        this.一号償還決定登録者 = 一号償還決定登録者;
        this.一号給付制限登録者 = 一号給付制限登録者;
        this.一号償還決定登録者_保険料控除あり = 一号償還決定登録者_保険料控除あり;
        this.一号償還決定登録者_差止中あり = 一号償還決定登録者_差止中あり;
        this.出力順 = 出力順;
        this.給付制限状態 = 給付制限状態;
        this.システム日付 = FlexibleDate.getNowDate();
        set管理区分(二号差止予告登録者, 二号差止登録者, 一号償還予告登録者, 一号償還決定登録者, 一号償還決定登録者_差止中あり,
                一号償還決定登録者_保険料控除あり, 一号給付制限登録者);
        set登録区分(二号差止予告登録者, 二号差止登録者, 一号償還予告登録者, 一号償還決定登録者, 一号償還決定登録者_差止中あり,
                一号償還決定登録者_保険料控除あり, 一号給付制限登録者);
        set終了区分(給付制限状態, 二号差止予告登録者, 二号差止登録者, 一号償還予告登録者, 一号償還決定登録者,
                一号償還決定登録者_差止中あり, 一号償還決定登録者_保険料控除あり, 一号給付制限登録者);
        setその他の条件(給付制限状態, 一号償還決定登録者,
                一号償還決定登録者_差止中あり, 一号償還決定登録者_保険料控除あり, 一号給付制限登録者);
        this.支払方法変更管理区分 = ShiharaiHenkoKanriKubun._１号給付額減額.getコード();
        this.支払方法変更登録区分_2号予告登録者 = ShiharaiHenkoTorokuKubun._２号予告登録者.getコード();
        this.支払方法変更登録区分_1号償還払い化登録 = ShiharaiHenkoTorokuKubun._１号償還払い化登録.getコード();
        this.支払方法変更登録区分_1号給付額減額登録 = ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード();
        set納期限(基準日);
    }

    private void set管理区分(boolean 二号差止予告登録者, boolean 二号差止登録者, boolean 一号償還予告登録者,
            boolean 一号償還決定登録者, boolean 一号償還決定登録者_差止中あり, boolean 一号償還決定登録者_保険料控除あり, boolean 一号給付制限登録者) {
        is管理区分_1 = false;
        is管理区分_2 = false;
        is管理区分_3 = false;
        if (二号差止予告登録者 || 二号差止登録者) {
            is管理区分_1 = true;
        }
        if (一号償還予告登録者 || 一号償還決定登録者 || 一号償還決定登録者_差止中あり || 一号償還決定登録者_保険料控除あり) {
            is管理区分_2 = true;
        }
        if (一号給付制限登録者) {
            is管理区分_3 = true;
        }
    }

    private void set登録区分(boolean 二号差止予告登録者, boolean 二号差止登録者, boolean 一号償還予告登録者,
            boolean 一号償還決定登録者, boolean 一号償還決定登録者_差止中あり, boolean 一号償還決定登録者_保険料控除あり, boolean 一号給付制限登録者) {
        is登録区分_01 = false;
        is登録区分_02 = false;
        is登録区分_11 = false;
        is登録区分_12 = false;
        is登録区分_21 = false;
        if (二号差止予告登録者) {
            is登録区分_01 = true;
        }
        if (二号差止登録者) {
            is登録区分_02 = true;
        }
        if (一号償還予告登録者) {
            is登録区分_11 = true;
        }
        if (一号償還決定登録者 || 一号償還決定登録者_差止中あり || 一号償還決定登録者_保険料控除あり) {
            is登録区分_12 = true;
        }
        if (一号給付制限登録者) {
            is登録区分_21 = true;
        }
    }

    private void set終了区分(RString 給付制限状態, boolean 二号差止予告登録者, boolean 二号差止登録者, boolean 一号償還予告登録者,
            boolean 一号償還決定登録者, boolean 一号償還決定登録者_差止中あり, boolean 一号償還決定登録者_保険料控除あり, boolean 一号給付制限登録者) {
        is終了区分_無条件 = false;
        is終了区分_空白 = false;
        is終了区分_空白以外 = false;
        is終了区分_二重 = false;
        if (二号差止予告登録者 || 二号差止登録者 || 一号償還予告登録者 || 一号償還決定登録者) {
            if (全て.equals(給付制限状態)) {
                is終了区分_無条件 = true;
            } else if (適用中.equals(給付制限状態)) {
                is終了区分_空白 = true;
            } else if (終了.equals(給付制限状態)) {
                is終了区分_空白以外 = true;
            }
        }
        if (一号償還決定登録者_差止中あり) {
            if (終了.equals(給付制限状態) || 適用中.equals(給付制限状態)) {
                is終了区分_空白 = true;
            } else {
                is終了区分_無条件 = true;
            }
        }
        if (一号償還決定登録者_保険料控除あり) {
            if (適用中.equals(給付制限状態)) {
                is終了区分_空白 = true;
            } else if (全て.equals(給付制限状態)) {
                is終了区分_無条件 = true;
            }
        }
        if (一号給付制限登録者) {
            if (全て.equals(給付制限状態)) {
                is終了区分_無条件 = true;
            } else if (適用中.equals(給付制限状態)) {
                is終了区分_空白 = true;
            } else if (終了.equals(給付制限状態)) {
                is終了区分_二重 = true;
            }
        }
    }

    private void setその他の条件(RString 給付制限状態,
            boolean 一号償還決定登録者, boolean 一号償還決定登録者_差止中あり, boolean 一号償還決定登録者_保険料控除あり, boolean 一号給付制限登録者) {
        is他の条件_1 = false;
        is他の条件_2 = false;
        is他の条件_2_差止登録 = false;
        is他の条件_2_差止解除 = false;
        is他の条件_3 = false;
        is他の条件_システム日付期間内 = false;
        is他の条件_システム日付期间外 = false;

        if (一号償還決定登録者) {
            is他の条件_1 = true;
        }
        if (一号償還決定登録者_差止中あり) {
            is他の条件_2 = true;
            if (適用中.equals(給付制限状態)) {
                is他の条件_2_差止登録 = true;
            } else if (終了.equals(給付制限状態)) {
                is他の条件_2_差止解除 = true;
            }
        }
        if (一号償還決定登録者_保険料控除あり) {
            is他の条件_3 = true;
        }
        if (一号給付制限登録者) {
            if (適用中.equals(給付制限状態)) {
                is他の条件_システム日付期間内 = true;
            } else if (終了.equals(給付制限状態)) {
                is他の条件_システム日付期间外 = true;
            }
        }
    }

    private void set納期限(FlexibleDate 基準日) {
        RString date1 = new RString("0229");
        RString date2 = new RString("0228");
        if (date1.toString().equals(基準日.toString().substring(NUM5, NUM8))) {
            納期限 = new RDate(基準日.minusYear(2).getYear().toString().concat(date2.toString()));
        } else {
            納期限 = new RDate(基準日.minusYear(2).toString());
        }
    }
}
