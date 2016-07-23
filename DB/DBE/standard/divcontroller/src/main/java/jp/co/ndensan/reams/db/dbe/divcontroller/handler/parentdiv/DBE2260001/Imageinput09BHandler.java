/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2260001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.TorokuData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.dgshinseishaichiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKinyuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取込み（規定・規定外）のコントローラクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public class Imageinput09BHandler {

    private static final RString 空白 = RString.EMPTY;

    /**
     * 記入項目を設定します。
     *
     * @param joho 要介護認定主治医意見書情報
     * @param row 一覧データ
     * @param data CSVデータ
     * @return 要介護認定主治医意見書情報
     */
    public ShujiiIkenshoJoho set09B項目(ShujiiIkenshoJoho joho, dgshinseishaichiran_Row row, TorokuData data) {
        List<ShujiiIkenshoKinyuItem> itemList = joho.getShujiiIkenshoKinyuItemList();
        List<ShujiiIkenshoIkenItem> 意見項目List = joho.getShujiiIkenshoIkenItemList();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(data.getT5101_厚労省IF識別コード())) {
            for (ShujiiIkenshoKinyuItem item : itemList) {
                joho = set09B記入項目1(joho, row, data, item);
                joho = set09B記入項目2(joho, row, data, item);
                joho = set09B記入項目3(joho, row, data, item);
                joho = set09B記入項目4(joho, row, data, item);
            }
            for (ShujiiIkenshoIkenItem 意見項目 : 意見項目List) {
                joho = set09B意見項目1(joho, row, data, 意見項目);
                joho = set09B意見項目2(joho, row, data, 意見項目);
                joho = set09B意見項目3(joho, row, data, 意見項目);
                joho = set09B意見項目4(joho, row, data, 意見項目);
                joho = set09B意見項目5(joho, row, data, 意見項目);
                joho = set09B意見項目6(joho, row, data, 意見項目);
                joho = set09B意見項目7(joho, row, data, 意見項目);
                joho = set09B意見項目8(joho, row, data, 意見項目);
                joho = set09B意見項目9(joho, row, data, 意見項目);
                joho = set09B意見項目10(joho, row, data, 意見項目);
                joho = set09B意見項目11(joho, row, data, 意見項目);
                joho = set09B意見項目12(joho, row, data, 意見項目);
                joho = set09B意見項目13(joho, row, data, 意見項目);
            }
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B記入項目1(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping09B.その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.getその他()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.その他の精神_神経症状.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get精神_神経症状()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.その他の精神_神経症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get精神_神経症状()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.専門医受診の有無.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get専門科医受診()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.専門医受診の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get専門科医受診()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.身長.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(空白).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.身長.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.体重.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(空白).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.体重.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B記入項目2(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping09B.四肢欠損.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get四肢欠損()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.四肢欠損.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get四肢欠損()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.麻痺_その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get麻痺_その他()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.麻痺_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get麻痺_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.筋力の低下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get筋力低下()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.筋力の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get筋力低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.関節の拘縮.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get間接の拘縮()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.関節の拘縮.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get間接の拘縮()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B記入項目3(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping09B.関節の痛み.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get間接の痛み()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.関節の痛み.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get間接の痛み()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.じょくそう.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get褥瘡()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.じょくそう.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get褥瘡()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.その他の皮膚疾患.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.getその他皮膚疾患()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.その他の皮膚疾患.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他皮膚疾患()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.栄養_食生活上の留意点.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get現在の栄養状況()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.栄養_食生活上の留意点.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get現在の栄養状況()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.病態_その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get高い病態_その他()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.病態_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get高い病態_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.病態_対処方針.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(空白).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.病態_対処方針.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.その他の医療系のサービス.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.getその他の医療系サービス()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.その他の医療系のサービス.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他の医療系サービス()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.介護サービスの留意事項_血圧.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get血圧()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.介護サービスの留意事項_血圧.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get血圧()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B記入項目4(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping09B.介護サービスの留意事項_嚥下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get嚥下()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.介護サービスの留意事項_嚥下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get嚥下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.介護サービスの留意事項_摂食.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get摂食()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.介護サービスの留意事項_摂食.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.介護サービスの留意事項_移動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get移動()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.介護サービスの留意事項_移動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get移動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.介護サービスの留意事項_運動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get運動()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.介護サービスの留意事項_運動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get運動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.介護サービスの留意事項_その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(空白).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.介護サービスの留意事項_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (IkenshoKinyuMapping09B.感染症の有無.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get感染症()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item).build();
        } else {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping09B.感染症の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get感染症()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目1(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.点滴の管理.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get点滴の管理()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.点滴の管理.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get点滴の管理()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.中心静脈栄養.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get中心静脈栄養()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.中心静脈栄養.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get中心静脈栄養()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.透析.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get透折()).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.透析.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get透折()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.ストーマの処置.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getストーマの処置()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.ストーマの処置.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getストーマの処置()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.酸素療法.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get酸素療法()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.酸素療法.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get酸素療法()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.レスピレーター.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getレスピレーター()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.レスピレーター.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getレスピレーター()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.気管切開の処置.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get気管切開の処置()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.気管切開の処置.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get気管切開の処置()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.疼痛の看護.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get疼痛の看護()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.疼痛の看護.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get疼痛の看護()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目2(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.経管栄養.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get経管栄養()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.経管栄養.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get経管栄養()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.モニター測定.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getモニター測定()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.モニター測定.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getモニター測定()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.じょくそうの処置.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get褥痩の処置()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.じょくそうの処置.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥痩の処置()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.カテーテル.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getカテーテル()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.カテーテル.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getカテーテル()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.寝たきり度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get障害高齢者の自立度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.寝たきり度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get障害高齢者の自立度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get認知症高齢者の自立度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get認知症高齢者の自立度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.短期記憶.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get短期記憶()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.短期記憶.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get短期記憶()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.認知能力.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get認知能力()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.認知能力.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get認知能力()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.伝達能力.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get伝達能力()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.伝達能力.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get伝達能力()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目3(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.認知症の周辺症状.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get問題行動の有無()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.認知症の周辺症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get問題行動の有無()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.幻視_幻聴.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get幻視_幻聴()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.幻視_幻聴.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get幻視_幻聴()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.妄想.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get妄想()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.妄想.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get妄想()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.昼夜逆転.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get昼夜逆転()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.昼夜逆転.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get昼夜逆転()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.暴言.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get暴言()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.暴言.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get暴言()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.暴行.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get暴行()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.暴行.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get暴行()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.介護への抵抗.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get介護への抵抗()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.介護への抵抗.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get介護への抵抗()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.徘徊_認知症の周辺症状.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get徘徊()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.徘徊_認知症の周辺症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get徘徊()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.火の不始末.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get火の不始末()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.火の不始末.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get火の不始末()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.過去6カ月の体重の変化.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get過去6ヶ月の体重の変化()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.過去6カ月の体重の変化.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get過去6ヶ月の体重の変化()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目4(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.不潔行為.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get不潔行為()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.不潔行為.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get不潔行為()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.異食行動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get異食行動()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.異食行動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get異食行動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.性的問題行動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get性的問題行動()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.性的問題行動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get性的問題行動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.その他の精神_神経症状.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get精神_神経症状()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.その他の精神_神経症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get精神_神経症状()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.専門医受診の有無.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get専門科医受診()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.専門医受診の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get専門科医受診()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.利き腕.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get利き腕()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.利き腕.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get利き腕()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.四肢欠損.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get四肢欠損()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.四肢欠損.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get四肢欠損()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目5(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.麻痺.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.麻痺_右上肢.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_右上肢()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_右上肢.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_右上肢()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.筋力の低下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get筋力低下()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.筋力の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get筋力低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.筋力の低下_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get筋力低下_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.筋力の低下_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get筋力低下_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.じょくそう.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get褥痩()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.じょくそう.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥痩()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.じょくそう_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get褥痩_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.じょくそう_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥痩_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.その他の皮膚疾患.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他皮膚疾患()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.その他の皮膚疾患.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他皮膚疾患()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.その他の皮膚疾患_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他皮膚疾患_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.その他の皮膚疾患_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他皮膚疾患_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.関節の拘縮.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get間接の拘縮()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.関節の拘縮.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get間接の拘縮()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目6(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.関節の拘縮_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get間接の拘縮_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.関節の拘縮_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get間接の拘縮_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.関節の痛み.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get間接の痛み()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.関節の痛み.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get間接の痛み()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.関節の痛み_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get間接の痛み_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.関節の痛み_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get間接の痛み_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.屋外歩行.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get屋外歩行()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.屋外歩行.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get屋外歩行()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.車いすの使用.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get車いすの使用()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.車いすの使用.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get車いすの使用()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.歩行補助具_装具の使用_用いていない.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.歩行補助具_装具の使用_用いていない.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.歩行補助具_装具の使用_屋外で使用.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用_屋外()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.歩行補助具_装具の使用_屋外で使用.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用_屋外()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.歩行補助具_装具の使用_屋内で使用.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用_屋内()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.歩行補助具_装具の使用_屋内で使用.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用_屋内()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.失調_不随意運動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get失調_不随意運動()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.失調_不随意運動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get失調_不随意運動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目7(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.失調_不随意運動_上肢_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get上肢_右()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.失調_不随意運動_上肢_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get上肢_右()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.失調_不随意運動_上肢_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get上肢_左()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.失調_不随意運動_上肢_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get上肢_左()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.失調_不随意運動_体幹_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get体幹_右()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.失調_不随意運動_体幹_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get体幹_右()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.失調_不随意運動_下肢_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get下肢_右()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.失調_不随意運動_下肢_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get下肢_右()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.失調_不随意運動_下肢_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get下肢_左()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.失調_不随意運動_下肢_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get下肢_左()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.尿失禁.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get尿失禁()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.尿失禁.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get尿失禁()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.転倒_骨折.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get転倒_骨折()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.転倒_骨折.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get転倒_骨折()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.移動能力の低下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get移動能力の低下()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.移動能力の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get移動能力の低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.褥瘡.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get褥瘡()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.褥瘡.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥瘡()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目8(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.食事行為.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get食事行為()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.食事行為.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get食事行為()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.現在の栄養状態.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get現在の栄養状況()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.現在の栄養状態.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get現在の栄養状況()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.易感染性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.易感染性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.心肺機能の低下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get心肺機能の低下()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.心肺機能の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get心肺機能の低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.がん等による疼痛.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getがん等による疼痛()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.がん等による疼痛.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getがん等による疼痛()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.脱水.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get脱水()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.脱水.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get脱水()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.病態_その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get高い病態_その他()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.病態_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get高い病態_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問診療.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問診療()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問診療.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問診療()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問診療_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問診療_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問診療_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問診療_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目9(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.訪問看護.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問看護()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問看護.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問看護()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問看護_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問看護_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問看護_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問看護_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問リハビリテーション.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問リハビリテーション.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問リハビリテーション_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問リハビリテーション_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.通所リハビリテーション.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get通所リハビリテーション()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.通所リハビリテーション.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get通所リハビリテーション()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.通所リハビリテーション_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get通所リハビリテーション_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.通所リハビリテーション_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get通所リハビリテーション_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.短期入所療養介護.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get短期入所療養介護()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.短期入所療養介護.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get短期入所療養介護()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.短期入所療養介護_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get短期入所療養介護_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.短期入所療養介護_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get短期入所療養介護_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問歯科診療.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問歯科診療()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問歯科診療.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科診療()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目10(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.訪問歯科診療_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問歯科診療_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問歯科診療_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科診療_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問歯科衛生指導.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問歯科衛生指導.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問歯科衛生指導_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問歯科衛生指導_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問薬剤管理指導.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問薬剤管理指導.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問薬剤管理指導_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問薬剤管理指導_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問栄養食事指導.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問栄養食事指導.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.訪問栄養食事指導_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.訪問栄養食事指導_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.その他の医療系のサービス.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他の医療系サービス()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.その他の医療系のサービス.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他の医療系サービス()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.その他の医療系のサービス_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他の医療系サービス_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.その他の医療系のサービス_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他の医療系サービス_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目11(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.介護サービスの留意事項_血圧.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get血圧()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.介護サービスの留意事項_血圧.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get血圧()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.介護サービスの留意事項_嚥下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.介護サービスの留意事項_嚥下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.介護サービスの留意事項_摂食.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get摂食()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.介護サービスの留意事項_摂食.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get摂食()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.介護サービスの留意事項_移動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get移動()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.介護サービスの留意事項_移動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get移動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.感染症の有無.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get感染症()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.感染症の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get感染症()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.失調_不随意運動_体幹_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get体幹_左()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.失調_不随意運動_体幹_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get体幹_左()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.看護職員による相談.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get相談_支援()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.看護職員による相談.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get相談_支援()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.看護職員による相談_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get相談_支援_必要性()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.看護職員による相談_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get相談_支援_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目12(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.麻痺_右上肢_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_右上肢_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_右上肢_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_右上肢_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.麻痺_左上肢.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_左上肢()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_左上肢.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_左上肢()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.麻痺_左上肢_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_左上肢_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_左上肢_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_左上肢_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.麻痺_右下肢.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_右下肢()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_右下肢.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_右下肢()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.麻痺_右下肢_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_右下肢_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_右下肢_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_右下肢_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.麻痺_左下肢.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_左下肢()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_左下肢.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_左下肢()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.麻痺_左下肢_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_左下肢_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_左下肢_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_左下肢_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.麻痺_その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_その他()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.麻痺_その他_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺_その他_程度()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.麻痺_その他_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_その他_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }

        return joho;
    }

    private ShujiiIkenshoJoho set09B意見項目13(ShujiiIkenshoJoho joho,
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping09B.閉じこもり.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get閉じこもり()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.閉じこもり.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get閉じこもり()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.意欲低下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get意欲低下()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.意欲低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get意欲低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.徘徊_可能性が高い病態.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get高い病態_徘徊()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.徘徊_可能性が高い病態.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get高い病態_徘徊()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.低栄養.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get低栄養()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.低栄養.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get低栄養()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.摂食_嚥下機能低下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.摂食_嚥下機能低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (IkenshoKomokuMapping09B.生活機能の維持_改善の見通し.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            // joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(item).build();
        } else {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping09B.生活機能の維持_改善の見通し.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            joho = joho.createBuilderForEdit().setShujiiIkenshoIkenItem(なしデータ).build();
        }
        return joho;
    }

    private int rStringToInt(RString 連番) {
        return Integer.parseInt(連番.toString());
    }

    private boolean isNotEmpty(RString data) {
        return !RString.isNullOrEmpty(data);
    }
}
