/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinsei;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaiShukeihyoShinseiBetsuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaiShukeihyoShinseiBetsuEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsakaiShukeihyoShinseiBetsuEditor {

    private static final int 申請区分申請時 = 1;
    private static final int 申請区分法令 = 2;
    private static final int 申請区分申請時法令 = 3;
    private static final int 認定受付 = 0;
    private static final int 認定調査 = 1;
    private static final int 認定意見書 = 2;
    private static final int 認定審査会 = 3;
    private static final int 認定二次判定 = 4;
    private static final RString 転入数_ZERO = new RString("0");
    private static final RString 全市町村 = new RString("全市町村");
    private final ShinsakaiShukeihyoShinseiBetsuEntity current;
    private final ShinsakaiShukeihyoShinsei shukeihyoShinseiBetsu;
    private final ShinsakaiShukeihyoShinseiBetsuProcessParameter parameter;

    /**
     * コンストラクタです。
     *
     * @param parameter ShinsakaiShukeihyoShinseiBetsuProcessParameter
     * @param current ShinsakaiShukeihyoShinseiBetsuEntity
     * @param shukeihyoShinseiBetsu ShinsakaiShukeihyoShinsei
     */
    public ShinsakaiShukeihyoShinseiBetsuEditor(ShinsakaiShukeihyoShinseiBetsuProcessParameter parameter,
            ShinsakaiShukeihyoShinseiBetsuEntity current,
            ShinsakaiShukeihyoShinsei shukeihyoShinseiBetsu) {
        this.current = current;
        this.shukeihyoShinseiBetsu = shukeihyoShinseiBetsu;
        this.parameter = parameter;
    }

    /**
     * 介護認定審査会集計表現在の状況別を設定します。
     */
    public void set介護認定審査会集計表申請区分別() {
        if (申請区分申請時 == current.getNiTeiShinseiKubun()) {
            set申請区分申請時新規申請();
            set申請区分申請時更新申請();
            set申請区分申請時区分変更申請();
            set申請区分申請時転入申請();
        }
        if (申請区分法令 == current.getNiTeiShinseiKubun()) {
            set申請区分法令新規申請();
            set申請区分法令更新申請();
            set申請区分法令区分変更申請();
            set申請区分法令転入申請();
        }
        if (申請区分申請時法令 == current.getNiTeiShinseiKubun()) {
            set法令新規申請申請時();
            set法令更新申請申請時();
            set法令区分変更申請申請時();
            set法令区変却下申請時();
        }
        set申請区分申請時合計();
        set申請区分法令合計();
        if (!parameter.isEmptyHokensyaNo()) {
            shukeihyoShinseiBetsu.set市町村名称(current.getShichosonMeisho());
        } else {
            shukeihyoShinseiBetsu.set市町村名称(全市町村);
        }

    }

    private void set申請区分申請時新規申請() {
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_受付数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_新規申請_受付数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_調査数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_新規申請_調査数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_意見書数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_新規申請_意見書数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_審査会数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_新規申請_審査会数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_二次判定数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_新規申請_二次判定数()) + current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分申請時更新申請() {
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_受付数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_更新申請_受付数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_調査数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_更新申請_調査数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_意見書数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_更新申請_意見書数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_審査会数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_更新申請_審査会数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_二次判定数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_更新申請_二次判定数()) + current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分申請時区分変更申請() {
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_受付数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_区分変更申請_受付数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_調査数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_区分変更申請_調査数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_意見書数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_区分変更申請_意見書数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_審査会数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_区分変更申請_審査会数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_二次判定数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_区分変更申請_二次判定数()) + current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分申請時転入申請() {
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_受付数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_転入_受付数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_調査数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_転入_調査数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_意見書数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_転入_意見書数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_審査会数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_転入_審査会数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_二次判定数(
                    toRString(toInt(shukeihyoShinseiBetsu.get申_転入_二次判定数()) + current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分申請時合計() {
        shukeihyoShinseiBetsu.set申_合計_受付数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_受付数())));
        shukeihyoShinseiBetsu.set申_合計_調査数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_調査数())));
        shukeihyoShinseiBetsu.set申_合計_意見書数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_意見書数())));
        shukeihyoShinseiBetsu.set申_合計_審査会数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_審査会数())));
        shukeihyoShinseiBetsu.set申_合計_二次判定数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_二次判定数())));
    }

    private void set申請区分法令新規申請() {
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_受付数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_新規申請_受付数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_調査数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_新規申請_調査数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_意見書数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_新規申請_意見書数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_審査会数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_新規申請_審査会数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_二次判定数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_新規申請_二次判定数()) + current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分法令更新申請() {
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_受付数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_更新申請_受付数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_調査数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_更新申請_調査数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_意見書数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_更新申請_意見書数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_審査会数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_更新申請_審査会数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_二次判定数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_更新申請_二次判定数()) + current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分法令区分変更申請() {
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_受付数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_区分変更申請_受付数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_調査数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_区分変更申請_調査数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_意見書数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_区分変更申請_意見書数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_審査会数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_区分変更申請_審査会数()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_二次判定数(
                    toRString(toInt(shukeihyoShinseiBetsu.get法_区分変更申請_二次判定数()) + current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分法令転入申請() {
        shukeihyoShinseiBetsu.set法_転入_受付数(転入数_ZERO);
        shukeihyoShinseiBetsu.set法_転入_調査数(転入数_ZERO);
        shukeihyoShinseiBetsu.set法_転入_意見書数(転入数_ZERO);
        shukeihyoShinseiBetsu.set法_転入_審査会数(転入数_ZERO);
        shukeihyoShinseiBetsu.set法_転入_二次判定数(転入数_ZERO);
    }

    private void set申請区分法令合計() {
        shukeihyoShinseiBetsu.set法_合計_受付数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_受付数())));
        shukeihyoShinseiBetsu.set法_合計_調査数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_調査数())));
        shukeihyoShinseiBetsu.set法_合計_意見書数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_意見書数())));
        shukeihyoShinseiBetsu.set法_合計_審査会数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_審査会数())));
        shukeihyoShinseiBetsu.set法_合計_二次判定数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_二次判定数())));
    }

    private void set法令新規申請申請時() {
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_新規申請_申_新規申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_新規申請_申_新規申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_新規申請_申_更新申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_新規申請_申_更新申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_新規申請_申_区分変更申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_新規申請_申_区分変更申請()) + current.getCountHihokenshaNo()));
        }
    }

    private void set法令更新申請申請時() {
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_更新申請_申_新規申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_更新申請_申_新規申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_更新申請_申_更新申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_更新申請_申_更新申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_更新申請_申_区分変更申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_更新申請_申_区分変更申請()) + current.getCountHihokenshaNo()));
        }
    }

    private void set法令区分変更申請申請時() {
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区分変更申請_申_新規申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区分変更申請_申_新規申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区分変更申請_申_更新申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区分変更申請_申_更新申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区分変更申請_申_区分変更申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区分変更申請_申_区分変更申請()) + current.getCountHihokenshaNo()));
        }
    }

    private void set法令区変却下申請時() {
        if (NinteiShinseiHoreiCode.職権.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区変却下_申_新規申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区変却下_申_新規申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.職権.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区変却下_申_更新申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区変却下_申_更新申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.職権.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区変却下_申_区分変更申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区変却下_申_区分変更申請()) + current.getCountHihokenshaNo()));
        }
    }

    private int toInt(RString 保険者数) {
        if (RString.isNullOrEmpty(保険者数)) {
            return 0;
        }
        return Integer.parseInt(保険者数.toString());
    }

    private RString toRString(int 保険者数) {
        return 保険者数 == 0 ? RString.EMPTY : new RString(保険者数);
    }
}
