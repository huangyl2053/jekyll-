/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei.JisshiJokyoTokei;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.JisshiJokyoTokeiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JisshiJokyoTokeiEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class JisshiJokyoTokeiEditor {

    private static final int 申請受付 = 0;
    private static final int 調査実施 = 1;
    private static final int 審査会実施 = 2;
    private static final int 認定結果 = 3;
    private final JisshiJokyoTokeiProcessParameter parameter;
    private final JisshiJokyoTokeiEntity entity;
    private final JisshiJokyoTokei jisshiJokyoTokei;
    private static final RString 全市町村 = new RString("全市町村");

    /**
     * コンストラクタです。
     *
     * @param parameter JisshiJokyoTokeiProcessParameter
     * @param entity JisshiJokyoTokeiEntity
     * @param jisshiJokyoTokei JisshiJokyoTokei
     */
    public JisshiJokyoTokeiEditor(
            JisshiJokyoTokeiProcessParameter parameter,
            JisshiJokyoTokeiEntity entity,
            JisshiJokyoTokei jisshiJokyoTokei) {
        this.parameter = parameter;
        this.entity = entity;
        this.jisshiJokyoTokei = jisshiJokyoTokei;
    }

    /**
     * 要介護認定事業状況を取得します。
     */
    public void set要介護認定事業状況() {
        if (申請受付 == entity.getNiTeiJokyo()) {
            set申請受付(entity);
        } else if (調査実施 == entity.getNiTeiJokyo()) {
            set調査実施(entity);
        } else if (審査会実施 == entity.getNiTeiJokyo()) {
            set審査会実施(entity);
        } else if (認定結果 == entity.getNiTeiJokyo()) {
            set認定結果(entity);
        }
        set保険者(entity);
    }

    private void set申請受付(JisshiJokyoTokeiEntity entity) {
        if (parameter.isHorei()) {
            int 新規申請受付数法令 = 0;
            int 更新申請受付数法令 = 0;
            int 区分変更申請受付数法令 = 0;
            if (NinteiShinseiHoreiCode.新規申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                新規申請受付数法令 = entity.getCountKensu();
            } else if (NinteiShinseiHoreiCode.更新申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                更新申請受付数法令 = entity.getCountKensu();
            } else if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                区分変更申請受付数法令 = entity.getCountKensu();
            }
            jisshiJokyoTokei.set新規申請_申請受付数(toRString(toInt(jisshiJokyoTokei.get新規申請_申請受付数()) + 新規申請受付数法令));
            jisshiJokyoTokei.set更新申請_申請受付数(toRString(toInt(jisshiJokyoTokei.get更新申請_申請受付数()) + 更新申請受付数法令));
            jisshiJokyoTokei.set区分変更申請_申請受付数(toRString(toInt(jisshiJokyoTokei.get区分変更申請_申請受付数()) + 区分変更申請受付数法令));
        }
        if (parameter.isShinseiji()) {
            int 新規申請受付数申請時 = 0;
            int 更新申請受付数申請時 = 0;
            int 区分変更申請受付数申請時 = 0;
            if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                新規申請受付数申請時 = entity.getCountKensu();
            } else if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                更新申請受付数申請時 = entity.getCountKensu();
            } else if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                区分変更申請受付数申請時 = entity.getCountKensu();
            }
            jisshiJokyoTokei.set新規申請_申請受付数(toRString(toInt(jisshiJokyoTokei.get新規申請_申請受付数()) + 新規申請受付数申請時));
            jisshiJokyoTokei.set更新申請_申請受付数(toRString(toInt(jisshiJokyoTokei.get更新申請_申請受付数()) + 更新申請受付数申請時));
            jisshiJokyoTokei.set区分変更申請_申請受付数(toRString(toInt(jisshiJokyoTokei.get区分変更申請_申請受付数()) + 区分変更申請受付数申請時));
        }
    }

    private void set調査実施(JisshiJokyoTokeiEntity entity) {
        if (parameter.isHorei()) {
            int 新規調査実施数法令 = 0;
            int 更新調査実施数法令 = 0;
            int 区分変更調査実施数法令 = 0;
            if (NinteiShinseiHoreiCode.新規申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                新規調査実施数法令 = entity.getCountKensu();
            } else if (NinteiShinseiHoreiCode.更新申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                更新調査実施数法令 = entity.getCountKensu();
            } else if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                区分変更調査実施数法令 = entity.getCountKensu();
            }
            jisshiJokyoTokei.set新規申請_調査実施数(toRString(toInt(jisshiJokyoTokei.get新規申請_調査実施数()) + 新規調査実施数法令));
            jisshiJokyoTokei.set更新申請_調査実施数(toRString(toInt(jisshiJokyoTokei.get更新申請_調査実施数()) + 更新調査実施数法令));
            jisshiJokyoTokei.set区分変更申請_調査実施数(toRString(toInt(jisshiJokyoTokei.get区分変更申請_調査実施数()) + 区分変更調査実施数法令));
        }
        if (parameter.isShinseiji()) {
            int 新規調査実施数申請時 = 0;
            int 更新調査実施数申請時 = 0;
            int 区分変更調査実施数申請時 = 0;
            if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                新規調査実施数申請時 = entity.getCountKensu();
            } else if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                更新調査実施数申請時 = entity.getCountKensu();
            } else if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                区分変更調査実施数申請時 = entity.getCountKensu();
            }
            jisshiJokyoTokei.set新規申請_調査実施数(toRString(toInt(jisshiJokyoTokei.get新規申請_調査実施数()) + 新規調査実施数申請時));
            jisshiJokyoTokei.set更新申請_調査実施数(toRString(toInt(jisshiJokyoTokei.get更新申請_調査実施数()) + 更新調査実施数申請時));
            jisshiJokyoTokei.set区分変更申請_調査実施数(toRString(toInt(jisshiJokyoTokei.get区分変更申請_調査実施数()) + 区分変更調査実施数申請時));
        }
    }

    private void set審査会実施(JisshiJokyoTokeiEntity entity) {
        if (parameter.isHorei()) {
            int 新規審査会実施数法令 = 0;
            int 更新審査会実施数法令 = 0;
            int 区分変更審査会実施数法令 = 0;
            if (NinteiShinseiHoreiCode.新規申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                新規審査会実施数法令 = entity.getCountKensu();
            } else if (NinteiShinseiHoreiCode.更新申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                更新審査会実施数法令 = entity.getCountKensu();
            } else if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                区分変更審査会実施数法令 = entity.getCountKensu();
            }
            jisshiJokyoTokei.set新規申請_審査会実施数(toRString(toInt(jisshiJokyoTokei.get新規申請_審査会実施数()) + 新規審査会実施数法令));
            jisshiJokyoTokei.set更新申請_審査会実施数(toRString(toInt(jisshiJokyoTokei.get更新申請_審査会実施数()) + 更新審査会実施数法令));
            jisshiJokyoTokei.set区分変更申請_審査会実施数(toRString(toInt(jisshiJokyoTokei.get区分変更申請_審査会実施数()) + 区分変更審査会実施数法令));
        }
        if (parameter.isShinseiji()) {
            int 新規審査会実施数申請時 = 0;
            int 更新審査会実施数申請時 = 0;
            int 区分変更審査会実施数申請時 = 0;
            if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                新規審査会実施数申請時 = entity.getCountKensu();
            } else if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                更新審査会実施数申請時 = entity.getCountKensu();
            } else if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                区分変更審査会実施数申請時 = entity.getCountKensu();
            }
            jisshiJokyoTokei.set新規申請_審査会実施数(toRString(toInt(jisshiJokyoTokei.get新規申請_審査会実施数()) + 新規審査会実施数申請時));
            jisshiJokyoTokei.set更新申請_審査会実施数(toRString(toInt(jisshiJokyoTokei.get更新申請_審査会実施数()) + 更新審査会実施数申請時));
            jisshiJokyoTokei.set区分変更申請_審査会実施数(toRString(toInt(jisshiJokyoTokei.get区分変更申請_審査会実施数()) + 区分変更審査会実施数申請時));
        }
    }

    private void set認定結果(JisshiJokyoTokeiEntity entity) {
        if (parameter.isHorei()) {
            int 新規認定結果数法令 = 0;
            int 更新認定結果数法令 = 0;
            int 区分変更認定結果数法令 = 0;
            if (NinteiShinseiHoreiCode.新規申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                新規認定結果数法令 = entity.getCountKensu();
            }
            if (NinteiShinseiHoreiCode.更新申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                更新認定結果数法令 = entity.getCountKensu();
            }
            if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                区分変更認定結果数法令 = entity.getCountKensu();
            }
            jisshiJokyoTokei.set新規申請_認定結果数(toRString(toInt(jisshiJokyoTokei.get新規申請_認定結果数()) + 新規認定結果数法令));
            jisshiJokyoTokei.set更新申請_認定結果数(toRString(toInt(jisshiJokyoTokei.get更新申請_認定結果数()) + 更新認定結果数法令));
            jisshiJokyoTokei.set区分変更申請_認定結果数(toRString(toInt(jisshiJokyoTokei.get区分変更申請_認定結果数()) + 区分変更認定結果数法令));
        }
        if (parameter.isShinseiji()) {
            int 新規認定結果数申請時 = 0;
            int 更新認定結果数申請時 = 0;
            int 区分変更認定結果数申請時 = 0;
            if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                新規認定結果数申請時 = entity.getCountKensu();
            }
            if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                更新認定結果数申請時 = entity.getCountKensu();
            }
            if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                区分変更認定結果数申請時 = entity.getCountKensu();
            }
            jisshiJokyoTokei.set新規申請_認定結果数(toRString(toInt(jisshiJokyoTokei.get新規申請_認定結果数()) + 新規認定結果数申請時));
            jisshiJokyoTokei.set更新申請_認定結果数(toRString(toInt(jisshiJokyoTokei.get更新申請_認定結果数()) + 更新認定結果数申請時));
            jisshiJokyoTokei.set区分変更申請_認定結果数(toRString(toInt(jisshiJokyoTokei.get区分変更申請_認定結果数()) + 区分変更認定結果数申請時));
        }
    }

    private void set保険者(JisshiJokyoTokeiEntity entity) {
        if (!parameter.isEmptyHokensyaNo()) {
            jisshiJokyoTokei.set保険者番号(entity.getShoKisaiHokenshaNo());
            jisshiJokyoTokei.set保険者名(entity.getShichosonMeisho());
        } else {
            jisshiJokyoTokei.set保険者番号(RString.EMPTY);
            jisshiJokyoTokei.set保険者名(全市町村);
        }
    }

    /**
     * 合計情報を取得します。
     */
    public void set合計() {
        jisshiJokyoTokei.set合計_申請受付数(new RString(toInt(jisshiJokyoTokei.get新規申請_申請受付数())
                + toInt(jisshiJokyoTokei.get更新申請_申請受付数()) + toInt(jisshiJokyoTokei.get区分変更申請_申請受付数())));
        jisshiJokyoTokei.set合計_調査実施数(new RString(toInt(jisshiJokyoTokei.get新規申請_調査実施数())
                + toInt(jisshiJokyoTokei.get更新申請_調査実施数()) + toInt(jisshiJokyoTokei.get区分変更申請_調査実施数())));
        jisshiJokyoTokei.set合計_審査会実施数(new RString(toInt(jisshiJokyoTokei.get新規申請_審査会実施数())
                + toInt(jisshiJokyoTokei.get更新申請_審査会実施数()) + toInt(jisshiJokyoTokei.get区分変更申請_審査会実施数())));
        jisshiJokyoTokei.set合計_認定結果数(new RString(toInt(jisshiJokyoTokei.get新規申請_認定結果数())
                + toInt(jisshiJokyoTokei.get更新申請_認定結果数()) + toInt(jisshiJokyoTokei.get区分変更申請_認定結果数())));
    }

    private RString toRString(int 保険者数) {
        return 保険者数 == 0 ? RString.EMPTY : new RString(保険者数);
    }

    private int toInt(RString 保険者数) {
        return RString.isNullOrEmpty(保険者数) ? 0 : Integer.parseInt(保険者数.toString());
    }
}
