/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import java.text.DecimalFormat;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.SinsakaiHanteiJyokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsaHanteiJokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class SinsakaiHanteiJyokyoHeaderHanteiEditor {

    private static final int 桁数_市町村コード_CD除く = 5;
    private static final RString 帳票タイトル = new RString("介護認定審査会判定状況表");
    private static final RString 割合なし = new RString("0.0%");
    private static final RString 非該当 = new RString("非該当");
    private static final RString 要支援1 = new RString("要支援1");
    private static final RString 要支援2 = new RString("要支援2");
    private static final RString 要介護1 = new RString("要介護1");
    private static final RString 要介護2 = new RString("要介護2");
    private static final RString 要介護3 = new RString("要介護3");
    private static final RString 要介護4 = new RString("要介護4");
    private static final RString 要介護5 = new RString("要介護5");
    private static final RString 計 = new RString("計");
    private static final RString 全合議体 = new RString("全合議体");
    private static final RString 変更者 = new RString("変更者");
    private static final RString パーセント = new RString("%");
    private static final RString 全市町村コード = new RString("000000");
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString コード_非該当 = new RString("01");
    private static final RString コード_要支援1 = new RString("12");
    private static final RString コード_要支援2 = new RString("13");
    private static final RString コード_要介護1 = new RString("21");
    private static final RString コード_要介護2 = new RString("22");
    private static final RString コード_要介護3 = new RString("23");
    private static final RString コード_要介護4 = new RString("24");
    private static final RString コード_要介護5 = new RString("25");
    private static final RString コード_再調査 = new RString("31");
    private static final DecimalFormat FORMAT = new DecimalFormat("0.0");
    private static final int 割合 = 100;
    private final SinsakaiHanteiJyokyoProcessParameter parameter;
    private final SinsakaiHanteiJyokyoHeaderEntity entity;
    private final ShinsaHanteiJokyoEntity shinsaHanteiJokyo;

    /**
     * コンストラクタです。
     *
     * @param parameter SinsakaiHanteiJyokyoProcessParameter
     * @param entity SinsakaiHanteiJyokyoHeaderEntity
     * @param shinsaHanteiJokyo ShinsaHanteiJokyoEntity
     */
    public SinsakaiHanteiJyokyoHeaderHanteiEditor(
            SinsakaiHanteiJyokyoProcessParameter parameter,
            SinsakaiHanteiJyokyoHeaderEntity entity,
            ShinsaHanteiJokyoEntity shinsaHanteiJokyo) {
        this.parameter = parameter;
        this.entity = entity;
        this.shinsaHanteiJokyo = shinsaHanteiJokyo;
    }

    /**
     * 介護認定審査会判定状況を設定します。
     *
     * @param 審査判定状況 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set介護認定審査会判定状況(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        setヘッダ情報(entity);
        set一次判定非該当(審査判定状況);
        set一次判定要支援1(審査判定状況);
        set一次判定要支援2(審査判定状況);
        set一次判定要介護1(審査判定状況);
        set一次判定要介護2(審査判定状況);
        set一次判定要介護3(審査判定状況);
        set一次判定要介護4(審査判定状況);
        set一次判定要介護5(審査判定状況);
        set計();
        set変更者();
        set割合();
        set判定件数();
    }

    private void set一次判定非該当(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 非該当非該当被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_非該当);
        int 非該当要支援1被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要支援1);
        int 非該当要支援2被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要支援2);
        int 非該当要介護1被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護1);
        int 非該当要介護2被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護2);
        int 非該当要介護3被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護3);
        int 非該当要介護4被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護4);
        int 非該当要介護5被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護5);
        int 非該当計 = 非該当非該当被保険者数 + 非該当要支援1被保険者数 + 非該当要支援2被保険者数 + 非該当要介護1被保険者数
                + 非該当要介護2被保険者数 + 非該当要介護3被保険者数 + 非該当要介護4被保険者数 + 非該当要介護5被保険者数;
        shinsaHanteiJokyo.set一次判定非該当タイトル(非該当);
        shinsaHanteiJokyo.set一次判定非該当二次判定非該当(toRString(非該当非該当被保険者数));
        shinsaHanteiJokyo.set一次判定非該当二次判定要支援1(toRString(非該当要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定非該当二次判定要支援2(toRString(非該当要支援2被保険者数));
        shinsaHanteiJokyo.set一次判定非該当二次判定要介護1(toRString(非該当要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定非該当二次判定要介護2(toRString(非該当要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定非該当二次判定要介護3(toRString(非該当要介護3被保険者数));
        shinsaHanteiJokyo.set一次判定非該当二次判定要介護4(toRString(非該当要介護4被保険者数));
        shinsaHanteiJokyo.set一次判定非該当二次判定要介護5(toRString(非該当要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定非該当計(new RString(非該当計));
        shinsaHanteiJokyo.set一次判定非該当再調査二次保留分(toRString(get被保険者数(審査判定状況, コード_非該当, コード_再調査)));
        shinsaHanteiJokyo.set一次判定非該当判定変更者数(toRString(非該当計 - 非該当非該当被保険者数));
        shinsaHanteiJokyo.set一次判定非該当軽度変更者数(RString.EMPTY);
        shinsaHanteiJokyo.set一次判定非該当重度変更者数(toRString(非該当計 - 非該当非該当被保険者数));
        if (非該当計 == 0) {
            shinsaHanteiJokyo.set一次判定非該当判定変更割合(割合なし);
        } else {
            shinsaHanteiJokyo.set一次判定非該当判定変更割合(get割合結果(非該当計 - 非該当非該当被保険者数, 非該当計));
        }
    }

    private void set一次判定要支援1(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要支援1非該当被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_非該当);
        int 要支援1要支援1被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要支援1);
        int 要支援1要支援2被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要支援2);
        int 要支援1要介護1被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護1);
        int 要支援1要介護2被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護2);
        int 要支援1要介護3被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護3);
        int 要支援1要介護4被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護4);
        int 要支援1要介護5被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護5);
        int 要支援1計 = 要支援1非該当被保険者数 + 要支援1要支援1被保険者数 + 要支援1要支援2被保険者数 + 要支援1要介護1被保険者数
                + 要支援1要介護2被保険者数 + 要支援1要介護3被保険者数 + 要支援1要介護4被保険者数 + 要支援1要介護5被保険者数;
        shinsaHanteiJokyo.set一次判定要支援1タイトル(要支援1);
        shinsaHanteiJokyo.set一次判定要支援1二次判定非該当(toRString(要支援1非該当被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1二次判定要支援1(toRString(要支援1要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1二次判定要支援2(toRString(要支援1要支援2被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1二次判定要介護1(toRString(要支援1要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1二次判定要介護2(toRString(要支援1要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1二次判定要介護3(toRString(要支援1要介護3被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1二次判定要介護4(toRString(要支援1要介護4被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1二次判定要介護5(toRString(要支援1要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1計(new RString(要支援1計));
        shinsaHanteiJokyo.set一次判定要支援1再調査二次保留分(toRString(get被保険者数(審査判定状況, コード_要支援1, コード_再調査)));
        shinsaHanteiJokyo.set一次判定要支援1判定変更者数(toRString(要支援1計 - 要支援1要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1軽度変更者数(toRString(要支援1非該当被保険者数));
        shinsaHanteiJokyo.set一次判定要支援1重度変更者数(toRString(要支援1計 - 要支援1非該当被保険者数 - 要支援1要支援1被保険者数));
        if (要支援1計 == 0) {
            shinsaHanteiJokyo.set一次判定要支援1判定変更割合(割合なし);
        } else {
            shinsaHanteiJokyo.set一次判定要支援1判定変更割合(get割合結果(要支援1計 - 要支援1要支援1被保険者数, 要支援1計));
        }
    }

    private void set一次判定要支援2(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要支援2非該当被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_非該当);
        int 要支援2要支援1被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要支援1);
        int 要支援2要支援2被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要支援2);
        int 要支援2要介護1被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護1);
        int 要支援2要介護2被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護2);
        int 要支援2要介護3被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護3);
        int 要支援2要介護4被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護4);
        int 要支援2要介護5被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護5);
        int 要支援2計 = 要支援2非該当被保険者数 + 要支援2要支援1被保険者数 + 要支援2要支援2被保険者数 + 要支援2要介護1被保険者数
                + 要支援2要介護2被保険者数 + 要支援2要介護3被保険者数 + 要支援2要介護4被保険者数 + 要支援2要介護5被保険者数;
        shinsaHanteiJokyo.set一次判定要支援2タイトル(要支援2);
        shinsaHanteiJokyo.set一次判定要支援2二次判定非該当(toRString(要支援2非該当被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2二次判定要支援1(toRString(要支援2要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2二次判定要支援2(toRString(要支援2要支援2被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2二次判定要介護1(toRString(要支援2要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2二次判定要介護2(toRString(要支援2要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2二次判定要介護3(toRString(要支援2要介護3被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2二次判定要介護4(toRString(要支援2要介護4被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2二次判定要介護5(toRString(要支援2要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2計(new RString(要支援2計));
        shinsaHanteiJokyo.set一次判定要支援2再調査二次保留分(toRString(get被保険者数(審査判定状況, コード_要支援2, コード_再調査)));
        shinsaHanteiJokyo.set一次判定要支援2判定変更者数(toRString(要支援2計 - 要支援2要支援2被保険者数 - 要支援2要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2軽度変更者数(toRString(要支援2非該当被保険者数 + 要支援2要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要支援2重度変更者数(toRString(要支援2要介護2被保険者数 + 要支援2要介護3被保険者数 + 要支援2要介護4被保険者数 + 要支援2要介護5被保険者数));
        if (要支援2計 == 0) {
            shinsaHanteiJokyo.set一次判定要支援2判定変更割合(割合なし);
        } else {
            shinsaHanteiJokyo.set一次判定要支援2判定変更割合(get割合結果(要支援2計 - 要支援2要支援2被保険者数 - 要支援2要介護1被保険者数, 要支援2計));
        }
    }

    private void set一次判定要介護1(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護1非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_非該当);
        int 要介護1要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要支援1);
        int 要介護1要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要支援2);
        int 要介護1要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護1);
        int 要介護1要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護2);
        int 要介護1要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護3);
        int 要介護1要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護4);
        int 要介護1要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護5);
        int 要介護1計 = 要介護1非該当被保険者数 + 要介護1要支援1被保険者数 + 要介護1要支援2被保険者数 + 要介護1要介護1被保険者数
                + 要介護1要介護2被保険者数 + 要介護1要介護3被保険者数 + 要介護1要介護4被保険者数 + 要介護1要介護5被保険者数;
        shinsaHanteiJokyo.set一次判定要介護1タイトル(要介護1);
        shinsaHanteiJokyo.set一次判定要介護1二次判定非該当(toRString(要介護1非該当被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1二次判定要支援1(toRString(要介護1要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1二次判定要支援2(toRString(要介護1要支援2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1二次判定要介護1(toRString(要介護1要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1二次判定要介護2(toRString(要介護1要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1二次判定要介護3(toRString(要介護1要介護3被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1二次判定要介護4(toRString(要介護1要介護4被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1二次判定要介護5(toRString(要介護1要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1計(new RString(要介護1計));
        shinsaHanteiJokyo.set一次判定要介護1再調査二次保留分(toRString(get被保険者数(審査判定状況, コード_要介護1, コード_再調査)));
        shinsaHanteiJokyo.set一次判定要介護1判定変更者数(toRString(要介護1計 - 要介護1要介護1被保険者数 - 要介護1要支援2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1軽度変更者数(toRString(要介護1非該当被保険者数 + 要介護1要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護1重度変更者数(toRString(要介護1要介護2被保険者数 + 要介護1要介護3被保険者数 + 要介護1要介護4被保険者数 + 要介護1要介護5被保険者数));
        if (要介護1計 == 0) {
            shinsaHanteiJokyo.set一次判定要介護1判定変更割合(割合なし);
        } else {
            shinsaHanteiJokyo.set一次判定要介護1判定変更割合(get割合結果(要介護1計 - 要介護1要支援2被保険者数 - 要介護1要介護1被保険者数, 要介護1計));
        }
    }

    private void set一次判定要介護2(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護2非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_非該当);
        int 要介護2要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要支援1);
        int 要介護2要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要支援2);
        int 要介護2要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護1);
        int 要介護2要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護2);
        int 要介護2要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護3);
        int 要介護2要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護4);
        int 要介護2要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護5);
        int 要介護2計 = 要介護2非該当被保険者数 + 要介護2要支援1被保険者数 + 要介護2要支援2被保険者数 + 要介護2要介護1被保険者数
                + 要介護2要介護2被保険者数 + 要介護2要介護3被保険者数 + 要介護2要介護4被保険者数 + 要介護2要介護5被保険者数;
        shinsaHanteiJokyo.set一次判定要介護2タイトル(要介護2);
        shinsaHanteiJokyo.set一次判定要介護2二次判定非該当(toRString(要介護2非該当被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2二次判定要支援1(toRString(要介護2要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2二次判定要支援2(toRString(要介護2要支援2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2二次判定要介護1(toRString(要介護2要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2二次判定要介護2(toRString(要介護2要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2二次判定要介護3(toRString(要介護2要介護3被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2二次判定要介護4(toRString(要介護2要介護4被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2二次判定要介護5(toRString(要介護2要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2計(new RString(要介護2計));
        shinsaHanteiJokyo.set一次判定要介護2再調査二次保留分(toRString(get被保険者数(審査判定状況, コード_要介護2, コード_再調査)));
        shinsaHanteiJokyo.set一次判定要介護2判定変更者数(toRString(要介護2計 - 要介護2要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2軽度変更者数(toRString(要介護2非該当被保険者数 + 要介護2要支援1被保険者数 + 要介護2要支援2被保険者数 + 要介護2要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護2重度変更者数(toRString(要介護2要介護3被保険者数 + 要介護2要介護4被保険者数 + 要介護2要介護5被保険者数));
        if (要介護2計 == 0) {
            shinsaHanteiJokyo.set一次判定要介護2判定変更割合(割合なし);
        } else {
            shinsaHanteiJokyo.set一次判定要介護2判定変更割合(get割合結果(要介護2計 - 要介護2要介護2被保険者数, 要介護2計));
        }
    }

    private void set一次判定要介護3(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護3非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_非該当);
        int 要介護3要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要支援1);
        int 要介護3要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要支援2);
        int 要介護3要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護1);
        int 要介護3要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護2);
        int 要介護3要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護3);
        int 要介護3要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護4);
        int 要介護3要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護5);
        int 要介護3計 = 要介護3非該当被保険者数 + 要介護3要支援1被保険者数 + 要介護3要支援2被保険者数 + 要介護3要介護1被保険者数
                + 要介護3要介護2被保険者数 + 要介護3要介護3被保険者数 + 要介護3要介護4被保険者数 + 要介護3要介護5被保険者数;
        shinsaHanteiJokyo.set一次判定要介護3タイトル(要介護3);
        shinsaHanteiJokyo.set一次判定要介護3二次判定非該当(toRString(要介護3非該当被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3二次判定要支援1(toRString(要介護3要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3二次判定要支援2(toRString(要介護3要支援2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3二次判定要介護1(toRString(要介護3要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3二次判定要介護2(toRString(要介護3要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3二次判定要介護3(toRString(要介護3要介護3被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3二次判定要介護4(toRString(要介護3要介護4被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3二次判定要介護5(toRString(要介護3要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3計(new RString(要介護3計));
        shinsaHanteiJokyo.set一次判定要介護3再調査二次保留分(toRString(get被保険者数(審査判定状況, コード_要介護3, コード_再調査)));
        shinsaHanteiJokyo.set一次判定要介護3判定変更者数(toRString(要介護3計 - 要介護3要介護3被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3軽度変更者数(toRString(要介護3非該当被保険者数 + 要介護3要支援1被保険者数
                + 要介護3要支援2被保険者数 + 要介護3要介護1被保険者数 + 要介護3要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護3重度変更者数(toRString(要介護3要介護4被保険者数 + 要介護3要介護5被保険者数));
        if (要介護3計 == 0) {
            shinsaHanteiJokyo.set一次判定要介護3判定変更割合(割合なし);
        } else {
            shinsaHanteiJokyo.set一次判定要介護3判定変更割合(get割合結果(要介護3計 - 要介護3要介護3被保険者数, 要介護3計));
        }
    }

    private void set一次判定要介護4(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護4非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_非該当);
        int 要介護4要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要支援1);
        int 要介護4要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要支援2);
        int 要介護4要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護1);
        int 要介護4要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護2);
        int 要介護4要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護3);
        int 要介護4要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護4);
        int 要介護4要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護5);
        int 要介護4計 = 要介護4非該当被保険者数 + 要介護4要支援1被保険者数 + 要介護4要支援2被保険者数 + 要介護4要介護1被保険者数
                + 要介護4要介護2被保険者数 + 要介護4要介護3被保険者数 + 要介護4要介護4被保険者数 + 要介護4要介護5被保険者数;
        shinsaHanteiJokyo.set一次判定要介護4タイトル(要介護4);
        shinsaHanteiJokyo.set一次判定要介護4二次判定非該当(toRString(要介護4非該当被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4二次判定要支援1(toRString(要介護4要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4二次判定要支援2(toRString(要介護4要支援2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4二次判定要介護1(toRString(要介護4要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4二次判定要介護2(toRString(要介護4要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4二次判定要介護3(toRString(要介護4要介護3被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4二次判定要介護4(toRString(要介護4要介護4被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4二次判定要介護5(toRString(要介護4要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4計(new RString(要介護4計));
        shinsaHanteiJokyo.set一次判定要介護4再調査二次保留分(toRString(get被保険者数(審査判定状況, コード_要介護4, コード_再調査)));
        shinsaHanteiJokyo.set一次判定要介護4判定変更者数(toRString(要介護4計 - 要介護4要介護4被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4軽度変更者数(toRString(要介護4計 - 要介護4要介護4被保険者数 - 要介護4要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要介護4重度変更者数(toRString(要介護4要介護5被保険者数));
        if (要介護4計 == 0) {
            shinsaHanteiJokyo.set一次判定要介護4判定変更割合(割合なし);
        } else {
            shinsaHanteiJokyo.set一次判定要介護4判定変更割合(get割合結果(要介護4計 - 要介護4要介護4被保険者数, 要介護4計));
        }
    }

    private void set一次判定要介護5(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護5非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_非該当);
        int 要介護5要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要支援1);
        int 要介護5要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要支援2);
        int 要介護5要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護1);
        int 要介護5要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護2);
        int 要介護5要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護3);
        int 要介護5要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護4);
        int 要介護5要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護5);
        int 要介護5計 = 要介護5非該当被保険者数 + 要介護5要支援1被保険者数 + 要介護5要支援2被保険者数 + 要介護5要介護1被保険者数
                + 要介護5要介護2被保険者数 + 要介護5要介護3被保険者数 + 要介護5要介護4被保険者数 + 要介護5要介護5被保険者数;
        shinsaHanteiJokyo.set一次判定要介護5タイトル(要介護5);
        shinsaHanteiJokyo.set一次判定要介護5二次判定非該当(toRString(要介護5非該当被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5二次判定要支援1(toRString(要介護5要支援1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5二次判定要支援2(toRString(要介護5要支援2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5二次判定要介護1(toRString(要介護5要介護1被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5二次判定要介護2(toRString(要介護5要介護2被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5二次判定要介護3(toRString(要介護5要介護3被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5二次判定要介護4(toRString(要介護5要介護4被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5二次判定要介護5(toRString(要介護5要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5計(new RString(要介護5計));
        shinsaHanteiJokyo.set一次判定要介護5再調査二次保留分(toRString(get被保険者数(審査判定状況, コード_要介護5, コード_再調査)));
        shinsaHanteiJokyo.set一次判定要介護5判定変更者数(toRString(要介護5計 - 要介護5要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5軽度変更者数(toRString(要介護5計 - 要介護5要介護5被保険者数));
        shinsaHanteiJokyo.set一次判定要介護5重度変更者数(RString.EMPTY);
        if (要介護5計 == 0) {
            shinsaHanteiJokyo.set一次判定要介護5判定変更割合(割合なし);
        } else {
            shinsaHanteiJokyo.set一次判定要介護5判定変更割合(get割合結果(要介護5計 - 要介護5要介護5被保険者数, 要介護5計));
        }
    }

    private void set計() {
        shinsaHanteiJokyo.set計タイトル(計);
        shinsaHanteiJokyo.set計二次判定非該当(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定非該当())));
        shinsaHanteiJokyo.set計二次判定要支援1(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定要支援1())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定要支援1())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定要支援1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定要支援1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定要支援1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定要支援1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定要支援1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定要支援1())));
        shinsaHanteiJokyo.set計二次判定要支援2(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定要支援2())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定要支援2())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定要支援2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定要支援2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定要支援2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定要支援2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定要支援2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定要支援2())));
        shinsaHanteiJokyo.set計二次判定要介護1(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定要介護1())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定要介護1())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定要介護1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定要介護1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定要介護1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定要介護1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定要介護1())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定要介護1())));
        shinsaHanteiJokyo.set計二次判定要介護2(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定要介護2())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定要介護2())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定要介護2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定要介護2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定要介護2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定要介護2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定要介護2())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定要介護2())));
        shinsaHanteiJokyo.set計二次判定要介護3(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定要介護3())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定要介護3())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定要介護3())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定要介護3())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定要介護3())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定要介護3())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定要介護3())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定要介護3())));
        shinsaHanteiJokyo.set計二次判定要介護4(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定要介護4())));
        shinsaHanteiJokyo.set計二次判定要介護5(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定要介護4())));
        int 計計 = toInt(shinsaHanteiJokyo.get一次判定非該当計())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1計())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2計())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1計())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2計())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3計())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4計())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5計());
        shinsaHanteiJokyo.set計計(new RString(計計));
        shinsaHanteiJokyo.set計再調査二次保留分(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当再調査二次保留分())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1再調査二次保留分())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2再調査二次保留分())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1再調査二次保留分())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2再調査二次保留分())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3再調査二次保留分())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4再調査二次保留分())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5再調査二次保留分())));
        int 計判定変更者数 = toInt(shinsaHanteiJokyo.get一次判定非該当判定変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1判定変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2判定変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1判定変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2判定変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3判定変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4判定変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5判定変更者数());
        shinsaHanteiJokyo.set計判定変更者数(new RString(計判定変更者数));
        shinsaHanteiJokyo.set計軽度変更者数(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当軽度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1軽度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2軽度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1軽度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2軽度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3軽度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4軽度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5軽度変更者数())));
        shinsaHanteiJokyo.set計重度変更者数(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当重度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1重度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2重度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1重度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2重度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3重度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4重度変更者数())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5重度変更者数())));
        if (計計 == 0) {
            shinsaHanteiJokyo.set計判定変更割合(割合なし);
        } else {
            shinsaHanteiJokyo.set計判定変更割合(get割合結果(計判定変更者数, 計計));
        }
    }

    private void set変更者() {
        shinsaHanteiJokyo.set変更者タイトル(変更者);
        shinsaHanteiJokyo.set変更者二次判定非該当(new RString(
                toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定非該当())));
        shinsaHanteiJokyo.set変更者二次判定要支援1(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定非該当())));
        shinsaHanteiJokyo.set変更者二次判定要支援2(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定非該当())));
        shinsaHanteiJokyo.set変更者二次判定要介護1(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定非該当())));
        shinsaHanteiJokyo.set変更者二次判定要介護2(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定非該当())));
        shinsaHanteiJokyo.set変更者二次判定要介護3(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定非該当())));
        shinsaHanteiJokyo.set変更者二次判定要介護4(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護5二次判定非該当())));
        shinsaHanteiJokyo.set変更者二次判定要介護5(new RString(
                toInt(shinsaHanteiJokyo.get一次判定非該当二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要支援2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護1二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護2二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護3二次判定非該当())
                + toInt(shinsaHanteiJokyo.get一次判定要介護4二次判定非該当())));
        shinsaHanteiJokyo.set変更者計(new RString(
                toInt(shinsaHanteiJokyo.get変更者二次判定非該当())
                + toInt(shinsaHanteiJokyo.get変更者二次判定要支援1())
                + toInt(shinsaHanteiJokyo.get変更者二次判定要支援2())
                + toInt(shinsaHanteiJokyo.get変更者二次判定要介護1())
                + toInt(shinsaHanteiJokyo.get変更者二次判定要介護2())
                + toInt(shinsaHanteiJokyo.get変更者二次判定要介護3())
                + toInt(shinsaHanteiJokyo.get変更者二次判定要介護4())
                + toInt(shinsaHanteiJokyo.get変更者二次判定要介護5())));
    }

    private void set割合() {
        shinsaHanteiJokyo.set割合タイトル(new RString("割合"));
        int 合計計 = Integer.parseInt(shinsaHanteiJokyo.get計計().toString());
        if (合計計 == 0) {
            shinsaHanteiJokyo.set割合二次判定非該当(割合なし);
            shinsaHanteiJokyo.set割合二次判定要支援1(割合なし);
            shinsaHanteiJokyo.set割合二次判定要支援2(割合なし);
            shinsaHanteiJokyo.set割合二次判定要介護1(割合なし);
            shinsaHanteiJokyo.set割合二次判定要介護2(割合なし);
            shinsaHanteiJokyo.set割合二次判定要介護3(割合なし);
            shinsaHanteiJokyo.set割合二次判定要介護4(割合なし);
            shinsaHanteiJokyo.set割合二次判定要介護5(割合なし);
        } else {
            shinsaHanteiJokyo.set割合二次判定非該当(get割合結果(Integer.parseInt(shinsaHanteiJokyo.get計二次判定非該当().toString()), 合計計));
            shinsaHanteiJokyo.set割合二次判定要支援1(get割合結果(Integer.parseInt(shinsaHanteiJokyo.get計二次判定要支援1().toString()), 合計計));
            shinsaHanteiJokyo.set割合二次判定要支援2(get割合結果(Integer.parseInt(shinsaHanteiJokyo.get計二次判定要支援2().toString()), 合計計));
            shinsaHanteiJokyo.set割合二次判定要介護1(get割合結果(Integer.parseInt(shinsaHanteiJokyo.get計二次判定要介護1().toString()), 合計計));
            shinsaHanteiJokyo.set割合二次判定要介護2(get割合結果(Integer.parseInt(shinsaHanteiJokyo.get計二次判定要介護2().toString()), 合計計));
            shinsaHanteiJokyo.set割合二次判定要介護3(get割合結果(Integer.parseInt(shinsaHanteiJokyo.get計二次判定要介護3().toString()), 合計計));
            shinsaHanteiJokyo.set割合二次判定要介護4(get割合結果(Integer.parseInt(shinsaHanteiJokyo.get計二次判定要介護4().toString()), 合計計));
            shinsaHanteiJokyo.set割合二次判定要介護5(get割合結果(Integer.parseInt(shinsaHanteiJokyo.get計二次判定要介護5().toString()), 合計計));
        }
        shinsaHanteiJokyo.set割合計(new RString("100.0%"));
    }

    private void setヘッダ情報(SinsakaiHanteiJyokyoHeaderEntity current) {
        shinsaHanteiJokyo.setタイトル(帳票タイトル);
        set合議体名();
        shinsaHanteiJokyo.set開催開始年月日(get対象開始年月日());
        shinsaHanteiJokyo.set開催終了年月日(get対象終了年月日());
        shinsaHanteiJokyo.set開催回数(new RString(current.getShinsakaiKaisaiNoCount()));
        if (RString.isNullOrEmpty(parameter.getShichosonCode().value())) {
            shinsaHanteiJokyo.set保険者番号(to五桁(全市町村コード));
            shinsaHanteiJokyo.set保険者名(全市町村);
        } else {
            shinsaHanteiJokyo.set保険者番号(to五桁(parameter.getHokensyaNo()));
            shinsaHanteiJokyo.set保険者名(parameter.getShichosonName());
        }
    }

    private void set判定件数() {
        shinsaHanteiJokyo.set変更者(shinsaHanteiJokyo.get計判定変更者数());
        shinsaHanteiJokyo.set軽度(shinsaHanteiJokyo.get計軽度変更者数());
        shinsaHanteiJokyo.set重度(shinsaHanteiJokyo.get計重度変更者数());
    }

    private RString get割合結果(int 二次判定状態計, int 合計) {
        if (二次判定状態計 == 0) {
            return 割合なし;
        }
        return new RString(FORMAT.format(
                new Decimal(二次判定状態計).divide(合計).multiply(割合).roundHalfUpTo(1)) + パーセント);
    }

    private int get被保険者数(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            RString 要介護認定一次判定結果コード認知症加算,
            RString 二次判定要介護状態区分コード) {
        for (SinsakaiHanteiJyokyoEntity sinsakaiHanteiJyokyoEntity : 審査判定状況) {
            if (sinsakaiHanteiJyokyoEntity.getIchijiHanteiKekkaNinchishoKasanCode().value().equals(要介護認定一次判定結果コード認知症加算)
                    && sinsakaiHanteiJyokyoEntity.getNijiHanteiYokaigoJotaiKubunCode().value().equals(二次判定要介護状態区分コード)) {
                return sinsakaiHanteiJyokyoEntity.getHihokenshaCount();
            }
        }
        return 0;
    }

    private void set合議体名() {
        if (parameter.isEmptyGogitaiNo()) {
            shinsaHanteiJokyo.set合議体名称(全合議体);
        } else {
            shinsaHanteiJokyo.set合議体名称(parameter.getGogitaiName());
        }
    }

    private RString get対象開始年月日() {
        RString 対象開始日 = RString.EMPTY;
        if (parameter.isTaishoTsukiKubun()) {
            FlexibleYearMonth 対象年月 = new FlexibleYearMonth(parameter.getTaishoNendoYM());
            対象開始日 = new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 1).toDateString();
        } else if (parameter.isTaishoGeppiKubun() && !parameter.isEmptyTaishoGeppiFrom()) {
            対象開始日 = parameter.getTaishoGeppiFrom();
        }
        return 対象開始日;
    }

    private RString get対象終了年月日() {
        RString 対象終了日 = RString.EMPTY;
        if (parameter.isTaishoTsukiKubun()) {
            FlexibleYearMonth 対象年月 = new FlexibleYearMonth(parameter.getTaishoNendoYM());
            対象終了日 = new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 対象年月.getLastDay()).toDateString();
        } else if (parameter.isTaishoGeppiKubun() && !parameter.isEmptyTaishoGeppiTo()) {
            対象終了日 = parameter.getTaishoGeppiTo();
        }
        return 対象終了日;
    }

    private static RString to五桁(RString rstr) {
        return rstr.substringReturnAsPossible(0, 桁数_市町村コード_CD除く);
    }

    private RString toRString(int 被保険者数) {
        return 被保険者数 == 0 ? RString.EMPTY : new RString(被保険者数);
    }

    private int toInt(RString 被保険者数) {
        return RString.isNullOrEmpty(被保険者数) ? 0 : Integer.parseInt(被保険者数.toString());
    }
}
