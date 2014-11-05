/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResultSimple;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiRiyu;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiYusenWaritsukeKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.HihokenshaOutlineDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.ShinseiJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ShinseiJohoInputDivとビジネスクラス間のマッピング(変換)をします。
 *
 * @author N3327 三浦 凌
 */
public class YokaigoNinteiShinseiDivMapper {

    private YokaigoNinteiShinseiDivMapper() {
    }

    //TODO n3327 三浦凌 取り急ぎこの形で実装するが、また見直す。
    public static class YokaigoNinteiShinseiDiv {

        private final HihokenshaOutlineDiv hihokensha;
        private final ShinseiJohoInputDiv shinsei;

        public YokaigoNinteiShinseiDiv(ShinseiJohoInputDiv shinsei, HihokenshaOutlineDiv hihokensha) {
            this.hihokensha = hihokensha;
            this.shinsei = shinsei;
        }

        public HihokenshaOutlineDiv getHihokenshaOUtline() {
            return this.hihokensha;
        }

        public ShinseiJohoInputDiv getShinseiJohoInput() {
            return this.shinsei;
        }
    }

    public static YokaigoNinteiShinsei toYokaigoNinteiShinsei(YokaigoNinteiShinseiDiv div) {
        return new YokaigoNinteiShinsei(
                Item.申請書管理番号.<ShinseishoKanriNo>extractValue(div),
                Item.処理日時.<YMDHMS>extractValue(div),
                Item.保険者番号.<ShoKisaiHokenshaNo>extractValue(div),
                Item.支所コード.<ShishoCode>extractValue(div),
                Item.被保番号.<HihokenshaNo>extractValue(div),
                Item.識別コード.<ShikibetsuCode>extractValue(div),
                Item.認定申請日.<FlexibleDate>extractValue(div),
                Item.枝番コード.<EdabanCode>extractValue(div),
                Item.認定申請区分_申請時.<Code>extractValue(div),
                Item.認定申請区分_法令.<Code>extractValue(div),
                Item.認定申請有効区分.<Code>extractValue(div),
                Item.要支援申請区分.<Code>extractValue(div),
                Item.認定申請理由.<NinteiShinseiRiyu>extractValue(div),
                Item.前回認定結果.<NinteiResultSimple>extractValue(div),
                Item.情報提供への同意有無.<Boolean>extractValue(div),
                Item.認定調査依頼履歴番号.<NinteichosaIraiRirekiNo>extractValue(div),
                Item.意見書依頼履歴番号.<IkenshosakuseiIraiRirekiNo>extractValue(div).value(),
                Item.みなし要介護区分コード.<Code>extractValue(div),
                Item.延期通知有無同意.<Boolean>extractValue(div),
                Item.施設入所.<Boolean>extractValue(div),
                Item.市町村連絡事項.<RString>extractValue(div),
                Item.認定申請取下げ.<NinteiShinseiTorisage>extractValue(div),
                Item.審査会優先割付区分.<ShinsakaiYusenWaritsukeKubun>extractValue(div),
                Item.IF送付年月日.<FlexibleDate>extractValue(div)
        );
    }

    private enum Item {

