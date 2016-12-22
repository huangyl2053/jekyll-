/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIraiShokai.NinteiChosaIraiShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosairaishokai.NinteiChosaIraiShokaiMaster;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * {@link NinteiChosaIraiShokaiDiv}のHandlerクラスです。
 *
 * @reamsid_L DBE-0200-020 zhangguopeng
 */
public class NinteiChosaIraiShokaiHandler {

    private final NinteiChosaIraiShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 申請その他情報Div
     */
    public NinteiChosaIraiShokaiHandler(NinteiChosaIraiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 認定調査依頼照会の初期化処理ください。
     *
     * @param ninteiChosaList 認定調査情報
     */
    public void onLoad(List<NinteiChosaIraiShokaiMaster> ninteiChosaList) {
//        div.getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        List<dgNinteiChosaIrai_Row> rowList = new ArrayList<>();
        int no = 1;
        for (NinteiChosaIraiShokaiMaster entity : ninteiChosaList) {
            dgNinteiChosaIrai_Row row = new dgNinteiChosaIrai_Row();
            row.setNo(new RString(Integer.toString(no)));
            row.setNinteiShinseiDate(日期フォマト(entity.getNinteiShinseiYMD()));
            row.setShinseiKubun(get申請区分(entity.getNinteiShinseiShinseijiKubunCode().getColumnValue()));
            row.setShinseiTorikeshiDate(日期フォマト(entity.getTorisageYMD()));
            row.setNinteiDate(日期フォマト(entity.getNijiHanteiYMD()));
            RString 要介護度 = get要介護度(entity.getKoroshoIfShikibetsuCode().value(),
                    entity.getNijiHanteiYokaigoJotaiKubunCode().getColumnValue());
            if (new RString("なし").equals(要介護度)) {
                row.setYokaigodo(RString.EMPTY);
            } else {
                row.setYokaigodo(get要介護度(entity.getKoroshoIfShikibetsuCode().value(),
                        entity.getNijiHanteiYokaigoJotaiKubunCode().getColumnValue()));
            }
            row.setYukoKikan(new RString(Integer.toString(entity.getNijiHanteiNinteiYukoKikan()) + "ヶ月"));
            row.setChosaIraiDate(日期フォマト(entity.getNinteichosaIraiYMD()));
            row.setNinteichosaItakusakiCode(entity.getNinteiChosaItakusakiCode().getColumnValue());
            row.setNinteichosaItakusakiName(entity.getJigyoshaMeisho());
            row.setNinteiChosainCode(entity.getNinteiChosainCode().getColumnValue());
            row.setNinteiChosainName(entity.getChosainShimei());
            row.setRirekiNo(get履歴区分(entity.getNinteichosaIraiKubunCode().getColumnValue()));
            no = no + 1;
            rowList.add(row);
        }
        div.getDgNinteiChosaIrai().setDataSource(rowList);
    }

    private RString 日期フォマト(FlexibleDate 日期) {
        if (日期 == null || 日期.isEmpty()) {
            return RString.EMPTY;
        }
        return 日期.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
    }

    private RString get申請区分(RString 申請区分コード) {
        RString 申請区分 = RString.EMPTY;
        List<KeyValueDataSource> dataSource = new ArrayList();
        for (NinteiShinseiShinseijiKubunCode seibetsu : NinteiShinseiShinseijiKubunCode.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(seibetsu.getコード());
            keyValue.setValue(seibetsu.get名称());
            dataSource.add(keyValue);
        }

        for (KeyValueDataSource 申請区分Enum : dataSource) {
            if (申請区分コード.equals(申請区分Enum.getKey())) {
                申請区分 = 申請区分Enum.getValue();
            }
        }
        return 申請区分;
    }

    private RString get要介護度(RString 厚労省IF識別コード, RString 要介護度コード) {
        if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun99.toValue(要介護度コード).get名称();
        } else if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun02.toValue(要介護度コード).get名称();
        } else if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun06.toValue(要介護度コード).get名称();
        } else {
            return YokaigoJotaiKubun09.toValue(要介護度コード).get名称();
        }
    }

    private RString get履歴区分(RString 履歴区分コード) {
        RString 履歴区分 = RString.EMPTY;
        List<KeyValueDataSource> dataSource = new ArrayList();
        for (NinteiChousaIraiKubunCode seibetsu : NinteiChousaIraiKubunCode.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(seibetsu.getコード());
            keyValue.setValue(seibetsu.get名称());
            dataSource.add(keyValue);
        }

        for (KeyValueDataSource 履歴区分Enum : dataSource) {
            if (履歴区分コード.equals(履歴区分Enum.getKey())) {
                履歴区分 = 履歴区分Enum.getValue();
            }
        }
        return 履歴区分;
    }
}
