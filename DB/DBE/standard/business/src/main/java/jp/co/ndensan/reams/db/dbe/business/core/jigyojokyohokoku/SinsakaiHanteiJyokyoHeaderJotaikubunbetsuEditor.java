/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jotaikubumbetsuhantei.Jotaikubumbetsuhantei;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.SinsakaiHanteiJyokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class SinsakaiHanteiJyokyoHeaderJotaikubunbetsuEditor {

    private static final RString 帳票タイトル = new RString("要介護状態区分別判定件数");
    private static final RString 非該当 = new RString("01");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private static final RString 再調査 = new RString("31");
    private static final RString 非該当タイトル = new RString("非該当");
    private static final RString 要支援1タイトル = new RString("要支援1");
    private static final RString 要支援2タイトル = new RString("要支援2");
    private static final RString 要介護1タイトル = new RString("要介護1");
    private static final RString 要介護2タイトル = new RString("要介護2");
    private static final RString 要介護3タイトル = new RString("要介護3");
    private static final RString 要介護4タイトル = new RString("要介護4");
    private static final RString 要介護5タイトル = new RString("要介護5");
    private static final RString 計タイトル = new RString("計");
    private static final RString 変更者タイトル = new RString("変更者");
    private static final RString 割合タイトル = new RString("割合");
    private static final RString 割合計 = new RString("100%");
    private static final RString パーセント = new RString("%");
    private static final RString なし = new RString(0);
    private static final RString 全合議体 = new RString("全合議体");
    private static final RString 全市町村コード = RString.EMPTY;
    private static final RString 全市町村 = new RString("全市町村");
    private static final int 割合 = 100;
    private final SinsakaiHanteiJyokyoProcessParameter parameter;
    private final SinsakaiHanteiJyokyoHeaderEntity entity;
    private final Jotaikubumbetsuhantei jotaikubumbetsuhantei;

    /**
     * コンストラクタです。
     *
     * @param parameter SinsakaiHanteiJyokyoProcessParameter
     * @param entity SinsakaiHanteiJyokyoHeaderEntity
     * @param jotaikubumbetsuhantei Jotaikubumbetsuhantei
     */
    public SinsakaiHanteiJyokyoHeaderJotaikubunbetsuEditor(
            SinsakaiHanteiJyokyoProcessParameter parameter,
            SinsakaiHanteiJyokyoHeaderEntity entity,
            Jotaikubumbetsuhantei jotaikubumbetsuhantei) {
        this.parameter = parameter;
        this.entity = entity;
        this.jotaikubumbetsuhantei = jotaikubumbetsuhantei;
    }

    /**
     * 介護認定審査会判定状況を設定します。
     *
     * @param 審査判定状況 List<SinsakaiHanteiJyokyoEntity>
     */
    public void set介護認定審査会判定状況(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        setHeader(entity);
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
        jotaikubumbetsuhantei.set変更者(jotaikubumbetsuhantei.get計_判定変更者数());
        jotaikubumbetsuhantei.set軽度(jotaikubumbetsuhantei.get計_軽度変更者数());
        jotaikubumbetsuhantei.set重度(jotaikubumbetsuhantei.get計_重度変更者数());
    }

    private void set一次判定非該当(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 非該当非該当被保険者数 = get被保険者数(審査判定状況, 非該当, 非該当);
        int 非該当要支援1被保険者数 = get被保険者数(審査判定状況, 非該当, 要支援1);
        int 非該当要支援2被保険者数 = get被保険者数(審査判定状況, 非該当, 要支援2);
        int 非該当要介護1被保険者数 = get被保険者数(審査判定状況, 非該当, 要介護1);
        int 非該当要介護2被保険者数 = get被保険者数(審査判定状況, 非該当, 要介護2);
        int 非該当要介護3被保険者数 = get被保険者数(審査判定状況, 非該当, 要介護3);
        int 非該当要介護4被保険者数 = get被保険者数(審査判定状況, 非該当, 要介護4);
        int 非該当要介護5被保険者数 = get被保険者数(審査判定状況, 非該当, 要介護5);
        int 非該当計 = 非該当非該当被保険者数 + 非該当要支援1被保険者数 + 非該当要支援2被保険者数 + 非該当要介護1被保険者数
                + 非該当要介護2被保険者数 + 非該当要介護3被保険者数 + 非該当要介護4被保険者数 + 非該当要介護5被保険者数;
        int 非該当再調査二次被保険者数 = get被保険者数(審査判定状況, 非該当, 再調査);
        jotaikubumbetsuhantei.set一次判定非該当タイトル(非該当タイトル);
        jotaikubumbetsuhantei.set一次判定非該当_二次判定非該当(new RString(非該当非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_二次判定要支援1(new RString(非該当要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_二次判定要支援2(new RString(非該当要支援2被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_二次判定要介護1(new RString(非該当要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_二次判定要介護2(new RString(非該当要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_二次判定要介護3(new RString(非該当要介護3被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_二次判定要介護4(new RString(非該当要介護4被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_二次判定要介護5(new RString(非該当要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_計(new RString(非該当計));
        jotaikubumbetsuhantei.set一次判定非該当_再調査二次保留分(new RString(非該当再調査二次被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_判定変更者数(new RString(非該当計 - 非該当非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_軽度変更者数(なし);
        jotaikubumbetsuhantei.set一次判定非該当_重度変更者数(new RString(非該当計 - 非該当非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定非該当_判定変更割合(非該当計 == 非該当非該当被保険者数
                ? なし : new RString(String.valueOf((非該当計 - 非該当非該当被保険者数) / 非該当計 * 割合)));
    }

    private void set一次判定要支援1(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要支援1非該当被保険者数 = get被保険者数(審査判定状況, 要支援1, 非該当);
        int 要支援1要支援1被保険者数 = get被保険者数(審査判定状況, 要支援1, 要支援1);
        int 要支援1要支援2被保険者数 = get被保険者数(審査判定状況, 要支援1, 要支援2);
        int 要支援1要介護1被保険者数 = get被保険者数(審査判定状況, 要支援1, 要介護1);
        int 要支援1要介護2被保険者数 = get被保険者数(審査判定状況, 要支援1, 要介護2);
        int 要支援1要介護3被保険者数 = get被保険者数(審査判定状況, 要支援1, 要介護3);
        int 要支援1要介護4被保険者数 = get被保険者数(審査判定状況, 要支援1, 要介護4);
        int 要支援1要介護5被保険者数 = get被保険者数(審査判定状況, 要支援1, 要介護5);
        int 要支援1計 = 要支援1非該当被保険者数 + 要支援1要支援1被保険者数 + 要支援1要支援2被保険者数 + 要支援1要介護1被保険者数
                + 要支援1要介護2被保険者数 + 要支援1要介護3被保険者数 + 要支援1要介護4被保険者数 + 要支援1要介護5被保険者数;
        int 要支援1再調査二次被保険者数 = get被保険者数(審査判定状況, 要支援1, 再調査);
        jotaikubumbetsuhantei.set一次判定要支援1タイトル(要支援1タイトル);
        jotaikubumbetsuhantei.set一次判定要支援1_二次判定非該当(new RString(要支援1非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_二次判定要支援1(new RString(要支援1要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_二次判定要支援2(new RString(要支援1要支援2被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_二次判定要介護1(new RString(要支援1要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_二次判定要介護2(new RString(要支援1要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_二次判定要介護3(new RString(要支援1要介護3被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_二次判定要介護4(new RString(要支援1要介護4被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_二次判定要介護5(new RString(要支援1要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_計(new RString(要支援1計));
        jotaikubumbetsuhantei.set一次判定要支援1_再調査二次保留分(new RString(要支援1再調査二次被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_判定変更者数(new RString(要支援1計 - 要支援1要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_軽度変更者数(new RString(要支援1非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_重度変更者数(new RString(要支援1計 - 要支援1非該当被保険者数 - 要支援1要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援1_判定変更割合(要支援1計 == 要支援1要支援1被保険者数
                ? なし : new RString(String.valueOf((要支援1計 - 要支援1要支援1被保険者数) / 要支援1計 * 割合)));
    }

    private void set一次判定要支援2(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要支援2非該当被保険者数 = get被保険者数(審査判定状況, 要支援2, 非該当);
        int 要支援2要支援1被保険者数 = get被保険者数(審査判定状況, 要支援2, 要支援1);
        int 要支援2要支援2被保険者数 = get被保険者数(審査判定状況, 要支援2, 要支援2);
        int 要支援2要介護1被保険者数 = get被保険者数(審査判定状況, 要支援2, 要介護1);
        int 要支援2要介護2被保険者数 = get被保険者数(審査判定状況, 要支援2, 要介護2);
        int 要支援2要介護3被保険者数 = get被保険者数(審査判定状況, 要支援2, 要介護3);
        int 要支援2要介護4被保険者数 = get被保険者数(審査判定状況, 要支援2, 要介護4);
        int 要支援2要介護5被保険者数 = get被保険者数(審査判定状況, 要支援2, 要介護5);
        int 要支援2計 = 要支援2非該当被保険者数 + 要支援2要支援1被保険者数 + 要支援2要支援2被保険者数 + 要支援2要介護1被保険者数
                + 要支援2要介護2被保険者数 + 要支援2要介護3被保険者数 + 要支援2要介護4被保険者数 + 要支援2要介護5被保険者数;
        int 要支援2再調査二次被保険者数 = get被保険者数(審査判定状況, 要支援2, 再調査);
        jotaikubumbetsuhantei.set一次判定要支援2タイトル(要支援2タイトル);
        jotaikubumbetsuhantei.set一次判定要支援2_二次判定非該当(new RString(要支援2非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_二次判定要支援1(new RString(要支援2要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_二次判定要支援2(new RString(要支援2要支援2被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_二次判定要介護1(new RString(要支援2要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_二次判定要介護2(new RString(要支援2要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_二次判定要介護3(new RString(要支援2要介護3被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_二次判定要介護4(new RString(要支援2要介護4被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_二次判定要介護5(new RString(要支援2要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_計(new RString(要支援2計));
        jotaikubumbetsuhantei.set一次判定要支援2_再調査二次保留分(new RString(要支援2再調査二次被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_判定変更者数(new RString(要支援2計 - 要支援2要支援2被保険者数 - 要支援2要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_軽度変更者数(new RString(要支援2非該当被保険者数 + 要支援2要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_重度変更者数(new RString(要支援2要介護2被保険者数
                + 要支援2要介護3被保険者数 + 要支援2要介護4被保険者数 + 要支援2要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要支援2_判定変更割合(要支援2計 - 要支援2要支援2被保険者数 - 要支援2要介護1被保険者数 == 0
                ? なし : new RString(String.valueOf((要支援2計 - 要支援2要支援2被保険者数 - 要支援2要介護1被保険者数) / 要支援2計 * 割合)));
    }

    private void set一次判定要介護1(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護1非該当被保険者数 = get被保険者数(審査判定状況, 要介護1, 非該当);
        int 要介護1要支援1被保険者数 = get被保険者数(審査判定状況, 要介護1, 要支援1);
        int 要介護1要支援2被保険者数 = get被保険者数(審査判定状況, 要介護1, 要支援2);
        int 要介護1要介護1被保険者数 = get被保険者数(審査判定状況, 要介護1, 要介護1);
        int 要介護1要介護2被保険者数 = get被保険者数(審査判定状況, 要介護1, 要介護2);
        int 要介護1要介護3被保険者数 = get被保険者数(審査判定状況, 要介護1, 要介護3);
        int 要介護1要介護4被保険者数 = get被保険者数(審査判定状況, 要介護1, 要介護4);
        int 要介護1要介護5被保険者数 = get被保険者数(審査判定状況, 要介護1, 要介護5);
        int 要介護1計 = 要介護1非該当被保険者数 + 要介護1要支援1被保険者数 + 要介護1要支援2被保険者数 + 要介護1要介護1被保険者数
                + 要介護1要介護2被保険者数 + 要介護1要介護3被保険者数 + 要介護1要介護4被保険者数 + 要介護1要介護5被保険者数;
        int 要介護1再調査二次被保険者数 = get被保険者数(審査判定状況, 要介護1, 再調査);
        jotaikubumbetsuhantei.set一次判定要介護1タイトル(要介護1タイトル);
        jotaikubumbetsuhantei.set一次判定要介護1_二次判定非該当(new RString(要介護1非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_二次判定要支援1(new RString(要介護1要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_二次判定要支援2(new RString(要介護1要支援2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_二次判定要介護1(new RString(要介護1要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_二次判定要介護2(new RString(要介護1要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_二次判定要介護3(new RString(要介護1要介護3被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_二次判定要介護4(new RString(要介護1要介護4被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_二次判定要介護5(new RString(要介護1要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_計(new RString(要介護1計));
        jotaikubumbetsuhantei.set一次判定要介護1_再調査二次保留分(new RString(要介護1再調査二次被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_判定変更者数(new RString(要介護1計 - 要介護1要支援2被保険者数 - 要介護1要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_軽度変更者数(new RString(要介護1非該当被保険者数 + 要介護1要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_重度変更者数(new RString(要介護1要介護2被保険者数
                + 要介護1要介護3被保険者数 + 要介護1要介護4被保険者数 + 要介護1要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護1_判定変更割合(要介護1計 - 要介護1要支援2被保険者数 - 要介護1要介護1被保険者数 == 0
                ? なし : new RString(String.valueOf((要介護1計 - 要介護1要支援2被保険者数 - 要介護1要介護1被保険者数) / 要介護1計 * 割合)));
    }

    private void set一次判定要介護2(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護2非該当被保険者数 = get被保険者数(審査判定状況, 要介護2, 非該当);
        int 要介護2要支援1被保険者数 = get被保険者数(審査判定状況, 要介護2, 要支援1);
        int 要介護2要支援2被保険者数 = get被保険者数(審査判定状況, 要介護2, 要支援2);
        int 要介護2要介護1被保険者数 = get被保険者数(審査判定状況, 要介護2, 要介護1);
        int 要介護2要介護2被保険者数 = get被保険者数(審査判定状況, 要介護2, 要介護2);
        int 要介護2要介護3被保険者数 = get被保険者数(審査判定状況, 要介護2, 要介護3);
        int 要介護2要介護4被保険者数 = get被保険者数(審査判定状況, 要介護2, 要介護4);
        int 要介護2要介護5被保険者数 = get被保険者数(審査判定状況, 要介護2, 要介護5);
        int 要介護2計 = 要介護2非該当被保険者数 + 要介護2要支援1被保険者数 + 要介護2要支援2被保険者数 + 要介護2要介護1被保険者数
                + 要介護2要介護2被保険者数 + 要介護2要介護3被保険者数 + 要介護2要介護4被保険者数 + 要介護2要介護5被保険者数;
        int 要介護2再調査二次被保険者数 = get被保険者数(審査判定状況, 要介護2, 再調査);
        jotaikubumbetsuhantei.set一次判定要介護2タイトル(要介護2タイトル);
        jotaikubumbetsuhantei.set一次判定要介護2_二次判定非該当(new RString(要介護2非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_二次判定要支援1(new RString(要介護2要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_二次判定要支援2(new RString(要介護2要支援2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_二次判定要介護1(new RString(要介護2要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_二次判定要介護2(new RString(要介護2要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_二次判定要介護3(new RString(要介護2要介護3被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_二次判定要介護4(new RString(要介護2要介護4被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_二次判定要介護5(new RString(要介護2要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_計(new RString(要介護2計));
        jotaikubumbetsuhantei.set一次判定要介護2_再調査二次保留分(new RString(要介護2再調査二次被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_判定変更者数(new RString(要介護2計 - 要介護2要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_軽度変更者数(new RString(要介護2非該当被保険者数
                + 要介護2要支援1被保険者数 + 要介護2要支援2被保険者数 + 要介護2要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_重度変更者数(new RString(要介護2要介護3被保険者数
                + 要介護2要介護4被保険者数 + 要介護2要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護2_判定変更割合(要介護2計 == 要介護2要介護2被保険者数
                ? なし : new RString(String.valueOf((要介護2計 - 要介護2要介護2被保険者数) / 要介護2計 * 割合)));
    }

    private void set一次判定要介護3(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護3非該当被保険者数 = get被保険者数(審査判定状況, 要介護3, 非該当);
        int 要介護3要支援1被保険者数 = get被保険者数(審査判定状況, 要介護3, 要支援1);
        int 要介護3要支援2被保険者数 = get被保険者数(審査判定状況, 要介護3, 要支援2);
        int 要介護3要介護1被保険者数 = get被保険者数(審査判定状況, 要介護3, 要介護1);
        int 要介護3要介護2被保険者数 = get被保険者数(審査判定状況, 要介護3, 要介護2);
        int 要介護3要介護3被保険者数 = get被保険者数(審査判定状況, 要介護3, 要介護3);
        int 要介護3要介護4被保険者数 = get被保険者数(審査判定状況, 要介護3, 要介護4);
        int 要介護3要介護5被保険者数 = get被保険者数(審査判定状況, 要介護3, 要介護5);
        int 要介護3計 = 要介護3非該当被保険者数 + 要介護3要支援1被保険者数 + 要介護3要支援2被保険者数 + 要介護3要介護1被保険者数
                + 要介護3要介護2被保険者数 + 要介護3要介護3被保険者数 + 要介護3要介護4被保険者数 + 要介護3要介護5被保険者数;
        int 要介護3再調査二次被保険者数 = get被保険者数(審査判定状況, 要介護3, 再調査);
        jotaikubumbetsuhantei.set一次判定要介護3タイトル(要介護3タイトル);
        jotaikubumbetsuhantei.set一次判定要介護3_二次判定非該当(new RString(要介護3非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_二次判定要支援1(new RString(要介護3要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_二次判定要支援2(new RString(要介護3要支援2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_二次判定要介護1(new RString(要介護3要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_二次判定要介護2(new RString(要介護3要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_二次判定要介護3(new RString(要介護3要介護3被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_二次判定要介護4(new RString(要介護3要介護4被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_二次判定要介護5(new RString(要介護3要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_計(new RString(要介護3計));
        jotaikubumbetsuhantei.set一次判定要介護3_再調査二次保留分(new RString(要介護3再調査二次被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_判定変更者数(new RString(要介護3計 - 要介護3要介護3被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_軽度変更者数(new RString(要介護3非該当被保険者数
                + 要介護3要支援1被保険者数 + 要介護3要支援2被保険者数 + 要介護3要介護1被保険者数 + 要介護3要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_重度変更者数(new RString(要介護3要介護4被保険者数 + 要介護3要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護3_判定変更割合(要介護3計 == 要介護3要介護3被保険者数
                ? なし : new RString(String.valueOf((要介護3計 - 要介護3要介護3被保険者数) / 要介護3計 * 割合)));
    }

    private void set一次判定要介護4(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護4非該当被保険者数 = get被保険者数(審査判定状況, 要介護4, 非該当);
        int 要介護4要支援1被保険者数 = get被保険者数(審査判定状況, 要介護4, 要支援1);
        int 要介護4要支援2被保険者数 = get被保険者数(審査判定状況, 要介護4, 要支援2);
        int 要介護4要介護1被保険者数 = get被保険者数(審査判定状況, 要介護4, 要介護1);
        int 要介護4要介護2被保険者数 = get被保険者数(審査判定状況, 要介護4, 要介護2);
        int 要介護4要介護3被保険者数 = get被保険者数(審査判定状況, 要介護4, 要介護3);
        int 要介護4要介護4被保険者数 = get被保険者数(審査判定状況, 要介護4, 要介護4);
        int 要介護4要介護5被保険者数 = get被保険者数(審査判定状況, 要介護4, 要介護5);
        int 要介護4計 = 要介護4非該当被保険者数 + 要介護4要支援1被保険者数 + 要介護4要支援2被保険者数 + 要介護4要介護1被保険者数
                + 要介護4要介護2被保険者数 + 要介護4要介護3被保険者数 + 要介護4要介護4被保険者数 + 要介護4要介護5被保険者数;
        int 要介護4再調査二次被保険者数 = get被保険者数(審査判定状況, 要介護4, 再調査);
        jotaikubumbetsuhantei.set一次判定要介護4タイトル(要介護4タイトル);
        jotaikubumbetsuhantei.set一次判定要介護4_二次判定非該当(new RString(要介護4非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_二次判定要支援1(new RString(要介護4要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_二次判定要支援2(new RString(要介護4要支援2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_二次判定要介護1(new RString(要介護4要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_二次判定要介護2(new RString(要介護4要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_二次判定要介護3(new RString(要介護4要介護3被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_二次判定要介護4(new RString(要介護4要介護4被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_二次判定要介護5(new RString(要介護4要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_計(new RString(要介護4計));
        jotaikubumbetsuhantei.set一次判定要介護4_再調査二次保留分(new RString(要介護4再調査二次被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_判定変更者数(new RString(要介護4計 - 要介護4要介護4被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_軽度変更者数(new RString(要介護4計 - 要介護4要介護4被保険者数 - 要介護4要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_重度変更者数(new RString(要介護4要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護4_判定変更割合(要介護4計 == 要介護4要介護4被保険者数
                ? なし : new RString(String.valueOf((要介護4計 - 要介護4要介護4被保険者数) / 要介護4計 * 割合)));
    }

    private void set一次判定要介護5(List<SinsakaiHanteiJyokyoEntity> 審査判定状況) {
        int 要介護5非該当被保険者数 = get被保険者数(審査判定状況, 要介護5, 非該当);
        int 要介護5要支援1被保険者数 = get被保険者数(審査判定状況, 要介護5, 要支援1);
        int 要介護5要支援2被保険者数 = get被保険者数(審査判定状況, 要介護5, 要支援2);
        int 要介護5要介護1被保険者数 = get被保険者数(審査判定状況, 要介護5, 要介護1);
        int 要介護5要介護2被保険者数 = get被保険者数(審査判定状況, 要介護5, 要介護2);
        int 要介護5要介護3被保険者数 = get被保険者数(審査判定状況, 要介護5, 要介護3);
        int 要介護5要介護4被保険者数 = get被保険者数(審査判定状況, 要介護5, 要介護4);
        int 要介護5要介護5被保険者数 = get被保険者数(審査判定状況, 要介護5, 要介護5);
        int 要介護5計 = 要介護5非該当被保険者数 + 要介護5要支援1被保険者数 + 要介護5要支援2被保険者数 + 要介護5要介護1被保険者数
                + 要介護5要介護2被保険者数 + 要介護5要介護3被保険者数 + 要介護5要介護4被保険者数 + 要介護5要介護5被保険者数;
        int 要介護5再調査二次被保険者数 = get被保険者数(審査判定状況, 要介護5, 再調査);
        jotaikubumbetsuhantei.set一次判定要介護5タイトル(要介護5タイトル);
        jotaikubumbetsuhantei.set一次判定要介護5_二次判定非該当(new RString(要介護5非該当被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_二次判定要支援1(new RString(要介護5要支援1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_二次判定要支援2(new RString(要介護5要支援2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_二次判定要介護1(new RString(要介護5要介護1被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_二次判定要介護2(new RString(要介護5要介護2被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_二次判定要介護3(new RString(要介護5要介護3被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_二次判定要介護4(new RString(要介護5要介護4被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_二次判定要介護5(new RString(要介護5要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_計(new RString(要介護5計));
        jotaikubumbetsuhantei.set一次判定要介護5_再調査二次保留分(new RString(要介護5再調査二次被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_判定変更者数(new RString(要介護5計 - 要介護5要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_軽度変更者数(new RString(要介護5計 - 要介護5要介護5被保険者数));
        jotaikubumbetsuhantei.set一次判定要介護5_重度変更者数(なし);
        jotaikubumbetsuhantei.set一次判定要介護5_判定変更割合(要介護5計 == 要介護5要介護5被保険者数
                ? なし : new RString(String.valueOf((要介護5計 - 要介護5要介護5被保険者数) / 要介護5計 * 割合)));
    }

    private void set計() {
        jotaikubumbetsuhantei.set計タイトル(計タイトル);
        jotaikubumbetsuhantei.set計_二次判定非該当(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定非該当())));
        jotaikubumbetsuhantei.set計_二次判定要支援1(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要支援1())));
        jotaikubumbetsuhantei.set計_二次判定要支援2(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要支援2())));
        jotaikubumbetsuhantei.set計_二次判定要介護1(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要介護1())));
        jotaikubumbetsuhantei.set計_二次判定要介護2(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要介護2())));
        jotaikubumbetsuhantei.set計_二次判定要介護3(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要介護3())));
        jotaikubumbetsuhantei.set計_二次判定要介護4(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要介護4())));
        jotaikubumbetsuhantei.set計_二次判定要介護5(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要介護5())));
        jotaikubumbetsuhantei.set計_計(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_計())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_計())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_計())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_計())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_計())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_計())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_計())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_計())));
        jotaikubumbetsuhantei.set計_再調査二次保留分(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_再調査二次保留分())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_再調査二次保留分())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_再調査二次保留分())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_再調査二次保留分())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_再調査二次保留分())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_再調査二次保留分())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_再調査二次保留分())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_再調査二次保留分())));
        jotaikubumbetsuhantei.set計_判定変更者数(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_判定変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_判定変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_判定変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_判定変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_判定変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_判定変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_判定変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_判定変更者数())));
        jotaikubumbetsuhantei.set計_軽度変更者数(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_軽度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_軽度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_軽度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_軽度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_軽度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_軽度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_軽度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_軽度変更者数())));
        jotaikubumbetsuhantei.set計_重度変更者数(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_重度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_重度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_重度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_重度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_重度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_重度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_重度変更者数())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_重度変更者数())));
        jotaikubumbetsuhantei.set計_判定変更割合(なし.equals(jotaikubumbetsuhantei.get計_計()) ? なし : new RString(String.valueOf(
                getIntValue(jotaikubumbetsuhantei.get計_判定変更者数())
                / getIntValue(jotaikubumbetsuhantei.get計_計()) * 割合)));
    }

    private void set変更者() {
        jotaikubumbetsuhantei.set変更者タイトル(変更者タイトル);
        jotaikubumbetsuhantei.set変更者_二次判定非該当(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定非該当())));
        jotaikubumbetsuhantei.set変更者_二次判定要支援1(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要支援1())));
        jotaikubumbetsuhantei.set変更者_二次判定要支援2(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要支援2())));
        jotaikubumbetsuhantei.set変更者_二次判定要介護1(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要介護1())));
        jotaikubumbetsuhantei.set変更者_二次判定要介護2(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要介護2())));
        jotaikubumbetsuhantei.set変更者_二次判定要介護3(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要介護3())));
        jotaikubumbetsuhantei.set変更者_二次判定要介護4(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護5_二次判定要介護4())));
        jotaikubumbetsuhantei.set変更者_二次判定要介護5(new RString(getIntValue(jotaikubumbetsuhantei.get一次判定非該当_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援1_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要支援2_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護1_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護2_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護3_二次判定要介護5())
                + getIntValue(jotaikubumbetsuhantei.get一次判定要介護4_二次判定要介護5())));
        jotaikubumbetsuhantei.set変更者_計(new RString(getIntValue(jotaikubumbetsuhantei.get変更者_二次判定非該当())
                + getIntValue(jotaikubumbetsuhantei.get変更者_二次判定要支援1())
                + getIntValue(jotaikubumbetsuhantei.get変更者_二次判定要支援2())
                + getIntValue(jotaikubumbetsuhantei.get変更者_二次判定要介護1())
                + getIntValue(jotaikubumbetsuhantei.get変更者_二次判定要介護2())
                + getIntValue(jotaikubumbetsuhantei.get変更者_二次判定要介護3())
                + getIntValue(jotaikubumbetsuhantei.get変更者_二次判定要介護4())
                + getIntValue(jotaikubumbetsuhantei.get変更者_二次判定要介護5())));
        jotaikubumbetsuhantei.set変更者_再調査二次保留分(RString.EMPTY);
        jotaikubumbetsuhantei.set変更者_判定変更者数(RString.EMPTY);
        jotaikubumbetsuhantei.set変更者_軽度変更者数(RString.EMPTY);
        jotaikubumbetsuhantei.set変更者_重度変更者数(RString.EMPTY);
        jotaikubumbetsuhantei.set変更者_判定変更割合(RString.EMPTY);
    }

    private void set割合() {
        jotaikubumbetsuhantei.set割合タイトル(割合タイトル);
        int 計_計 = getIntValue(jotaikubumbetsuhantei.get計_計());
        if (0 != 計_計) {
            jotaikubumbetsuhantei.set割合_二次判定非該当(new RString(String.valueOf(
                    getIntValue(jotaikubumbetsuhantei.get計_二次判定非該当()) / 計_計 * 割合) + パーセント));
            jotaikubumbetsuhantei.set割合_二次判定要支援1(new RString(String.valueOf(
                    getIntValue(jotaikubumbetsuhantei.get計_二次判定要支援1()) / 計_計 * 割合) + パーセント));
            jotaikubumbetsuhantei.set割合_二次判定要支援2(new RString(String.valueOf(
                    getIntValue(jotaikubumbetsuhantei.get計_二次判定要支援2()) / 計_計 * 割合) + パーセント));
            jotaikubumbetsuhantei.set割合_二次判定要介護1(new RString(String.valueOf(
                    getIntValue(jotaikubumbetsuhantei.get計_二次判定要介護1()) / 計_計 * 割合) + パーセント));
            jotaikubumbetsuhantei.set割合_二次判定要介護2(new RString(String.valueOf(
                    getIntValue(jotaikubumbetsuhantei.get計_二次判定要介護2()) / 計_計 * 割合) + パーセント));
            jotaikubumbetsuhantei.set割合_二次判定要介護3(new RString(String.valueOf(
                    getIntValue(jotaikubumbetsuhantei.get計_二次判定要介護3()) / 計_計 * 割合) + パーセント));
            jotaikubumbetsuhantei.set割合_二次判定要介護4(new RString(String.valueOf(
                    getIntValue(jotaikubumbetsuhantei.get計_二次判定要介護4()) / 計_計 * 割合) + パーセント));
            jotaikubumbetsuhantei.set割合_二次判定要介護5(new RString(String.valueOf(
                    getIntValue(jotaikubumbetsuhantei.get計_二次判定要介護5()) / 計_計 * 割合) + パーセント));
        } else {
            jotaikubumbetsuhantei.set割合_二次判定非該当(なし);
            jotaikubumbetsuhantei.set割合_二次判定要支援1(なし);
            jotaikubumbetsuhantei.set割合_二次判定要支援2(なし);
            jotaikubumbetsuhantei.set割合_二次判定要介護1(なし);
            jotaikubumbetsuhantei.set割合_二次判定要介護2(なし);
            jotaikubumbetsuhantei.set割合_二次判定要介護3(なし);
            jotaikubumbetsuhantei.set割合_二次判定要介護4(なし);
            jotaikubumbetsuhantei.set割合_二次判定要介護5(なし);
        }
        jotaikubumbetsuhantei.set割合_計(割合計);
        jotaikubumbetsuhantei.set割合_再調査二次保留分(RString.EMPTY);
        jotaikubumbetsuhantei.set割合_判定変更者数(RString.EMPTY);
        jotaikubumbetsuhantei.set割合_軽度変更者数(RString.EMPTY);
        jotaikubumbetsuhantei.set割合_重度変更者数(RString.EMPTY);
        jotaikubumbetsuhantei.set割合_判定変更割合(RString.EMPTY);
    }

    private void setHeader(SinsakaiHanteiJyokyoHeaderEntity current) {
        jotaikubumbetsuhantei.setタイトル(帳票タイトル);
        if (parameter.isEmptyGogitaiNo()) {
            jotaikubumbetsuhantei.set合議体名称(全合議体);
        } else {
            jotaikubumbetsuhantei.set合議体名称(parameter.getGogitaiName());
        }
        jotaikubumbetsuhantei.set開催開始年月日(current.getShinsakaiKaisaiYMDMin());
        jotaikubumbetsuhantei.set開催終了年月日(current.getShinsakaiKaisaiYMDMax());
        jotaikubumbetsuhantei.set開催回数(new RString(current.getShinsakaiKaisaiNoCount()));
        if (RString.isNullOrEmpty(parameter.getShichosonCode().value())) {
            jotaikubumbetsuhantei.set市町村番号(全市町村コード);
            jotaikubumbetsuhantei.set市町村名(全市町村);
        } else {
            jotaikubumbetsuhantei.set市町村番号(parameter.getShichosonCode().value());
            jotaikubumbetsuhantei.set市町村名(parameter.getShichosonName());
        }
        jotaikubumbetsuhantei.set発行日時(RDateTime.now());
        jotaikubumbetsuhantei.set二次判定非該当タイトル(非該当タイトル);
        jotaikubumbetsuhantei.set二次判定要支援1タイトル(要支援1タイトル);
        jotaikubumbetsuhantei.set二次判定要支援2タイトル(要支援2タイトル);
        jotaikubumbetsuhantei.set二次判定要介護1タイトル(要介護1タイトル);
        jotaikubumbetsuhantei.set二次判定要介護2タイトル(要介護2タイトル);
        jotaikubumbetsuhantei.set二次判定要介護3タイトル(要介護3タイトル);
        jotaikubumbetsuhantei.set二次判定要介護4タイトル(要介護4タイトル);
        jotaikubumbetsuhantei.set二次判定要介護5タイトル(要介護5タイトル);
        jotaikubumbetsuhantei.set一次判定_計タイトル(計タイトル);
    }

    private int get被保険者数(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            RString 要介護認定一次判定結果コード,
            RString 二次判定要介護状態区分コード) {
        for (SinsakaiHanteiJyokyoEntity sinsakaiHanteiJyokyoEntity : 審査判定状況) {
            if (sinsakaiHanteiJyokyoEntity.getIchijiHanteiKekkaNinchishoKasanCode().value().equals(要介護認定一次判定結果コード)
                    && sinsakaiHanteiJyokyoEntity.getNijiHanteiYokaigoJotaiKubunCode().value().equals(二次判定要介護状態区分コード)) {
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