        申請書管理番号 {

                    @Override
                    ShinseishoKanriNo extractValue(YokaigoNinteiShinseiDiv div) {
                        return new ShinseishoKanriNo(new RString("1111111111"));
                    }

                },
        処理日時 {

                    @Override
                    YMDHMS extractValue(YokaigoNinteiShinseiDiv div) {
                        return new YMDHMS(new RString("20140808102030"));
                    }

                },
        保険者番号 {

                    @Override
                    ShoKisaiHokenshaNo extractValue(YokaigoNinteiShinseiDiv div) {
                        return new ShoKisaiHokenshaNo(new RString("999999"));
                    }
                },
        支所コード {

                    @Override
                    ShishoCode extractValue(YokaigoNinteiShinseiDiv div) {
                        return ShishoCode.EMPTY;
                    }
                },
        被保番号 {
                    @Override
                    HihokenshaNo extractValue(YokaigoNinteiShinseiDiv div) {
                        return new HihokenshaNo(
                                div.getHihokenshaOUtline().getShikakuKihon().getTxtHihokenshaNo().getValue());
                    }
                },
        識別コード {
                    @Override
                    ShikibetsuCode extractValue(YokaigoNinteiShinseiDiv div) {
                        return new ShikibetsuCode("000000000000001");
                    }

                },
        認定申請日 {

                    @Override
                    FlexibleDate extractValue(YokaigoNinteiShinseiDiv div) {
                        return new FlexibleDate(div.getShinseiJohoInput().getTxtShinseiDate().getValue().toDateString());
                    }
                },
        枝番コード {

                    @Override
                    EdabanCode extractValue(YokaigoNinteiShinseiDiv div) {
                        return new EdabanCode("000");
                    }
                },
        認定申請区分_申請時 {

                    @Override
                    Code extractValue(YokaigoNinteiShinseiDiv div) {
                        return new Code(div.getShinseiJohoInput().getDdlShinseiKubunShinseiji().getSelectedItem());
                    }
                },
        認定申請区分_法令 {

                    @Override
                    Code extractValue(YokaigoNinteiShinseiDiv div) {
                        return new Code(RString.EMPTY);
                    }
                },
        認定申請有効区分 {

                    @Override
                    Code extractValue(YokaigoNinteiShinseiDiv div) {
                        return new Code(RString.EMPTY);
                    }
                },
        要支援申請区分 {

                    @Override
                    Code extractValue(YokaigoNinteiShinseiDiv div) {
                        return new Code(RString.EMPTY);
                    }
                },
        認定申請理由 {

                    @Override
                    NinteiShinseiRiyu extractValue(YokaigoNinteiShinseiDiv div) {
                        return new NinteiShinseiRiyu(
                                div.getShinseiJohoInput().getSinseiRiyu().getTxtShinseiRiyu().getValue()
                        );
                    }
                },
        前回認定結果 {

                    @Override
                    NinteiResultSimple extractValue(YokaigoNinteiShinseiDiv div) {
                        return NinteiResultSimple.NONE;
                    }
                },
        情報提供への同意有無 {

                    @Override
                    Boolean extractValue(YokaigoNinteiShinseiDiv div) {
                        return div.getShinseiJohoInput().getChkJohoteikyo().isAllSelected();
                    }
                },
        認定調査依頼履歴番号 {

                    @Override
                    NinteichosaIraiRirekiNo extractValue(YokaigoNinteiShinseiDiv div
                    ) {
                        return new NinteichosaIraiRirekiNo(0);
                    }
                },
        意見書依頼履歴番号 {

                    @Override
                    IkenshosakuseiIraiRirekiNo extractValue(YokaigoNinteiShinseiDiv div) {
                        return new IkenshosakuseiIraiRirekiNo(0);
                    }
                },
        みなし要介護区分コード {

                    @Override
                    Code extractValue(YokaigoNinteiShinseiDiv div) {
                        return new Code(RString.EMPTY);
                    }
                },
        延期通知有無同意 {

                    @Override
                    Boolean extractValue(YokaigoNinteiShinseiDiv div) {
                        return div.getShinseiJohoInput().getChkEnkitsuchiHakko().isAllSelected();
                    }
                },
        施設入所 {

                    @Override
                    Boolean extractValue(YokaigoNinteiShinseiDiv div) {
                        return !div.getShinseiJohoInput().getNyuinNyusho().getDgShisetsuRereki().getDataSource().isEmpty();
                    }
                },
        市町村連絡事項 {

                    @Override
                    RString extractValue(YokaigoNinteiShinseiDiv div) {
                        return div.getShinseiJohoInput().getShichosonRenrakuJiko().getTxtShichosonRenrakuJiko().getValue();
                    }
                },
        認定申請取下げ {

                    @Override
                    NinteiShinseiTorisage extractValue(YokaigoNinteiShinseiDiv div) {
                        return NinteiShinseiTorisage.NONE;
                    }
                },
        審査会優先割付区分 {

                    @Override
                    ShinsakaiYusenWaritsukeKubun extractValue(YokaigoNinteiShinseiDiv div) {
                        return ShinsakaiYusenWaritsukeKubun.優先しない;
                    }
                },
        IF送付年月日 {

                    @Override
                    FlexibleDate extractValue(YokaigoNinteiShinseiDiv div) {
                        return FlexibleDate.EMPTY;
                    }
                };

        abstract <T> T extractValue(YokaigoNinteiShinseiDiv div);
    }
}
