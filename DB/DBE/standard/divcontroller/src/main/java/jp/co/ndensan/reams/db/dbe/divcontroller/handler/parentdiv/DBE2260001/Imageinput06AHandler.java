/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2260001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.TorokuData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.dgshinseishaichiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKinyuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping06A;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取込み（規定・規定外）のコントローラクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public class Imageinput06AHandler {

    private static final RString 空白 = RString.EMPTY;
    private List<RString> 記入項目連番レスト;
    private List<RString> 意見項目連番レスト;

    /**
     * 記入項目を設定します。
     *
     * @param joho 要介護認定主治医意見書情報
     * @param row 一覧データ
     * @param data CSVデータ
     * @return 要介護認定主治医意見書情報
     */
    public ShujiiIkenshoJoho set06A項目(ShujiiIkenshoJoho joho, dgshinseishaichiran_Row row, TorokuData data) {
        記入項目連番レスト = new ArrayList<>();
        意見項目連番レスト = new ArrayList<>();
        List<ShujiiIkenshoKinyuItem> itemList = joho.getShujiiIkenshoKinyuItemList();
        List<ShujiiIkenshoIkenItem> 意見項目List = joho.getShujiiIkenshoIkenItemList();
        ShujiiIkenshoJohoBuilder builder = joho.createBuilderForEdit();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(data.getT5101_厚労省IF識別コード())) {
            for (ShujiiIkenshoKinyuItem item : itemList) {
                item = set06A記入項目1(data, item);
                item = set06A記入項目2(data, item);
                item = set06A記入項目3(data, item);
                item = set06A記入項目4(data, item);
                builder.setShujiiIkenshoKinyuItem(item.modifiedModel());
            }
            for (ShujiiIkenshoIkenItem 意見項目 : 意見項目List) {
                意見項目 = set06A意見項目1(data, 意見項目);
                意見項目 = set06A意見項目2(row, data, 意見項目);
                意見項目 = set06A意見項目3(data, 意見項目);
                意見項目 = set06A意見項目5(data, 意見項目);
                意見項目 = set06A意見項目6(data, 意見項目);
                意見項目 = set06A意見項目7(data, 意見項目);
                意見項目 = set06A意見項目8(row, data, 意見項目);
                意見項目 = set06A意見項目9(data, 意見項目);
                意見項目 = set06A意見項目10(data, 意見項目);
                意見項目 = set06A意見項目11(data, 意見項目);
                意見項目 = set06A意見項目12(data, 意見項目);
                builder.setShujiiIkenshoIkenItem(意見項目.modifiedModel());
            }
            set新規の記入項目1(builder, row, data);
            set新規の記入項目2(builder, row, data);
            set新規の記入項目3(builder, row, data);
            set新規の意見項目1(builder, row, data);
            set新規の意見項目2(builder, row, data);
            set新規の意見項目3(builder, row, data);
            set新規の意見項目4(builder, row, data);
            set新規の意見項目5(builder, row, data);
            set新規の意見項目6(builder, row, data);
            set新規の意見項目7(builder, row, data);
            set新規の意見項目8(builder, row, data);
            set新規の意見項目9(builder, row, data);
            set新規の意見項目10(builder, row, data);
            set新規の意見項目11(builder, row, data);
            set新規の意見項目12(builder, row, data);
            set新規の意見項目13(builder, row, data);
        }
        return builder.build();
    }

    private void set新規の記入項目1(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.その他.getコード())) {
            ShujiiIkenshoKinyuItem 新規データ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.その他.getコード()));
            新規データ = 新規データ.createBuilderForEdit().set記入項目(data.getその他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                新規データ = 新規データ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(新規データ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.その他の精神_神経症状.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.その他の精神_神経症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get精神_神経症状()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.専門医受診の有無.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.専門医受診の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get専門科医受診()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.身長.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.身長.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.体重.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.体重.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.四肢欠損.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.四肢欠損.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get四肢欠損()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.麻痺_その他.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.麻痺_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get麻痺_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.筋力の低下.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.筋力の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get筋力低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.関節の拘縮.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.関節の拘縮.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get間接の拘縮()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
    }

    private void set新規の記入項目2(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.関節の痛み.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.関節の痛み.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get間接の痛み()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.じょくそう.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.じょくそう.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get褥瘡()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.その他の皮膚疾患.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.その他の皮膚疾患.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他皮膚疾患()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.栄養_食生活上の留意点.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.栄養_食生活上の留意点.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get現在の栄養状況()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.病態_その他.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.病態_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get高い病態_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.病態_対処方針.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.病態_対処方針.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.その他の医療系のサービス.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.その他の医療系のサービス.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他の医療系サービス()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.介護サービスの留意事項_血圧.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.介護サービスの留意事項_血圧.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get血圧()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.介護サービスの留意事項_嚥下.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.介護サービスの留意事項_嚥下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get嚥下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
    }

    private void set新規の記入項目3(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.介護サービスの留意事項_摂食.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.介護サービスの留意事項_摂食.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get摂食()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.介護サービスの留意事項_移動.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.介護サービスの留意事項_移動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get移動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.関節の痛み.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.介護サービスの留意事項_運動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get運動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.関節の痛み.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.介護サービスの留意事項_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping06A.関節の痛み.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping06A.感染症の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get感染症()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
    }

    private void set新規の意見項目1(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.点滴の管理.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.点滴の管理.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get点滴の管理()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.中心静脈栄養.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.中心静脈栄養.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get中心静脈栄養()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.透析.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.透析.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get透折()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.ストーマの処置.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.ストーマの処置.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getストーマの処置()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.酸素療法.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.酸素療法.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get酸素療法()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.レスピレーター.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.レスピレーター.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getレスピレーター()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.気管切開の処置.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.気管切開の処置.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get気管切開の処置()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.疼痛の看護.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.疼痛の看護.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get疼痛の看護()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.経管栄養.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.経管栄養.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get経管栄養()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目2(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.モニター測定.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.モニター測定.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getモニター測定()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.じょくそうの処置.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.じょくそうの処置.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥痩の処置()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.カテーテル.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.カテーテル.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getカテーテル()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.寝たきり度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.寝たきり度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get障害高齢者の自立度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(row.getNinchishoNichijoSeikatsuJiritsudoCode().getSelectedKey()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.短期記憶.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.短期記憶.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(row.getTankiKioku().getSelectedKey()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.認知能力.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.認知能力.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(row.getNintiNoryoku().getSelectedKey()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.伝達能力.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.伝達能力.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(row.getDentatsuNoryoku().getSelectedKey()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.認知症の周辺症状.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.認知症の周辺症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get問題行動の有無()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目3(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.幻視_幻聴.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.幻視_幻聴.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get幻視_幻聴()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.妄想.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.妄想.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get妄想()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.昼夜逆転.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.昼夜逆転.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get昼夜逆転()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.暴言.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.暴言.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get暴言()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.暴行.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.暴行.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get暴行()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.介護への抵抗.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.介護への抵抗.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get介護への抵抗()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.徘徊_認知症の周辺症状.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.徘徊_認知症の周辺症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get徘徊()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.火の不始末.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.火の不始末.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get火の不始末()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.過去6カ月の体重の変化.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.過去6カ月の体重の変化.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get過去6ヶ月の体重の変化()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目4(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.不潔行為.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.不潔行為.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get不潔行為()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.異食行動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.異食行動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get異食行動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.性的問題行動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.性的問題行動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get性的問題行動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.その他.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.その他の精神_神経症状.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.その他の精神_神経症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get精神_神経症状()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.専門医受診の有無.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.専門医受診の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get専門科医受診()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.利き腕.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.利き腕.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get利き腕()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.四肢欠損.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.四肢欠損.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get四肢欠損()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目5(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_右上肢.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_右上肢.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_右上肢()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.筋力の低下.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.筋力の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get筋力低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.筋力の低下_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.筋力の低下_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get筋力低下_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.じょくそう.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.じょくそう.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥痩()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.じょくそう_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.じょくそう_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥痩_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.その他の皮膚疾患.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.その他の皮膚疾患.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他皮膚疾患()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.その他の皮膚疾患_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.その他の皮膚疾患_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他皮膚疾患_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.関節の拘縮.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.関節の拘縮.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get間接の拘縮()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.関節の拘縮_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.関節の拘縮_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get間接の拘縮_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目6(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.関節の痛み.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.関節の痛み.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get間接の痛み()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.関節の痛み_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.関節の痛み_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get間接の痛み_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.屋外歩行.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.屋外歩行.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get屋外歩行()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.車いすの使用.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.車いすの使用.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get車いすの使用()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.歩行補助具_装具の使用_用いていない.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.歩行補助具_装具の使用_用いていない.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋外で使用.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋外で使用.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用_屋外()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋内で使用.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋内で使用.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用_屋内()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.失調_不随意運動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.失調_不随意運動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get失調_不随意運動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.失調_不随意運動_上肢_左.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.失調_不随意運動_上肢_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get上肢_左()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目7(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.失調_不随意運動_体幹_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.失調_不随意運動_体幹_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get体幹_右()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.失調_不随意運動_下肢_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.失調_不随意運動_下肢_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get下肢_右()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.失調_不随意運動_下肢_左.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.失調_不随意運動_下肢_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get下肢_左()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.尿失禁.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.尿失禁.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get尿失禁()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.転倒_骨折.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.転倒_骨折.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get転倒_骨折()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.移動能力の低下.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.移動能力の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get移動能力の低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.褥瘡.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.褥瘡.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥瘡()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.食事行為.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.食事行為.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(row.getShokujiKoi().getSelectedKey()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.現在の栄養状態.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.現在の栄養状態.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get現在の栄養状況()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目8(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.易感染性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.易感染性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.心肺機能の低下.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.心肺機能の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get心肺機能の低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.がん等による疼痛.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.がん等による疼痛.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getがん等による疼痛()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.脱水.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.脱水.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get脱水()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.病態_その他.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.病態_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get高い病態_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問診療.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問診療.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問診療()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問診療_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問診療_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問診療_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問看護.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問看護.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問看護()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問看護_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問看護_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問看護_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目10(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問歯科衛生指導_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問歯科衛生指導_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問薬剤管理指導.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問薬剤管理指導.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問薬剤管理指導_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問薬剤管理指導_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問栄養食事指導.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問栄養食事指導.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問栄養食事指導_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問栄養食事指導_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.その他の医療系のサービス.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.その他の医療系のサービス.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他の医療系サービス()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.その他の医療系のサービス_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.その他の医療系のサービス_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他の医療系サービス_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.介護サービスの留意事項_血圧.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.介護サービスの留意事項_血圧.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get血圧()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.介護サービスの留意事項_嚥下.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.介護サービスの留意事項_嚥下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目9(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問リハビリテーション.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問リハビリテーション.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問リハビリテーション_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問リハビリテーション_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.通所リハビリテーション.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.通所リハビリテーション.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get通所リハビリテーション()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.通所リハビリテーション_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.通所リハビリテーション_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get通所リハビリテーション_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.短期入所療養介護.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.短期入所療養介護.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get短期入所療養介護()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.短期入所療養介護_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.短期入所療養介護_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get短期入所療養介護_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問歯科診療.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問歯科診療.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科診療()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問歯科診療_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問歯科診療_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科診療_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.訪問歯科衛生指導.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.訪問歯科衛生指導.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目11(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.介護サービスの留意事項_摂食.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.介護サービスの留意事項_摂食.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get摂食()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.介護サービスの留意事項_移動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.介護サービスの留意事項_移動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get移動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.感染症の有無.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.感染症の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get感染症()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.失調_不随意運動_体幹_左.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.失調_不随意運動_体幹_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get体幹_左()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_右上肢_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_右上肢_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_右上肢_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_左上肢.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_左上肢.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_左上肢()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_左上肢_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_左上肢_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_左上肢_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目12(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_右下肢_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_右下肢_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_右下肢_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_左下肢.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_左下肢.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_左下肢()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_左下肢_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_左下肢_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_左下肢_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_その他.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_その他_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_その他_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_その他_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.閉じこもり.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.閉じこもり.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get閉じこもり()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.意欲低下.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.意欲低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get意欲低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.徘徊_可能性が高い病態.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.徘徊_可能性が高い病態.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get高い病態_徘徊()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.低栄養.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.低栄養.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get低栄養()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目13(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.摂食_嚥下機能低下.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.摂食_嚥下機能低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.生活機能の維持_改善の見通し.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.生活機能の維持_改善の見通し.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.麻痺_右下肢.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.麻痺_右下肢.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺_右下肢()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.失調_不随意運動_上肢_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.失調_不随意運動_上肢_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get上肢_右()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping06A.介護サービスの留意事項_運動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping06A.介護サービスの留意事項_運動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get運動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private ShujiiIkenshoKinyuItem set06A記入項目1(
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping06A.その他.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.getその他()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.その他.getコード());
        }
        if (IkenshoKinyuMapping06A.その他の精神_神経症状.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get精神_神経症状()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.その他の精神_神経症状.getコード());
        }
        if (IkenshoKinyuMapping06A.専門医受診の有無.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get専門科医受診()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.専門医受診の有無.getコード());
        }
        if (IkenshoKinyuMapping06A.身長.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(空白).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.身長.getコード());
        }
        if (IkenshoKinyuMapping06A.体重.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(空白).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.体重.getコード());
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem set06A記入項目2(
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping06A.四肢欠損.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get四肢欠損()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.四肢欠損.getコード());
        }
        if (IkenshoKinyuMapping06A.麻痺_その他.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get麻痺_その他()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.麻痺_その他.getコード());
        }
        if (IkenshoKinyuMapping06A.筋力の低下.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get筋力低下()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.筋力の低下.getコード());
        }
        if (IkenshoKinyuMapping06A.関節の拘縮.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get間接の拘縮()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.関節の拘縮.getコード());
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem set06A記入項目3(
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping06A.関節の痛み.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get間接の痛み()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.関節の痛み.getコード());
        }
        if (IkenshoKinyuMapping06A.じょくそう.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get褥瘡()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.じょくそう.getコード());
        }
        if (IkenshoKinyuMapping06A.その他の皮膚疾患.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.getその他皮膚疾患()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.その他の皮膚疾患.getコード());
        }
        if (IkenshoKinyuMapping06A.栄養_食生活上の留意点.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get現在の栄養状況()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.栄養_食生活上の留意点.getコード());
        }
        if (IkenshoKinyuMapping06A.病態_その他.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get高い病態_その他()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.病態_その他.getコード());
        }
        if (IkenshoKinyuMapping06A.病態_対処方針.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(空白).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.病態_対処方針.getコード());
        }
        if (IkenshoKinyuMapping06A.その他の医療系のサービス.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.getその他の医療系サービス()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.その他の医療系のサービス.getコード());
        }
        if (IkenshoKinyuMapping06A.介護サービスの留意事項_血圧.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get血圧()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.介護サービスの留意事項_血圧.getコード());
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem set06A記入項目4(
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping06A.介護サービスの留意事項_嚥下.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get嚥下()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.介護サービスの留意事項_嚥下.getコード());
        }
        if (IkenshoKinyuMapping06A.介護サービスの留意事項_摂食.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get摂食()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.介護サービスの留意事項_摂食.getコード());
        }
        if (IkenshoKinyuMapping06A.介護サービスの留意事項_移動.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get移動()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.介護サービスの留意事項_移動.getコード());
        }
        if (IkenshoKinyuMapping06A.介護サービスの留意事項_運動.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get運動()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.介護サービスの留意事項_運動.getコード());
        }
        if (IkenshoKinyuMapping06A.介護サービスの留意事項_その他.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(空白).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.介護サービスの留意事項_その他.getコード());
        }
        if (IkenshoKinyuMapping06A.感染症の有無.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set記入項目(data.get感染症()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping06A.感染症の有無.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目1(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.点滴の管理.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get点滴の管理()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.点滴の管理.getコード());
        }
        if (IkenshoKomokuMapping06A.中心静脈栄養.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get中心静脈栄養()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.中心静脈栄養.getコード());
        }
        if (IkenshoKomokuMapping06A.透析.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get透折()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.透析.getコード());
        }
        if (IkenshoKomokuMapping06A.ストーマの処置.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getストーマの処置()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.ストーマの処置.getコード());
        }
        if (IkenshoKomokuMapping06A.酸素療法.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get酸素療法()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.酸素療法.getコード());
        }
        if (IkenshoKomokuMapping06A.レスピレーター.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getレスピレーター()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.レスピレーター.getコード());
        }
        if (IkenshoKomokuMapping06A.気管切開の処置.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get気管切開の処置()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.気管切開の処置.getコード());
        }
        if (IkenshoKomokuMapping06A.疼痛の看護.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get疼痛の看護()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.疼痛の看護.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目2(
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.経管栄養.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get経管栄養()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.経管栄養.getコード());
        }
        if (IkenshoKomokuMapping06A.モニター測定.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getモニター測定()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.モニター測定.getコード());
        }
        if (IkenshoKomokuMapping06A.じょくそうの処置.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get褥痩の処置()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.じょくそうの処置.getコード());
        }
        if (IkenshoKomokuMapping06A.カテーテル.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getカテーテル()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.カテーテル.getコード());
        }
        if (IkenshoKomokuMapping06A.寝たきり度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get障害高齢者の自立度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.寝たきり度.getコード());
        }
        if (IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(row.getNinchishoNichijoSeikatsuJiritsudoCode().getSelectedKey()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード());
        }
        if (IkenshoKomokuMapping06A.短期記憶.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(row.getTankiKioku().getSelectedKey()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.短期記憶.getコード());
        }
        if (IkenshoKomokuMapping06A.認知能力.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(row.getNintiNoryoku().getSelectedKey()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.認知能力.getコード());
        }
        if (IkenshoKomokuMapping06A.伝達能力.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(row.getDentatsuNoryoku().getSelectedKey()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.伝達能力.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目3(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.認知症の周辺症状.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get問題行動の有無()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.認知症の周辺症状.getコード());
        }
        if (IkenshoKomokuMapping06A.幻視_幻聴.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get幻視_幻聴()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.幻視_幻聴.getコード());
        }
        if (IkenshoKomokuMapping06A.妄想.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get妄想()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.妄想.getコード());
        }
        if (IkenshoKomokuMapping06A.昼夜逆転.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get昼夜逆転()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.昼夜逆転.getコード());
        }
        if (IkenshoKomokuMapping06A.暴言.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get暴言()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.暴言.getコード());
        }
        if (IkenshoKomokuMapping06A.暴行.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get暴行()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.暴行.getコード());
        }
        if (IkenshoKomokuMapping06A.介護への抵抗.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get介護への抵抗()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.介護への抵抗.getコード());
        }
        if (IkenshoKomokuMapping06A.徘徊_認知症の周辺症状.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get徘徊()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.徘徊_認知症の周辺症状.getコード());
        }
        if (IkenshoKomokuMapping06A.火の不始末.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get火の不始末()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.火の不始末.getコード());
        }
        if (IkenshoKomokuMapping06A.過去6カ月の体重の変化.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get過去6ヶ月の体重の変化()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.過去6カ月の体重の変化.getコード());

        }
        if (IkenshoKomokuMapping06A.不潔行為.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get不潔行為()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.不潔行為.getコード());
        }
        if (IkenshoKomokuMapping06A.異食行動.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get異食行動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.異食行動.getコード());
        }
        if (IkenshoKomokuMapping06A.性的問題行動.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get性的問題行動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.性的問題行動.getコード());
        }
        if (IkenshoKomokuMapping06A.その他.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getその他()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.その他.getコード());
        }
        if (IkenshoKomokuMapping06A.その他の精神_神経症状.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get精神_神経症状()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.その他の精神_神経症状.getコード());
        }
        if (IkenshoKomokuMapping06A.専門医受診の有無.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get専門科医受診()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.専門医受診の有無.getコード());
        }
        if (IkenshoKomokuMapping06A.利き腕.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get利き腕()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.利き腕.getコード());
        }
        if (IkenshoKomokuMapping06A.四肢欠損.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get四肢欠損()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.四肢欠損.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目5(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.麻痺.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺.getコード());
        }
        if (IkenshoKomokuMapping06A.麻痺_右上肢.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_右上肢()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_右上肢.getコード());
        }
        if (IkenshoKomokuMapping06A.筋力の低下.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get筋力低下()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.筋力の低下.getコード());
        }
        if (IkenshoKomokuMapping06A.筋力の低下_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get筋力低下_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.筋力の低下_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.じょくそう.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get褥痩()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.じょくそう.getコード());
        }
        if (IkenshoKomokuMapping06A.じょくそう_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get褥痩_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.じょくそう_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.その他の皮膚疾患.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getその他皮膚疾患()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.その他の皮膚疾患.getコード());
        }
        if (IkenshoKomokuMapping06A.その他の皮膚疾患_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getその他皮膚疾患_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.その他の皮膚疾患_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.関節の拘縮.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get間接の拘縮()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.関節の拘縮.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目6(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.関節の拘縮_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get間接の拘縮_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.関節の拘縮_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.関節の痛み.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get間接の痛み()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.関節の痛み.getコード());
        }
        if (IkenshoKomokuMapping06A.関節の痛み_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get間接の痛み_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.関節の痛み_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.屋外歩行.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get屋外歩行()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.屋外歩行.getコード());
        }
        if (IkenshoKomokuMapping06A.車いすの使用.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get車いすの使用()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.車いすの使用.getコード());
        }
        if (IkenshoKomokuMapping06A.歩行補助具_装具の使用_用いていない.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.歩行補助具_装具の使用_用いていない.getコード());
        }
        if (IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋外で使用.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用_屋外()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋外で使用.getコード());
        }
        if (IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋内で使用.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get歩行補助具_装具の使用_屋内()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋内で使用.getコード());
        }
        if (IkenshoKomokuMapping06A.失調_不随意運動.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get失調_不随意運動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.失調_不随意運動.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目7(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.失調_不随意運動_上肢_右.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get上肢_右()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.失調_不随意運動_上肢_右.getコード());
        }
        if (IkenshoKomokuMapping06A.失調_不随意運動_上肢_左.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get上肢_左()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.失調_不随意運動_上肢_左.getコード());
        }
        if (IkenshoKomokuMapping06A.失調_不随意運動_体幹_右.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get体幹_右()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.失調_不随意運動_体幹_右.getコード());
        }
        if (IkenshoKomokuMapping06A.失調_不随意運動_下肢_右.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get下肢_右()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.失調_不随意運動_下肢_右.getコード());
        }
        if (IkenshoKomokuMapping06A.失調_不随意運動_下肢_左.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get下肢_左()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.失調_不随意運動_下肢_左.getコード());
        }
        if (IkenshoKomokuMapping06A.尿失禁.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get尿失禁()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.尿失禁.getコード());
        }
        if (IkenshoKomokuMapping06A.転倒_骨折.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get転倒_骨折()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.転倒_骨折.getコード());
        }
        if (IkenshoKomokuMapping06A.移動能力の低下.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get移動能力の低下()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.移動能力の低下.getコード());
        }
        if (IkenshoKomokuMapping06A.褥瘡.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get褥瘡()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.褥瘡.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目8(
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.食事行為.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(row.getShokujiKoi().getSelectedKey()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.食事行為.getコード());
        }
        if (IkenshoKomokuMapping06A.現在の栄養状態.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get現在の栄養状況()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.現在の栄養状態.getコード());
        }
        if (IkenshoKomokuMapping06A.易感染性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.易感染性.getコード());
        }
        if (IkenshoKomokuMapping06A.心肺機能の低下.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get心肺機能の低下()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.心肺機能の低下.getコード());
        }
        if (IkenshoKomokuMapping06A.がん等による疼痛.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getがん等による疼痛()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.がん等による疼痛.getコード());
        }
        if (IkenshoKomokuMapping06A.脱水.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get脱水()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.脱水.getコード());
        }
        if (IkenshoKomokuMapping06A.病態_その他.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get高い病態_その他()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.病態_その他.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問診療.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問診療()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問診療.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問診療_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問診療_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問診療_必要性.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目9(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.訪問看護.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問看護()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問看護.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問看護_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問看護_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問看護_必要性.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問リハビリテーション.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問リハビリテーション.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問リハビリテーション_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問リハビリテーション_必要性.getコード());
        }
        if (IkenshoKomokuMapping06A.通所リハビリテーション.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get通所リハビリテーション()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.通所リハビリテーション.getコード());
        }
        if (IkenshoKomokuMapping06A.通所リハビリテーション_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get通所リハビリテーション_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.通所リハビリテーション_必要性.getコード());
        }
        if (IkenshoKomokuMapping06A.短期入所療養介護.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get短期入所療養介護()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.短期入所療養介護.getコード());
        }
        if (IkenshoKomokuMapping06A.短期入所療養介護_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get短期入所療養介護_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.短期入所療養介護_必要性.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問歯科診療.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問歯科診療()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問歯科診療.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目10(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.訪問歯科診療_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問歯科診療_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問歯科診療_必要性.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問歯科衛生指導.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問歯科衛生指導.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問歯科衛生指導_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問歯科衛生指導_必要性.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問薬剤管理指導.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問薬剤管理指導.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問薬剤管理指導_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問薬剤管理指導_必要性.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問栄養食事指導.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問栄養食事指導.getコード());
        }
        if (IkenshoKomokuMapping06A.訪問栄養食事指導_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.訪問栄養食事指導_必要性.getコード());
        }
        if (IkenshoKomokuMapping06A.その他の医療系のサービス.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getその他の医療系サービス()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.その他の医療系のサービス.getコード());
        }
        if (IkenshoKomokuMapping06A.その他の医療系のサービス_必要性.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.getその他の医療系サービス_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.その他の医療系のサービス_必要性.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目11(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.介護サービスの留意事項_血圧.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get血圧()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.介護サービスの留意事項_血圧.getコード());
        }
        if (IkenshoKomokuMapping06A.介護サービスの留意事項_嚥下.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.介護サービスの留意事項_嚥下.getコード());
        }
        if (IkenshoKomokuMapping06A.介護サービスの留意事項_摂食.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get摂食()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.介護サービスの留意事項_摂食.getコード());
        }
        if (IkenshoKomokuMapping06A.介護サービスの留意事項_移動.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get移動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.介護サービスの留意事項_移動.getコード());
        }
        if (IkenshoKomokuMapping06A.感染症の有無.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get感染症()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.感染症の有無.getコード());
        }
        if (IkenshoKomokuMapping06A.失調_不随意運動_体幹_左.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get体幹_左()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.失調_不随意運動_体幹_左.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set06A意見項目12(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping06A.麻痺_右上肢_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_右上肢_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_右上肢_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.麻痺_左上肢.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_左上肢()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_左上肢.getコード());
        }
        if (IkenshoKomokuMapping06A.麻痺_左上肢_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_左上肢_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_左上肢_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.麻痺_右下肢.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_右下肢()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_右下肢.getコード());
        }
        if (IkenshoKomokuMapping06A.麻痺_右下肢_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_右下肢_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_右下肢_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.麻痺_左下肢.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_左下肢()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_左下肢.getコード());
        }
        if (IkenshoKomokuMapping06A.麻痺_左下肢_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_左下肢_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_左下肢_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.麻痺_その他.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_その他()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_その他.getコード());
        }
        if (IkenshoKomokuMapping06A.麻痺_その他_程度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get麻痺_その他_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.麻痺_その他_程度.getコード());
        }
        if (IkenshoKomokuMapping06A.閉じこもり.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get閉じこもり()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.閉じこもり.getコード());
        }
        if (IkenshoKomokuMapping06A.意欲低下.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get意欲低下()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.意欲低下.getコード());
        }
        if (IkenshoKomokuMapping06A.徘徊_可能性が高い病態.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get高い病態_徘徊()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.徘徊_可能性が高い病態.getコード());
        }
        if (IkenshoKomokuMapping06A.低栄養.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get低栄養()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.低栄養.getコード());
        }
        if (IkenshoKomokuMapping06A.摂食_嚥下機能低下.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.摂食_嚥下機能低下.getコード());
        }
        if (IkenshoKomokuMapping06A.生活機能の維持_改善の見通し.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.生活機能の維持_改善の見通し.getコード());
        }
        if (IkenshoKomokuMapping06A.介護サービスの留意事項_運動.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set意見項目(data.get運動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping06A.介護サービスの留意事項_運動.getコード());
        }
        return item;
    }

    private int rStringToInt(RString 連番) {
        return Integer.parseInt(連番.toString());
    }

    private boolean isNotEmpty(RString data) {
        return !RString.isNullOrEmpty(data);
    }
}
