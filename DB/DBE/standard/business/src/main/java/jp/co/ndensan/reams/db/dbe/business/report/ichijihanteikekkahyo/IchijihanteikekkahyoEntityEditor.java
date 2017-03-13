/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chkichijihanteikekka.ChkIchijiHanteiKekkaBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser33;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser34;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.GenzainoJokyoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.image.BarImageType;
import jp.co.ndensan.reams.uz.uza.image.EachBarImage;
import jp.co.ndensan.reams.uz.uza.image.StackBarImage;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * IchijihanteikekkahyoEntityの編集クラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class IchijihanteikekkahyoEntityEditor {

    private static final RString 判定結果コード09 = new RString("09");
    private static final RString 判定結果コード06 = new RString("06");
    private static final RString 判定結果コード02 = new RString("02");
    private static final RString 判定結果コード99 = new RString("99");
    private static final RString 識別コード09B = new RString("09B");
    private static final RString 識別コード06A = new RString("06A");
    private static final RString 識別コード02A = new RString("02A");
    private static final RString 識別コード09A = new RString("09A");
    private static final RString 識別コード99A = new RString("99A");
    private static final RString マスキング_あり = new RString("1");
    private static final RString マスキング_調査員名 = new RString("2");
    private static final RString 印刷する = new RString("1");
    private static final RString 印刷しない = new RString("2");
    private static final RString 差分のみ印刷 = new RString("3");
    private static final RString 印字する = new RString("1");
    private static final RString 主事意見_記載なし = new RString("9");
    private static final RString 認定情報_事務局用 = new RString("認定情報(事務局用)");
    private static final int 連番1 = 1;
    private static final int 連番2 = 2;
    private static final int 連番3 = 3;
    private static final int 連番4 = 4;
    private static final int 連番5 = 5;
    private static final int 連番6 = 6;
    private static final int 連番7 = 7;
    private static final int 連番8 = 8;
    private static final int 連番9 = 9;
    private static final int 時間算出用数値_10 = 10;
    private static final int 連番10 = 10;
    private static final int 連番11 = 11;
    private static final int 連番12 = 12;
    private static final int 連番13 = 13;
    private static final int 連番14 = 14;
    private static final int 連番15 = 15;
    private static final int 連番16 = 16;
    private static final int 連番17 = 17;
    private static final int 連番18 = 18;
    private static final int 連番19 = 19;
    private static final int 連番20 = 20;
    private static final int 連番21 = 21;
    private static final int 連番22 = 22;
    private static final int 連番23 = 23;
    private static final int 連番24 = 24;
    private static final int 連番25 = 25;
    private static final int 連番26 = 26;
    private static final int 連番27 = 27;
    private static final int 連番28 = 28;
    private static final int 連番29 = 29;
    private static final int 連番30 = 30;
    private static final int 連番31 = 31;
    private static final int 連番32 = 32;
    private static final int 連番33 = 33;
    private static final int 連番34 = 34;
    private static final int 連番35 = 35;
    private static final int 連番36 = 36;
    private static final int 連番37 = 37;
    private static final int 連番38 = 38;
    private static final int 連番39 = 39;
    private static final int 連番40 = 40;
    private static final int 連番41 = 41;
    private static final int 連番42 = 42;
    private static final int 連番43 = 43;
    private static final int 連番44 = 44;
    private static final int 連番45 = 45;
    private static final int 連番46 = 46;
    private static final int 連番47 = 47;
    private static final int 連番48 = 48;
    private static final int 連番49 = 49;
    private static final int 連番50 = 50;
    private static final int 連番51 = 51;
    private static final int 連番52 = 52;
    private static final int 連番53 = 53;
    private static final int 連番54 = 54;
    private static final int 連番55 = 55;
    private static final int 連番56 = 56;
    private static final int 連番57 = 57;
    private static final int 連番58 = 58;
    private static final int 連番59 = 59;
    private static final int 連番60 = 60;
    private static final int 連番61 = 61;
    private static final int 連番62 = 62;
    private static final int 連番63 = 63;
    private static final int 連番64 = 64;
    private static final int 連番65 = 65;
    private static final int 連番66 = 66;
    private static final int 連番67 = 67;
    private static final int 連番68 = 68;
    private static final int 連番69 = 69;
    private static final int 連番70 = 70;
    private static final int 連番71 = 71;
    private static final int 連番72 = 72;
    private static final int 連番73 = 73;
    private static final int 連番74 = 74;
    private static final int 連番75 = 75;
    private static final int 連番76 = 76;
    private static final int 連番77 = 77;
    private static final int 連番78 = 78;
    private static final int 連番79 = 79;
    private static final int 連番80 = 80;
    private static final int 連番81 = 81;
    private static final int 連番82 = 82;
    private static final int 連番83 = 83;
    private static final int 連番84 = 84;
    private static final int COUNT_15 = 15;
    private static final int COUNT_20 = 20;
    private static final int IMAGE_WIDTH = 540;
    private static final int IMAGE_HEIGHT = 40;
    private static final int 合議体番号_LENGTH = 6;
    private static final RString アスタリスク = new RString("* * * * * *");

    private IchijihanteikekkahyoEntityEditor() {
    }

    /**
     * IchijihanteikekkahyoEntityを編集します。
     *
     * @param yokaigoNinteiJohoTeikyoEntity YokaigoNinteiJohoTeikyoEntity
     * @param 認定調査特記事項番号List 認定調査特記事項番号List
     * @param 認定調査票サービス状況List 認定調査票サービス状況List
     * @param 認定調査票サービス状況フラグList 認定調査票サービス状況フラグList
     * @param 認定調査票調査項目List 認定調査票調査項目List
     * @param 前回認定調査票調査項目List 前回認定調査票調査項目List
     * @param 主治医意見書意見項目List 主治医意見書意見項目List
     * @param 前回主治医意見書意見項目List 前回主治医意見書意見項目List
     * @param 特記事項符号印刷有無
     * @param 正常選択肢印刷有無 正常選択肢印刷有無
     * @param 前回との結果比較印刷有無
     * @param 認定調査前回結果印刷有無 認定調査前回結果印刷有無
     * @param 前回正常選択肢印刷有無
     * @param 一次判定結果マスキング区分 一次判定結果マスキング区分
     * @return IchijihanteikekkahyoEntity
     */
    public static IchijihanteikekkahyoEntity edit(YokaigoNinteiJohoTeikyoEntity yokaigoNinteiJohoTeikyoEntity,
            List<RString> 認定調査特記事項番号List,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoChosaItem> 前回認定調査票調査項目List,
            List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List,
            List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List,
            RString 特記事項符号印刷有無,
            RString 正常選択肢印刷有無,
            RString 前回との結果比較印刷有無,
            RString 認定調査前回結果印刷有無,
            RString 前回正常選択肢印刷有無,
            RString 一次判定結果マスキング区分) {
        List<RString> EMPTYLIST = new ArrayList<>();

        IchijihanteikekkahyoEntity ichijihanteikekkahyoEntity = setBodyItem(yokaigoNinteiJohoTeikyoEntity, 一次判定結果マスキング区分);

        ichijihanteikekkahyoEntity.set日常生活自立度リスト(
                ChkIchijiHanteiKekkaBusiness.set日常生活自立度リスト(認定調査特記事項番号List, ichijihanteikekkahyoEntity));
        ichijihanteikekkahyoEntity.set意見書認知症高齢者自立度(ChkIchijiHanteiKekkaBusiness.set意見書認知症(
                toDbT5304ShujiiIkenshoIkenItemEntity(主治医意見書意見項目List), ichijihanteikekkahyoEntity));

        //サービス状況
        ChkIchijiHanteiKekkaBusiness.setサービス状況(認定調査票サービス状況List, 認定調査票サービス状況フラグList, ichijihanteikekkahyoEntity);

        //特記事項に対応する項目があるとき※を印字する
        if (印字する.equals(特記事項符号印刷有無)) {
            ichijihanteikekkahyoEntity.set身体機能_起居動作リスト(
                    ChkIchijiHanteiKekkaBusiness.set身体機能_起居動作リスト(認定調査特記事項番号List, ichijihanteikekkahyoEntity));
            ichijihanteikekkahyoEntity.set生活機能リスト(
                    ChkIchijiHanteiKekkaBusiness.set生活機能リスト(認定調査特記事項番号List, ichijihanteikekkahyoEntity));
            ichijihanteikekkahyoEntity.set認知機能リスト(
                    ChkIchijiHanteiKekkaBusiness.set認知機能リスト(認定調査特記事項番号List, ichijihanteikekkahyoEntity));
            ichijihanteikekkahyoEntity.set精神_行動障害リスト(
                    ChkIchijiHanteiKekkaBusiness.set精神_行動障害リスト(認定調査特記事項番号List, ichijihanteikekkahyoEntity));
            ichijihanteikekkahyoEntity.set社会生活への適応リスト(
                    ChkIchijiHanteiKekkaBusiness.set社会生活への適応リスト(認定調査特記事項番号List, ichijihanteikekkahyoEntity));
        } else {
            ichijihanteikekkahyoEntity.set身体機能_起居動作リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set生活機能リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set認知機能リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set精神_行動障害リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set社会生活への適応リスト(EMPTYLIST);
        }

        //今回の調査結果
        ichijihanteikekkahyoEntity.set主治医意見書項目1リスト(
                set主治医意見書項目1リスト(主治医意見書意見項目List, 正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set身体機能_起居動作1リスト(
                set身体機能_起居動作1リスト(認定調査票調査項目List, 正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set生活機能1リスト(
                set生活機能1リスト(認定調査票調査項目List, 正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set認知機能1リスト(
                set認知機能1リスト(認定調査票調査項目List, 正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set精神_行動障害1リスト(
                set精神_行動障害1リスト(認定調査票調査項目List, 正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set社会生活への適応1リスト(
                set社会生活への適応1リスト(認定調査票調査項目List, 正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード()));

        //前回調査結果と比較し改善している(▽)・悪化している(▲)を印字
        //またそれが何段階変わったか(n=数字)を印字
        if (印字する.equals(前回との結果比較印刷有無)) {
            ichijihanteikekkahyoEntity.set主治医意見書項目2リスト(set主治医意見書項目2リスト(主治医意見書意見項目List, 前回主治医意見書意見項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
            ichijihanteikekkahyoEntity.set主治医意見書項目3リスト(set主治医意見書項目3リスト(主治医意見書意見項目List, 前回主治医意見書意見項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));

            ichijihanteikekkahyoEntity.set身体機能_起居動作2リスト(set身体機能_起居動作2リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
            ichijihanteikekkahyoEntity.set身体機能_起居動作3リスト(set身体機能_起居動作3リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));

            ichijihanteikekkahyoEntity.set生活機能2リスト(set生活機能2リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
            ichijihanteikekkahyoEntity.set生活機能3リスト(set生活機能3リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));

            ichijihanteikekkahyoEntity.set認知機能2リスト(set認知機能2リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
            ichijihanteikekkahyoEntity.set認知機能3リスト(set認知機能3リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));

            ichijihanteikekkahyoEntity.set精神_行動障害2リスト(set精神_行動障害2リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
            ichijihanteikekkahyoEntity.set精神_行動障害3リスト(set精神_行動障害3リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));

            ichijihanteikekkahyoEntity.set社会生活への適応2リスト(set社会生活への適応2リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
            ichijihanteikekkahyoEntity.set社会生活への適応3リスト(set社会生活への適応3リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                    yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
        } else {
            ichijihanteikekkahyoEntity.set主治医意見書項目2リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set主治医意見書項目3リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set身体機能_起居動作2リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set身体機能_起居動作3リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set生活機能2リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set生活機能3リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set認知機能2リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set認知機能3リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set精神_行動障害2リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set精神_行動障害3リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set社会生活への適応2リスト(EMPTYLIST);
            ichijihanteikekkahyoEntity.set社会生活への適応3リスト(EMPTYLIST);
        }

        //前回の調査結果
        ichijihanteikekkahyoEntity.set主治医意見書項目4リスト(set主治医意見書項目4リスト(主治医意見書意見項目List, 前回主治医意見書意見項目List,
                認定調査前回結果印刷有無, 前回正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(),
                yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set身体機能_起居動作4リスト(set身体機能_起居動作4リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                認定調査前回結果印刷有無, 前回正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(),
                yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set生活機能4リスト(set生活機能4リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                認定調査前回結果印刷有無, 前回正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(),
                yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set認知機能4リスト(set認知機能4リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                認定調査前回結果印刷有無, 前回正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(),
                yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set精神_行動障害4リスト(set精神_行動障害4リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                認定調査前回結果印刷有無, 前回正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(),
                yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set社会生活への適応4リスト(set社会生活への適応4リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                認定調査前回結果印刷有無, 前回正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(),
                yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));

        //特別な医療
        ichijihanteikekkahyoEntity.set特別な医療1リスト(
                ChkIchijiHanteiKekkaBusiness.set特別な医療1リスト(認定調査特記事項番号List, ichijihanteikekkahyoEntity));
        ichijihanteikekkahyoEntity.set特別な医療2リスト(
                ChkIchijiHanteiKekkaBusiness.set特別な医療2リスト(認定調査特記事項番号List, ichijihanteikekkahyoEntity));
        ichijihanteikekkahyoEntity.set特別な医療3_1リスト(
                set特別な医療3_1リスト(認定調査票調査項目List, 正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set特別な医療3_2リスト(set特別な医療3_2リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set特別な医療4_1リスト(set特別な医療4_1リスト(認定調査票調査項目List,
                正常選択肢印刷有無, yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード()));
        ichijihanteikekkahyoEntity.set特別な医療4_2リスト(set特別な医療4_2リスト(認定調査票調査項目List, 前回認定調査票調査項目List,
                yokaigoNinteiJohoTeikyoEntity.get厚労省IF識別コード(), yokaigoNinteiJohoTeikyoEntity.get前回厚労省IF識別コード()));

        return ichijihanteikekkahyoEntity;
    }

    private static RString get調査連番(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).get調査項目())) {
            前回調査 = 前回調査項目.get(連番).get調査項目();
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get調査連番(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_認知機能(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get状況改善(List<ShujiiIkenshoIkenItem> 調査項目,
            List<ShujiiIkenshoIkenItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get意見項目())) {
            今回調査 = 調査項目.get(連番).get意見項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change主治医差分連番(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get意見項目())) {
                前回調査 = 前回調査項目.get(前回連番).get意見項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査) || 主事意見_記載なし.equals(今回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get状況結果(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).get調査項目())) {
            前回調査 = 前回調査項目.get(連番).get調査項目();
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private static RString get状況結果(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_認知機能(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private static RString get意見書状況結果(List<ShujiiIkenshoIkenItem> 調査項目,
            List<ShujiiIkenshoIkenItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get意見項目())) {
            今回調査 = 調査項目.get(連番).get意見項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change主治医差分連番(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get意見項目())) {
                前回調査 = 前回調査項目.get(前回連番).get意見項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査) || 主事意見_記載なし.equals(今回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private static List<RString> 主治医差分(List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> dbt5304Entity, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 主治医意見書項目4リスト = new ArrayList<>();
        前回厚労省IF識別コード = RString.isNullOrEmpty(前回厚労省IF識別コード) ? RString.EMPTY : 前回厚労省IF識別コード;
        if (印字する.equals(前回正常選択肢印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                    || 識別コード06A.equals(厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番13, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称03(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番13 : 連番14));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番14, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称04(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番14 : 連番15));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番15, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称05(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番15 : 連番16));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番16, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称06(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番16 : 連番17));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番68, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称14(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番68 : 連番18));
            }
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番14, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称03(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番13 : 連番14));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番15, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称04(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番14 : 連番15));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番16, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称05(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番15 : 連番16));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番17, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称06(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番16 : 連番17));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番18, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称14(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番68 : 連番18));
            }
        } else {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                    || 識別コード06A.equals(厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番13, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称03_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番13 : 連番14));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番14, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称04_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番14 : 連番15));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番15, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称05_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番15 : 連番16));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番16, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称06_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番16 : 連番17));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番68, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称14_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番68 : 連番18));
            }
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番14, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称03_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番13 : 連番14));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番15, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称04_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番14 : 連番15));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番16, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称05_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番15 : 連番16));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番17, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称06_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番16 : 連番17));
                主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番18, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get意見書名称14_正常選択肢印刷無(dbt5304Entity, is厚労省識別コードが09B_09A_06A(前回厚労省IF識別コード) ? 連番68 : 連番18));
            }
        }
        return 主治医意見書項目4リスト;
    }

    private static List<RString> 主治医全部(List<ShujiiIkenshoIkenItem> dbt5304Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 主治医意見書項目4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)
                    || 識別コード06A.equals(前回厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(get意見書名称03(dbt5304Entity, 連番13));
                主治医意見書項目4リスト.add(get意見書名称04(dbt5304Entity, 連番14));
                主治医意見書項目4リスト.add(get意見書名称05(dbt5304Entity, 連番15));
                主治医意見書項目4リスト.add(get意見書名称06(dbt5304Entity, 連番16));
                主治医意見書項目4リスト.add(get意見書名称14(dbt5304Entity, 連番68));
            }
            if (識別コード02A.equals(前回厚労省IF識別コード) || 識別コード99A.equals(前回厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(get意見書名称03(dbt5304Entity, 連番14));
                主治医意見書項目4リスト.add(get意見書名称04(dbt5304Entity, 連番15));
                主治医意見書項目4リスト.add(get意見書名称05(dbt5304Entity, 連番16));
                主治医意見書項目4リスト.add(get意見書名称06(dbt5304Entity, 連番17));
                主治医意見書項目4リスト.add(get意見書名称14(dbt5304Entity, 連番18));
            }
        } else {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)
                    || 識別コード06A.equals(前回厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(get意見書名称03_正常選択肢印刷無(dbt5304Entity, 連番13));
                主治医意見書項目4リスト.add(get意見書名称04_正常選択肢印刷無(dbt5304Entity, 連番14));
                主治医意見書項目4リスト.add(get意見書名称05_正常選択肢印刷無(dbt5304Entity, 連番15));
                主治医意見書項目4リスト.add(get意見書名称06_正常選択肢印刷無(dbt5304Entity, 連番16));
                主治医意見書項目4リスト.add(get意見書名称14_正常選択肢印刷無(dbt5304Entity, 連番68));
            }
            if (識別コード02A.equals(前回厚労省IF識別コード) || 識別コード99A.equals(前回厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(get意見書名称03_正常選択肢印刷無(dbt5304Entity, 連番14));
                主治医意見書項目4リスト.add(get意見書名称04_正常選択肢印刷無(dbt5304Entity, 連番15));
                主治医意見書項目4リスト.add(get意見書名称05_正常選択肢印刷無(dbt5304Entity, 連番16));
                主治医意見書項目4リスト.add(get意見書名称06_正常選択肢印刷無(dbt5304Entity, 連番17));
                主治医意見書項目4リスト.add(get意見書名称14_正常選択肢印刷無(dbt5304Entity, 連番18));
            }
        }
        return 主治医意見書項目4リスト;
    }

    private static boolean is厚労省識別コードが09B_09A_06A(RString 前回厚労省IF識別コード) {
        return 識別コード09B.equals(前回厚労省IF識別コード)
                || 識別コード09A.equals(前回厚労省IF識別コード)
                || 識別コード06A.equals(前回厚労省IF識別コード);
    }

    private static RString 差分結果(List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> 前回意見書項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get意見項目())) {
            今回調査 = 意見書項目.get(連番).get意見項目();
        }
        if (連番 < 前回意見書項目.size()) {
            int 前回連番 = change主治医差分連番(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回意見書項目.get(前回連番).get意見項目())) {
                RString 前回調査 = 前回意見書項目.get(前回連番).get意見項目();
                if (!今回調査.equals(前回調査)) {
                    return 前回調査;
                }
            }
        }
        return RString.EMPTY;
    }

    private static List<RString> 認知機能差分(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        前回厚労省IF識別コード = RString.isNullOrEmpty(前回厚労省IF識別コード) ? RString.EMPTY : 前回厚労省IF識別コード;
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            if (印字する.equals(前回正常選択肢印刷有無)) {
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番32, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称14(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番32
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番40 : 連番46));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番33, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番33
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番42 : 連番48));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番34, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番34
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番43 : 連番49));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番35, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番35
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番44 : 連番50));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番36, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番36
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番45 : 連番51));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番37, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番37
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番46 : 連番52));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番38, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番38
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番47 : 連番53));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番39, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称16(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番39
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番57 : 連番63));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称16(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番40
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番59 : 連番65));
            } else {
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番32, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称14_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番32
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番40 : 連番46));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番33, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番33
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番42 : 連番48));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番34, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番34
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番43 : 連番49));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番35, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番35
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番44 : 連番50));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番36, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番36
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番45 : 連番51));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番37, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番37
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番46 : 連番52));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番38, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番38
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番47 : 連番53));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番39, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称16_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番39
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番57 : 連番63));
                認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : get略称16_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番40
                                : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番59 : 連番65));
            }
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            return set認知機能差分99A(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            return set認知機能差分02A(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
        }

        return 認知機能4リスト;
    }

    private static List<RString> 認知機能全部(List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                認知機能4リスト.add(get略称14(dbt5211Entity, 連番32));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番33));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番34));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番35));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番36));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番37));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番38));
                認知機能4リスト.add(get略称16(dbt5211Entity, 連番39));
                認知機能4リスト.add(get略称16(dbt5211Entity, 連番40));
            }
            if (識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード)) {
                認知機能4リスト.add(get略称14(dbt5211Entity, 連番40));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番42));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番43));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番44));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番45));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番46));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番47));
                認知機能4リスト.add(get略称16(dbt5211Entity, 連番57));
                認知機能4リスト.add(get略称16(dbt5211Entity, 連番59));
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                認知機能4リスト.add(get略称14(dbt5211Entity, 連番46));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番48));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番49));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番50));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番51));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番52));
                認知機能4リスト.add(get略称15(dbt5211Entity, 連番53));
                認知機能4リスト.add(get略称16(dbt5211Entity, 連番63));
                認知機能4リスト.add(get略称16(dbt5211Entity, 連番65));
            }
        } else {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                認知機能4リスト.add(get略称14_正常選択肢印刷無(dbt5211Entity, 連番32));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番33));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番34));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番35));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番36));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番37));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番38));
                認知機能4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番39));
                認知機能4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番40));
            }
            if (識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード)) {
                認知機能4リスト.add(get略称14_正常選択肢印刷無(dbt5211Entity, 連番40));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番42));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番43));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番44));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番45));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番46));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番47));
                認知機能4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番57));
                認知機能4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番59));
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                認知機能4リスト.add(get略称14_正常選択肢印刷無(dbt5211Entity, 連番46));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番48));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番49));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番50));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番51));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番52));
                認知機能4リスト.add(get略称15_正常選択肢印刷無(dbt5211Entity, 連番53));
                認知機能4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番63));
                認知機能4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番65));
            }
        }
        return 認知機能4リスト;
    }

    private static RString get調査連番_身体機能(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目,
            int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_身体機能(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get状況結果_身体機能(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_身体機能(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private static RString get調査連番_生活機能(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_生活機能(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get状況結果_生活機能(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_生活機能(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private static RString get調査連番_精神障害(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_精神障害(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get状況結果_精神障害(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_精神障害(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private static RString get調査連番_社会生活(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_社会生活(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get状況結果_社会生活(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_社会生活(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private static RString get調査連番_特別な医療1(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_特別な医療1(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get調査連番_特別な医療2(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size()) {
            int 前回連番 = change連番_特別な医療2(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回調査項目.get(前回連番).get調査項目())) {
                前回調査 = 前回調査項目.get(前回連番).get調査項目();
            }
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査)
                ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static List<RString> set特別な医療4_2リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 特別な医療4_2リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番68, 連番1, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番69, 連番2, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番70, 連番3, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番71, 連番4, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番72, 連番5, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番73, 連番6, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番73, 連番1, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番74, 連番2, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番75, 連番3, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番76, 連番4, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番77, 連番5, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番78, 連番6, 前回厚労省IF識別コード));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番79, 連番1, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番80, 連番2, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番81, 連番3, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番82, 連番4, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番83, 連番5, 前回厚労省IF識別コード));
            特別な医療4_2リスト.add(get調査連番_特別な医療2(調査項目, 前回調査項目, 連番84, 連番6, 前回厚労省IF識別コード));
        }
        return 特別な医療4_2リスト;
    }

    private static List<RString> set特別な医療4_1リスト(List<NinteichosahyoChosaItem> dbt5211Entity,
            RString 正常選択肢印刷有無, RString 厚労省IF識別コード) {
        List<RString> 特別な医療4_1リスト = new ArrayList<>();
        if (印字する.equals(正常選択肢印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番68));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番69));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番70));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番71));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番72));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番73));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番73));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番74));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番75));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番76));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番77));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番78));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番79));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番80));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番81));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番82));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番83));
                特別な医療4_1リスト.add(get略称01(dbt5211Entity, 連番84));
            }
        } else {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番68));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番69));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番70));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番71));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番72));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番73));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番73));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番74));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番75));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番76));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番77));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番78));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番79));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番80));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番81));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番82));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番83));
                特別な医療4_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番84));
            }
        }
        return 特別な医療4_1リスト;
    }

    private static List<RString> set特別な医療3_2リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 特別な医療3_2リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番62, 連番1, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番63, 連番2, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番64, 連番3, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番65, 連番4, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番66, 連番5, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番67, 連番6, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番67, 連番1, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番68, 連番2, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番69, 連番3, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番70, 連番4, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番71, 連番5, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番72, 連番6, 前回厚労省IF識別コード));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番73, 連番1, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番74, 連番2, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番75, 連番3, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番76, 連番4, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番77, 連番5, 前回厚労省IF識別コード));
            特別な医療3_2リスト.add(get調査連番_特別な医療1(調査項目, 前回調査項目, 連番78, 連番6, 前回厚労省IF識別コード));
        }
        return 特別な医療3_2リスト;
    }

    private static List<RString> set特別な医療3_1リスト(List<NinteichosahyoChosaItem> dbt5211Entity,
            RString 正常選択肢印刷有無, RString 厚労省IF識別コード) {
        List<RString> 特別な医療3_1リスト = new ArrayList<>();
        if (印字する.equals(正常選択肢印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番62));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番63));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番64));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番65));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番66));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番67));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番67));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番68));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番69));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番70));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番71));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番72));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番73));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番74));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番75));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番76));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番77));
                特別な医療3_1リスト.add(get略称01(dbt5211Entity, 連番78));
            }
        } else {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番62));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番63));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番64));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番65));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番66));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番67));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番67));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番68));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番69));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番70));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番71));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番72));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番73));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番74));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番75));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番76));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番77));
                特別な医療3_1リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番78));
            }
        }
        return 特別な医療3_1リスト;
    }

    private static List<RString> 社会生活機能差分(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 社会生活への適応4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番56, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番56)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番34) : get略称22(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番57, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番57)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番35) : get略称22(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番58, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称17(dbt5211Entity, 連番58)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称17(dbt5211Entity, 連番37) : RString.EMPTY);
                if (識別コード06A.equals(前回厚労省IF識別コード)) {
                    社会生活への適応4リスト.add(アスタリスク);
                    社会生活への適応4リスト.add(アスタリスク);
                    社会生活への適応4リスト.add(アスタリスク);
                } else {
                    社会生活への適応4リスト.add(
                            機能差分結果_社会生活(調査項目, dbt5211Entity, 連番59, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                            : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番59) : RString.EMPTY);
                    社会生活への適応4リスト.add(
                            機能差分結果_社会生活(調査項目, dbt5211Entity, 連番60, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                            : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番60) : RString.EMPTY);
                    社会生活への適応4リスト.add(
                            機能差分結果_社会生活(調査項目, dbt5211Entity, 連番61, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                            : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番61) : RString.EMPTY);
                }
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番34, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番56)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番34) : get略称22(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番35, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番57)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番35) : get略称22(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番37, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称17(dbt5211Entity, 連番58)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称17(dbt5211Entity, 連番37) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番59) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番60) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番61) : RString.EMPTY);
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番40, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番56)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番34) : get略称22(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番41, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番57)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番35) : get略称22(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称17(dbt5211Entity, 連番58)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称17(dbt5211Entity, 連番37) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番59) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番60) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番61) : RString.EMPTY);
            }
        } else {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番56, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番56)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番34) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番57, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番57)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番35) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番58, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称17_正常選択肢印刷無(dbt5211Entity, 連番58)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称17_正常選択肢印刷無(dbt5211Entity, 連番37) : RString.EMPTY);
                if (識別コード06A.equals(前回厚労省IF識別コード)) {
                    社会生活への適応4リスト.add(アスタリスク);
                    社会生活への適応4リスト.add(アスタリスク);
                    社会生活への適応4リスト.add(アスタリスク);
                } else {
                    社会生活への適応4リスト.add(
                            機能差分結果_社会生活(調査項目, dbt5211Entity, 連番59, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                            : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番59) : RString.EMPTY);
                    社会生活への適応4リスト.add(
                            機能差分結果_社会生活(調査項目, dbt5211Entity, 連番60, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                            : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番60) : RString.EMPTY);
                    社会生活への適応4リスト.add(
                            機能差分結果_社会生活(調査項目, dbt5211Entity, 連番61, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                            : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番61) : RString.EMPTY);
                }
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番34, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番56)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番34) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番35, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番57)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番35) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番37, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称17_正常選択肢印刷無(dbt5211Entity, 連番58)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称17_正常選択肢印刷無(dbt5211Entity, 連番37) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番59) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番60) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番61) : RString.EMPTY);
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番40, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番56)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番34) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(
                        機能差分結果_社会生活(調査項目, dbt5211Entity, 連番41, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番57)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番35) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称17_正常選択肢印刷無(dbt5211Entity, 連番58)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称17_正常選択肢印刷無(dbt5211Entity, 連番37) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番59) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番60) : RString.EMPTY);
                社会生活への適応4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番61) : RString.EMPTY);
            }
        }
        return 社会生活への適応4リスト;
    }

    private static List<RString> 社会生活機能全部(List<NinteichosahyoChosaItem> dbt5211Entity,
            RString 厚労省IF識別コード, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 社会生活への適応4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get略称12(dbt5211Entity, 連番56));
                社会生活への適応4リスト.add(get略称12(dbt5211Entity, 連番57));
                社会生活への適応4リスト.add(get略称17(dbt5211Entity, 連番58));
                社会生活への適応4リスト.add(get略称16(dbt5211Entity, 連番59));
                社会生活への適応4リスト.add(get略称10(dbt5211Entity, 連番60));
                社会生活への適応4リスト.add(get略称10(dbt5211Entity, 連番61));
            }
            if (識別コード06A.equals(前回厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get略称22(dbt5211Entity, 連番34));
                社会生活への適応4リスト.add(get略称22(dbt5211Entity, 連番35));
                社会生活への適応4リスト.add(get略称17(dbt5211Entity, 連番37));
                if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                    社会生活への適応4リスト.add(アスタリスク);
                    社会生活への適応4リスト.add(アスタリスク);
                    社会生活への適応4リスト.add(アスタリスク);
                } else {
                    社会生活への適応4リスト.add(RString.EMPTY);
                    社会生活への適応4リスト.add(RString.EMPTY);
                    社会生活への適応4リスト.add(RString.EMPTY);
                }
            }
            if (識別コード02A.equals(前回厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get略称22(dbt5211Entity, 連番34));
                社会生活への適応4リスト.add(get略称22(dbt5211Entity, 連番35));
                社会生活への適応4リスト.add(get略称17(dbt5211Entity, 連番37));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get略称22(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(get略称22(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
        } else {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get略称12_正常選択肢印刷無(dbt5211Entity, 連番56));
                社会生活への適応4リスト.add(get略称12_正常選択肢印刷無(dbt5211Entity, 連番57));
                社会生活への適応4リスト.add(get略称17_正常選択肢印刷無(dbt5211Entity, 連番58));
                社会生活への適応4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番59));
                社会生活への適応4リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番60));
                社会生活への適応4リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番61));
            }
            if (識別コード06A.equals(前回厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番34));
                社会生活への適応4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番35));
                社会生活への適応4リスト.add(get略称17_正常選択肢印刷無(dbt5211Entity, 連番37));
                if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                    社会生活への適応4リスト.add(アスタリスク);
                    社会生活への適応4リスト.add(アスタリスク);
                    社会生活への適応4リスト.add(アスタリスク);
                } else {
                    社会生活への適応4リスト.add(RString.EMPTY);
                    社会生活への適応4リスト.add(RString.EMPTY);
                    社会生活への適応4リスト.add(RString.EMPTY);
                }
            }
            if (識別コード02A.equals(前回厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番34));
                社会生活への適応4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番35));
                社会生活への適応4リスト.add(get略称17_正常選択肢印刷無(dbt5211Entity, 連番37));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
        }
        return 社会生活への適応4リスト;
    }

    private static List<RString> set社会生活への適応4リスト(List<NinteichosahyoChosaItem> dbt5211Entity,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 認定調査前回結果印刷有無, RString 前回正常選択肢印刷有無,
            RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 社会生活への適応4リスト = new ArrayList<>();
        if (!前回調査項目.isEmpty()) {
            if (差分のみ印刷.equals(認定調査前回結果印刷有無)) {
                return 社会生活機能差分(dbt5211Entity, 前回調査項目, 厚労省IF識別コード, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
            if (印刷しない.equals(認定調査前回結果印刷有無)) {
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
            if (印刷する.equals(認定調査前回結果印刷有無)) {
                return 社会生活機能全部(前回調査項目, 厚労省IF識別コード, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
        } else {
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
        }
        return 社会生活への適応4リスト;
    }

    private static List<RString> set社会生活への適応3リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 社会生活への適応3リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番56, 連番1, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番57, 連番2, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番58, 連番3, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番59, 連番4, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番60, 連番5, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番61, 連番6, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番34, 連番1, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番35, 連番2, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番37, 連番3, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番40, 連番1, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(get状況結果_社会生活(調査項目, 前回調査項目, 連番41, 連番2, 前回厚労省IF識別コード));
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
        }
        return 社会生活への適応3リスト;
    }

    private static List<RString> set社会生活への適応2リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 社会生活への適応2リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番56, 連番1, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番57, 連番2, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番58, 連番3, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番59, 連番4, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番60, 連番5, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番61, 連番6, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番34, 連番1, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番35, 連番2, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番37, 連番3, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番40, 連番1, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(get調査連番_社会生活(調査項目, 前回調査項目, 連番41, 連番2, 前回厚労省IF識別コード));
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
        }
        return 社会生活への適応2リスト;
    }

    private static List<RString> set社会生活への適応1リスト(List<NinteichosahyoChosaItem> dbt5211Entity,
            RString 正常選択肢印刷有無, RString 厚労省IF識別コード) {
        List<RString> 社会生活への適応1リスト = new ArrayList<>();
        if (印字する.equals(正常選択肢印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                社会生活への適応1リスト.add(get略称12(dbt5211Entity, 連番56));
                社会生活への適応1リスト.add(get略称12(dbt5211Entity, 連番57));
                社会生活への適応1リスト.add(get略称17(dbt5211Entity, 連番58));
                社会生活への適応1リスト.add(get略称16(dbt5211Entity, 連番59));
                社会生活への適応1リスト.add(get略称10(dbt5211Entity, 連番60));
                社会生活への適応1リスト.add(get略称10(dbt5211Entity, 連番61));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                社会生活への適応1リスト.add(get略称22(dbt5211Entity, 連番34));
                社会生活への適応1リスト.add(get略称22(dbt5211Entity, 連番35));
                社会生活への適応1リスト.add(get略称17(dbt5211Entity, 連番37));
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                社会生活への適応1リスト.add(get略称22(dbt5211Entity, 連番40));
                社会生活への適応1リスト.add(get略称22(dbt5211Entity, 連番41));
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
            }
        } else {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                社会生活への適応1リスト.add(get略称12_正常選択肢印刷無(dbt5211Entity, 連番56));
                社会生活への適応1リスト.add(get略称12_正常選択肢印刷無(dbt5211Entity, 連番57));
                社会生活への適応1リスト.add(get略称17_正常選択肢印刷無(dbt5211Entity, 連番58));
                社会生活への適応1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番59));
                社会生活への適応1リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番60));
                社会生活への適応1リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番61));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                社会生活への適応1リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番34));
                社会生活への適応1リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番35));
                社会生活への適応1リスト.add(get略称17_正常選択肢印刷無(dbt5211Entity, 連番37));
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                社会生活への適応1リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番40));
                社会生活への適応1リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番41));
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
                社会生活への適応1リスト.add(RString.EMPTY);
            }
        }
        return 社会生活への適応1リスト;
    }

    private static List<RString> 精神機能差分(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            return set精神機能差分09B(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            return set精神機能差分99A(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            return set精神機能差分02A(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
        }
        return 精神_行動障害4リスト;
    }

    private static List<RString> 精神機能全部(List<NinteichosahyoChosaItem> dbt5211Entity,
            RString 厚労省IF識別コード, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番41));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番42));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番43));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番44));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番45));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番46));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番47));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番48));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番49));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番50));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番51));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番52));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番53));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番55));
            }
            if (識別コード06A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番48));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番49));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番51));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番52));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番55));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番56));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番58));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番60));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番61));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番63));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番66));
                if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                    精神_行動障害4リスト.add(アスタリスク);
                    精神_行動障害4リスト.add(アスタリスク);
                    精神_行動障害4リスト.add(アスタリスク);
                } else {
                    精神_行動障害4リスト.add(RString.EMPTY);
                    精神_行動障害4リスト.add(RString.EMPTY);
                    精神_行動障害4リスト.add(RString.EMPTY);
                }
            }
            if (識別コード02A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番48));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番49));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番51));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番52));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番55));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番56));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番58));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番60));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番61));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番63));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番66));
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番55));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番57));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番58));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番60));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番61));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番62));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番64));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番66));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番67));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番69));
                精神_行動障害4リスト.add(get略称16(dbt5211Entity, 連番42));
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
            }
        } else {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番41));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番42));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番43));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番44));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番45));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番46));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番47));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番48));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番49));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番50));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番51));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番52));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番53));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
            }
            if (識別コード06A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番48));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番49));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番51));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番52));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番56));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番58));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番60));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番61));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番63));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番66));
                if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                    精神_行動障害4リスト.add(アスタリスク);
                    精神_行動障害4リスト.add(アスタリスク);
                    精神_行動障害4リスト.add(アスタリスク);
                } else {
                    精神_行動障害4リスト.add(RString.EMPTY);
                    精神_行動障害4リスト.add(RString.EMPTY);
                    精神_行動障害4リスト.add(RString.EMPTY);
                }
            }
            if (識別コード02A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番48));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番49));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番51));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番52));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番56));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番58));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番60));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番61));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番63));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番66));
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番57));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番58));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番60));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番61));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番62));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番64));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番66));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番67));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番69));
                精神_行動障害4リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番42));
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
            }
        }
        return 精神_行動障害4リスト;
    }

    private static List<RString> set精神機能差分09B(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番41, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番41)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番48) : get略称16(dbt5211Entity, 連番54));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番42, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番42)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番49) : get略称16(dbt5211Entity, 連番55));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番43, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番43)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番51) : get略称16(dbt5211Entity, 連番57));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番44, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番44)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番52) : get略称16(dbt5211Entity, 連番58));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番45, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番45)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番54) : get略称16(dbt5211Entity, 連番60));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番46, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番46)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番55) : get略称16(dbt5211Entity, 連番61));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番47, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番47)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番56) : get略称16(dbt5211Entity, 連番62));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番48, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番48)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番58) : get略称16(dbt5211Entity, 連番64));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番49, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番49)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番60) : get略称16(dbt5211Entity, 連番66));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番50, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番50)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番61) : get略称16(dbt5211Entity, 連番67));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番51, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番51)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番63) : get略称16(dbt5211Entity, 連番69));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番52, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番52)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番66) : get略称16(dbt5211Entity, 連番42));
            if (識別コード06A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(アスタリスク);
                精神_行動障害4リスト.add(アスタリスク);
                精神_行動障害4リスト.add(アスタリスク);
            } else {
                精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番53, 連番13, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番53) : RString.EMPTY);
                精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番54, 連番14, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番54) : RString.EMPTY);
                精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番55, 連番15, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番55) : RString.EMPTY);
            }
        } else {
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番41, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番41)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番48) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番42, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番42)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番49) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番43, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番43)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番51) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番57));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番44, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番44)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番52) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番58));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番45, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番45)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番54) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番60));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番46, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番46)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番55) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番61));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番47, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番47)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番56) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番62));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番48, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番48)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番58) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番64));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番49, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番49)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番60) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番66));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番50, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番50)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番61) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番67));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番51, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番51)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番63) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番69));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番52, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番52)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番66) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番42));
            if (識別コード06A.equals(前回厚労省IF識別コード)) {
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
            } else {
                精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番53, 連番13, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番53) : RString.EMPTY);
                精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番54, 連番14, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番54) : RString.EMPTY);
                精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番55, 連番15, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番55) : RString.EMPTY);
            }
        }
        return 精神_行動障害4リスト;
    }

    private static List<RString> set精神機能差分99A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番54, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番41)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番48) : get略称16(dbt5211Entity, 連番54));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番55, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番42)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番49) : get略称16(dbt5211Entity, 連番55));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番57, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番43)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番51) : get略称16(dbt5211Entity, 連番57));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番58, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番44)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番52) : get略称16(dbt5211Entity, 連番58));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番60, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番45)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番54) : get略称16(dbt5211Entity, 連番60));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番61, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番46)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番55) : get略称16(dbt5211Entity, 連番61));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番62, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番47)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番56) : get略称16(dbt5211Entity, 連番62));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番64, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番48)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番58) : get略称16(dbt5211Entity, 連番64));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番66, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番49)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番60) : get略称16(dbt5211Entity, 連番66));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番67, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番50)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番61) : get略称16(dbt5211Entity, 連番67));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番69, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番51)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番63) : get略称16(dbt5211Entity, 連番69));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番42, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番52)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番66) : get略称16(dbt5211Entity, 連番42));
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番53) : RString.EMPTY);
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番54) : RString.EMPTY);
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番55) : RString.EMPTY);
        } else {
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番54, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番41)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番48) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番55, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番42)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番49) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番57, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番43)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番51) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番57));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番58, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番44)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番52) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番58));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番60, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番45)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番54) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番60));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番61, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番46)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番55) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番61));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番62, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番47)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番56) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番62));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番64, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番48)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番58) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番64));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番66, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番49)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番60) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番66));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番67, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番50)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番61) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番67));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番69, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番51)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番63) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番69));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番42, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番52)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番66) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番42));
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番53) : RString.EMPTY);
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番54) : RString.EMPTY);
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番55) : RString.EMPTY);
        }
        return 精神_行動障害4リスト;
    }

    private static List<RString> set精神機能差分02A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番48, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番41)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番48) : get略称16(dbt5211Entity, 連番54));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番49, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番42)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番49) : get略称16(dbt5211Entity, 連番55));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番51, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番43)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番51) : get略称16(dbt5211Entity, 連番57));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番52, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番44)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番52) : get略称16(dbt5211Entity, 連番58));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番54, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番45)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番54) : get略称16(dbt5211Entity, 連番60));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番55, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番46)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番55) : get略称16(dbt5211Entity, 連番61));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番56, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番47)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番56) : get略称16(dbt5211Entity, 連番62));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番58, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番48)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番58) : get略称16(dbt5211Entity, 連番64));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番60, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番49)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番60) : get略称16(dbt5211Entity, 連番66));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番61, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番50)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番61) : get略称16(dbt5211Entity, 連番67));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番63, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番51)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番63) : get略称16(dbt5211Entity, 連番69));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番66, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番52)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番66) : get略称16(dbt5211Entity, 連番42));
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番53) : RString.EMPTY);
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番54) : RString.EMPTY);
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16(dbt5211Entity, 連番55) : RString.EMPTY);
        } else {
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番48, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番41)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番48) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番49, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番42)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番49) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番51, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番43)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番51) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番57));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番52, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番44)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番52) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番58));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番54, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番45)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番54) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番60));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番55, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番46)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番55) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番61));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番56, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番47)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番56) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番62));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番58, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番48)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番58) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番64));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番60, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番49)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番60) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番66));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番61, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番50)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番61) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番67));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番63, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番51)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番63) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番69));
            精神_行動障害4リスト.add(機能差分結果_精神障害(調査項目, dbt5211Entity, 連番66, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番52)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番66) : get略称16_正常選択肢印刷無(dbt5211Entity, 連番42));
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番53) : RString.EMPTY);
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番54) : RString.EMPTY);
            精神_行動障害4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称16_正常選択肢印刷無(dbt5211Entity, 連番55) : RString.EMPTY);
        }
        return 精神_行動障害4リスト;
    }

    private static List<RString> set精神_行動障害4リスト(List<NinteichosahyoChosaItem> dbt5211Entity,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 認定調査前回結果印刷有無, RString 前回正常選択肢印刷有無,
            RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (!前回調査項目.isEmpty()) {
            if (差分のみ印刷.equals(認定調査前回結果印刷有無)) {
                return 精神機能差分(dbt5211Entity, 前回調査項目, 厚労省IF識別コード, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
            if (印刷しない.equals(認定調査前回結果印刷有無)) {
                for (int count = 1; count <= COUNT_15; count++) {
                    精神_行動障害4リスト.add(RString.EMPTY);
                }
            }
            if (印刷する.equals(認定調査前回結果印刷有無)) {
                return 精神機能全部(前回調査項目, 前回厚労省IF識別コード, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
        } else {
            for (int count = 1; count <= COUNT_15; count++) {
                精神_行動障害4リスト.add(RString.EMPTY);
            }
        }
        return 精神_行動障害4リスト;
    }

    private static List<RString> set精神_行動障害3リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 精神_行動障害3リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番41, 連番1, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番42, 連番2, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番43, 連番3, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番44, 連番4, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番45, 連番5, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番46, 連番6, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番47, 連番7, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番48, 連番8, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番49, 連番9, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番50, 連番10, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番51, 連番11, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番52, 連番12, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番53, 連番13, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番54, 連番14, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番55, 連番15, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番48, 連番1, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番49, 連番2, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番51, 連番3, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番52, 連番4, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番54, 連番5, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番55, 連番6, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番56, 連番7, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番58, 連番8, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番60, 連番9, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番61, 連番10, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番63, 連番11, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番66, 連番12, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番54, 連番1, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番55, 連番2, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番57, 連番3, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番58, 連番4, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番60, 連番5, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番61, 連番6, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番62, 連番7, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番64, 連番8, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番66, 連番9, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番67, 連番10, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番69, 連番11, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(get状況結果_精神障害(調査項目, 前回調査項目, 連番42, 連番12, 前回厚労省IF識別コード));
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
        }
        return 精神_行動障害3リスト;
    }

    private static List<RString> set精神_行動障害2リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 精神_行動障害2リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番41, 連番1, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番42, 連番2, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番43, 連番3, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番44, 連番4, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番45, 連番5, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番46, 連番6, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番47, 連番7, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番48, 連番8, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番49, 連番9, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番50, 連番10, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番51, 連番11, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番52, 連番12, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番53, 連番13, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番54, 連番14, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番55, 連番15, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番48, 連番1, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番49, 連番2, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番51, 連番3, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番52, 連番4, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番54, 連番5, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番55, 連番6, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番56, 連番7, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番58, 連番8, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番60, 連番9, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番61, 連番10, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番63, 連番11, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番66, 連番12, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番54, 連番1, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番55, 連番2, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番57, 連番3, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番58, 連番4, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番60, 連番5, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番61, 連番6, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番62, 連番7, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番64, 連番8, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番66, 連番9, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番67, 連番10, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番69, 連番11, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(get調査連番_精神障害(調査項目, 前回調査項目, 連番42, 連番12, 前回厚労省IF識別コード));
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
        }
        return 精神_行動障害2リスト;
    }

    private static List<RString> set精神_行動障害1リスト(List<NinteichosahyoChosaItem> dbt5211Entity,
            RString 正常選択肢印刷有無, RString 厚労省IF識別コード) {
        List<RString> 精神_行動障害1リスト = new ArrayList<>();
        if (印字する.equals(正常選択肢印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番41));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番42));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番43));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番44));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番45));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番46));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番47));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番48));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番49));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番50));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番51));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番52));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番53));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番54));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番55));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番48));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番49));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番51));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番52));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番54));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番55));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番56));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番58));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番60));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番61));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番63));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番66));
                精神_行動障害1リスト.add(RString.EMPTY);
                精神_行動障害1リスト.add(RString.EMPTY);
                精神_行動障害1リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番54));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番55));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番57));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番58));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番60));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番61));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番62));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番64));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番66));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番67));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番69));
                精神_行動障害1リスト.add(get略称16(dbt5211Entity, 連番42));
                精神_行動障害1リスト.add(RString.EMPTY);
                精神_行動障害1リスト.add(RString.EMPTY);
                精神_行動障害1リスト.add(RString.EMPTY);
            }
        } else {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番41));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番42));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番43));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番44));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番45));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番46));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番47));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番48));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番49));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番50));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番51));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番52));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番53));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番48));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番49));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番51));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番52));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番56));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番58));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番60));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番61));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番63));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番66));
                精神_行動障害1リスト.add(RString.EMPTY);
                精神_行動障害1リスト.add(RString.EMPTY);
                精神_行動障害1リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番54));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番55));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番57));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番58));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番60));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番61));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番62));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番64));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番66));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番67));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番69));
                精神_行動障害1リスト.add(get略称16_正常選択肢印刷無(dbt5211Entity, 連番42));
                精神_行動障害1リスト.add(RString.EMPTY);
                精神_行動障害1リスト.add(RString.EMPTY);
                精神_行動障害1リスト.add(RString.EMPTY);
            }
        }
        return 精神_行動障害1リスト;
    }

    private static List<RString> 生活機能差分(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            if (印字する.equals(前回正常選択肢印刷有無)) {
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番20, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番20)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番16) : get略称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番21, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番21)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番17) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番22, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称11(dbt5211Entity, 連番22)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称11(dbt5211Entity, 連番23) : get略称33(dbt5211Entity, 連番25));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番23, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番23)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番24) : get略称33(dbt5211Entity, 連番30));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番24, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番24)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番26) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番25, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番25)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番27) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番26, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番26)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番28) : get略称22(dbt5211Entity, 連番31));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番27, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番27)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番29) : get略称22(dbt5211Entity, 連番32));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番28, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番28)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番30) : get略称22(dbt5211Entity, 連番33));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番29, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番29)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番32) : get略称34(dbt5211Entity, 連番36));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番30, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番30)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番33) : get略称34(dbt5211Entity, 連番37));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番31, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称13(dbt5211Entity, 連番31)
                        : is厚労省識別コードが06A(前回厚労省IF識別コード) ? get略称13(dbt5211Entity, 連番80) : RString.EMPTY);
            } else {
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番20, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番20)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番16) : get略称20_正常選択肢印刷無(dbt5211Entity, 連番17));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番21, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番21)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番17) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番22, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称11_正常選択肢印刷無(dbt5211Entity, 連番22)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称11_正常選択肢印刷無(dbt5211Entity, 連番23) : get略称33_正常選択肢印刷無(dbt5211Entity, 連番25));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番23, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番23)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番24) : get略称33_正常選択肢印刷無(dbt5211Entity, 連番30));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番24, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番24)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番26) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番25, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番25)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番27) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番26, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番26)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番28) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番31));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番27, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番27)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番29) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番32));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番28, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番28)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番30) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番33));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番29, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番29)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番32) : get略称34_正常選択肢印刷無(dbt5211Entity, 連番36));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番30, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番30)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番33) : get略称34_正常選択肢印刷無(dbt5211Entity, 連番37));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番31, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称13_正常選択肢印刷無(dbt5211Entity, 連番31)
                        : is厚労省識別コードが06A(前回厚労省IF識別コード) ? get略称13_正常選択肢印刷無(dbt5211Entity, 連番80) : RString.EMPTY);
            }
        } else if (識別コード99A.equals(厚労省IF識別コード)) {
            return set生活機能差分99A(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
        } else if (識別コード02A.equals(厚労省IF識別コード) || 識別コード06A.equals(厚労省IF識別コード)) {
            return set生活機能差分02A(調査項目, dbt5211Entity, 厚労省IF識別コード, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
        }
        return 生活機能4リスト;
    }

    private static List<RString> 生活機能全部(List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                生活機能4リスト.add(get略称10(dbt5211Entity, 連番20));
                生活機能4リスト.add(get略称10(dbt5211Entity, 連番21));
                生活機能4リスト.add(get略称11(dbt5211Entity, 連番22));
                生活機能4リスト.add(get略称10(dbt5211Entity, 連番23));
                生活機能4リスト.add(get略称10(dbt5211Entity, 連番24));
                生活機能4リスト.add(get略称10(dbt5211Entity, 連番25));
                生活機能4リスト.add(get略称12(dbt5211Entity, 連番26));
                生活機能4リスト.add(get略称12(dbt5211Entity, 連番27));
                生活機能4リスト.add(get略称12(dbt5211Entity, 連番28));
                生活機能4リスト.add(get略称10(dbt5211Entity, 連番29));
                生活機能4リスト.add(get略称10(dbt5211Entity, 連番30));
                生活機能4リスト.add(get略称13(dbt5211Entity, 連番31));
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(get略称33(dbt5211Entity, 連番25));
                生活機能4リスト.add(get略称33(dbt5211Entity, 連番30));
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(get略称22(dbt5211Entity, 連番31));
                生活機能4リスト.add(get略称22(dbt5211Entity, 連番32));
                生活機能4リスト.add(get略称22(dbt5211Entity, 連番33));
                生活機能4リスト.add(get略称34(dbt5211Entity, 連番36));
                生活機能4リスト.add(get略称34(dbt5211Entity, 連番37));
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード02A.equals(前回厚労省IF識別コード)) {
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番16));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(get略称11(dbt5211Entity, 連番23));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番24));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番26));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番27));
                生活機能4リスト.add(get略称22(dbt5211Entity, 連番28));
                生活機能4リスト.add(get略称22(dbt5211Entity, 連番29));
                生活機能4リスト.add(get略称22(dbt5211Entity, 連番30));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番32));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番33));
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード06A.equals(前回厚労省IF識別コード)) {
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番16));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(get略称11(dbt5211Entity, 連番23));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番24));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番26));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番27));
                生活機能4リスト.add(get略称22(dbt5211Entity, 連番28));
                生活機能4リスト.add(get略称22(dbt5211Entity, 連番29));
                生活機能4リスト.add(get略称22(dbt5211Entity, 連番30));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番32));
                生活機能4リスト.add(get略称20(dbt5211Entity, 連番33));
                生活機能4リスト.add(get略称13(dbt5211Entity, 連番80));
            }
        } else {
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                生活機能4リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番20));
                生活機能4リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番21));
                生活機能4リスト.add(get略称11_正常選択肢印刷無(dbt5211Entity, 連番22));
                生活機能4リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番23));
                生活機能4リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番24));
                生活機能4リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番25));
                生活機能4リスト.add(get略称12_正常選択肢印刷無(dbt5211Entity, 連番26));
                生活機能4リスト.add(get略称12_正常選択肢印刷無(dbt5211Entity, 連番27));
                生活機能4リスト.add(get略称12_正常選択肢印刷無(dbt5211Entity, 連番28));
                生活機能4リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番29));
                生活機能4リスト.add(get略称10_正常選択肢印刷無(dbt5211Entity, 連番30));
                生活機能4リスト.add(get略称13_正常選択肢印刷無(dbt5211Entity, 連番31));
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番17));
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(get略称33_正常選択肢印刷無(dbt5211Entity, 連番25));
                生活機能4リスト.add(get略称33_正常選択肢印刷無(dbt5211Entity, 連番30));
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番31));
                生活機能4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番32));
                生活機能4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番33));
                生活機能4リスト.add(get略称34_正常選択肢印刷無(dbt5211Entity, 連番36));
                生活機能4リスト.add(get略称34_正常選択肢印刷無(dbt5211Entity, 連番37));
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード02A.equals(前回厚労省IF識別コード)) {
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番16));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番17));
                生活機能4リスト.add(get略称11_正常選択肢印刷無(dbt5211Entity, 連番23));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番24));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番26));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番27));
                生活機能4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番28));
                生活機能4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番29));
                生活機能4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番30));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番32));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番33));
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード06A.equals(前回厚労省IF識別コード)) {
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番16));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番17));
                生活機能4リスト.add(get略称11_正常選択肢印刷無(dbt5211Entity, 連番23));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番24));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番26));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番27));
                生活機能4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番28));
                生活機能4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番29));
                生活機能4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番30));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番32));
                生活機能4リスト.add(get略称20_正常選択肢印刷無(dbt5211Entity, 連番33));
                生活機能4リスト.add(get略称13_正常選択肢印刷無(dbt5211Entity, 連番80));
            }
        }
        return 生活機能4リスト;
    }

    private static List<RString> set生活機能差分99A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番17, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番20)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番16) : get略称20(dbt5211Entity, 連番17));
            生活機能4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番21)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番17) : RString.EMPTY);
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番25, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称11(dbt5211Entity, 連番22)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称11(dbt5211Entity, 連番23) : get略称33(dbt5211Entity, 連番25));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番30, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番23)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番24) : get略称33(dbt5211Entity, 連番30));
            生活機能4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番24)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番26) : RString.EMPTY);
            生活機能4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番25)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番27) : RString.EMPTY);
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番31, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番26)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番28) : get略称22(dbt5211Entity, 連番31));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番32, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番27)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番29) : get略称22(dbt5211Entity, 連番32));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番33, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番28)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番30) : get略称22(dbt5211Entity, 連番33));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番36, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番29)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番32) : get略称34(dbt5211Entity, 連番36));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番37, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番30)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番33) : get略称34(dbt5211Entity, 連番37));
            生活機能4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称13(dbt5211Entity, 連番31)
                    : is厚労省識別コードが06A(前回厚労省IF識別コード) ? get略称13(dbt5211Entity, 連番80) : RString.EMPTY);
        } else {
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番17, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番20)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番16) : get略称20_正常選択肢印刷無(dbt5211Entity, 連番17));
            生活機能4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番21)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番17) : RString.EMPTY);
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番25, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称11_正常選択肢印刷無(dbt5211Entity, 連番22)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称11_正常選択肢印刷無(dbt5211Entity, 連番23) : get略称33_正常選択肢印刷無(dbt5211Entity, 連番25));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番30, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番23)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番24) : get略称33_正常選択肢印刷無(dbt5211Entity, 連番30));
            生活機能4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番24)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番26) : RString.EMPTY);
            生活機能4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番25)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番27) : RString.EMPTY);
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番31, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番26)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番28) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番31));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番32, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番27)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番29) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番32));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番33, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番28)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番30) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番33));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番36, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番29)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番32) : get略称34_正常選択肢印刷無(dbt5211Entity, 連番36));
            生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番37, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番30)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番33) : get略称34_正常選択肢印刷無(dbt5211Entity, 連番37));
            生活機能4リスト.add(is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称13_正常選択肢印刷無(dbt5211Entity, 連番31)
                    : is厚労省識別コードが06A(前回厚労省IF識別コード) ? get略称13_正常選択肢印刷無(dbt5211Entity, 連番80) : RString.EMPTY);
        }
        return 生活機能4リスト;
    }

    private static List<RString> set生活機能差分02A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード06A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番16, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番20)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番16) : get略称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番17, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番21)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番17) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番23, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称11(dbt5211Entity, 連番22)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称11(dbt5211Entity, 連番23) : get略称33(dbt5211Entity, 連番25));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番24, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番23)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番24) : get略称33(dbt5211Entity, 連番30));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番26, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番24)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番26) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番27, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番25)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番27) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番28, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番26)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番28) : get略称22(dbt5211Entity, 連番31));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番29, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番27)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番29) : get略称22(dbt5211Entity, 連番32));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番30, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12(dbt5211Entity, 連番28)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番30) : get略称22(dbt5211Entity, 連番33));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番32, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番29)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番32) : get略称34(dbt5211Entity, 連番36));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番33, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10(dbt5211Entity, 連番30)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20(dbt5211Entity, 連番33) : get略称34(dbt5211Entity, 連番37));
            }
            if (識別コード02A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード06A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番80, 連番12, 前回厚労省IF識別コード).isEmpty()
                        ? RString.EMPTY : get略称13(dbt5211Entity, 連番80));
            }
        } else {
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード06A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番16, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番20)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番16) : get略称20_正常選択肢印刷無(dbt5211Entity, 連番17));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番17, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番21)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番17) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番23, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称11_正常選択肢印刷無(dbt5211Entity, 連番22)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称11_正常選択肢印刷無(dbt5211Entity, 連番23) : get略称33_正常選択肢印刷無(dbt5211Entity, 連番25));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番24, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番23)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番24) : get略称33_正常選択肢印刷無(dbt5211Entity, 連番30));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番26, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番24)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番26) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番27, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番25)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番27) : RString.EMPTY);
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番28, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番26)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番28) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番31));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番29, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番27)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番29) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番32));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番30, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称12_正常選択肢印刷無(dbt5211Entity, 連番28)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番30) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番33));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番32, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番29)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番32) : get略称34_正常選択肢印刷無(dbt5211Entity, 連番36));
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番33, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                        : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称10_正常選択肢印刷無(dbt5211Entity, 連番30)
                        : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称20_正常選択肢印刷無(dbt5211Entity, 連番33) : get略称34_正常選択肢印刷無(dbt5211Entity, 連番37));
            }
            if (識別コード02A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード06A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(機能差分結果_生活機能(調査項目, dbt5211Entity, 連番80, 連番12, 前回厚労省IF識別コード).isEmpty()
                        ? RString.EMPTY : get略称13_正常選択肢印刷無(dbt5211Entity, 連番80));
            }
        }
        return 生活機能4リスト;
    }

    private static List<RString> set生活機能4リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 認定調査前回結果印刷有無, RString 前回正常選択肢印刷有無,
            RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        if (!前回調査項目.isEmpty()) {
            if (差分のみ印刷.equals(認定調査前回結果印刷有無)) {
                return 生活機能差分(調査項目, 前回調査項目, 厚労省IF識別コード, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
            if (印刷しない.equals(認定調査前回結果印刷有無)) {
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
            }
            if (印刷する.equals(認定調査前回結果印刷有無)) {
                return 生活機能全部(前回調査項目, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
        } else {
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
        }
        return 生活機能4リスト;
    }

    private static List<RString> set生活機能3リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 生活機能3リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番20, 連番1, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番21, 連番2, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番22, 連番3, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番23, 連番4, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番24, 連番5, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番25, 連番6, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番26, 連番7, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番27, 連番8, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番28, 連番9, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番29, 連番10, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番30, 連番11, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番31, 連番12, 前回厚労省IF識別コード));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番17, 連番1, 前回厚労省IF識別コード));
            生活機能3リスト.add(RString.EMPTY);
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番25, 連番3, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番30, 連番4, 前回厚労省IF識別コード));
            生活機能3リスト.add(RString.EMPTY);
            生活機能3リスト.add(RString.EMPTY);
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番31, 連番7, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番32, 連番8, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番33, 連番9, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番36, 連番10, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番37, 連番11, 前回厚労省IF識別コード));
            生活機能3リスト.add(RString.EMPTY);
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番16, 連番1, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番17, 連番2, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番23, 連番3, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番24, 連番4, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番26, 連番5, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番27, 連番6, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番28, 連番7, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番29, 連番8, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番30, 連番9, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番32, 連番10, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番33, 連番11, 前回厚労省IF識別コード));
            生活機能3リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番16, 連番1, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番17, 連番2, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番23, 連番3, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番24, 連番4, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番26, 連番5, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番27, 連番6, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番28, 連番7, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番29, 連番8, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番30, 連番9, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番32, 連番10, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番33, 連番11, 前回厚労省IF識別コード));
            生活機能3リスト.add(get状況結果_生活機能(調査項目, 前回調査項目, 連番80, 連番12, 前回厚労省IF識別コード));
        }
        return 生活機能3リスト;
    }

    private static List<RString> set生活機能2リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 生活機能2リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番20, 連番1, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番21, 連番2, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番22, 連番3, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番23, 連番4, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番24, 連番5, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番25, 連番6, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番26, 連番7, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番27, 連番8, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番28, 連番9, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番29, 連番10, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番30, 連番11, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番31, 連番12, 前回厚労省IF識別コード));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番17, 連番1, 前回厚労省IF識別コード));
            生活機能2リスト.add(RString.EMPTY);
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番25, 連番3, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番30, 連番4, 前回厚労省IF識別コード));
            生活機能2リスト.add(RString.EMPTY);
            生活機能2リスト.add(RString.EMPTY);
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番31, 連番7, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番32, 連番8, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番33, 連番9, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番36, 連番10, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番37, 連番11, 前回厚労省IF識別コード));
            生活機能2リスト.add(RString.EMPTY);
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番16, 連番1, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番17, 連番2, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番23, 連番3, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番24, 連番4, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番26, 連番5, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番27, 連番6, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番28, 連番7, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番29, 連番8, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番30, 連番9, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番32, 連番10, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番33, 連番11, 前回厚労省IF識別コード));
            生活機能2リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番16, 連番1, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番17, 連番2, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番23, 連番3, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番24, 連番4, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番26, 連番5, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番27, 連番6, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番28, 連番7, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番29, 連番8, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番30, 連番9, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番32, 連番10, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番33, 連番11, 前回厚労省IF識別コード));
            生活機能2リスト.add(get調査連番_生活機能(調査項目, 前回調査項目, 連番80, 連番12, 前回厚労省IF識別コード));
        }
        return 生活機能2リスト;
    }

    private static List<RString> set生活機能1リスト(List<NinteichosahyoChosaItem> 調査項目,
            RString 正常選択肢印刷有無, RString 厚労省IF識別コード) {
        List<RString> 生活機能1リスト = new ArrayList<>();
        if (印字する.equals(正常選択肢印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                生活機能1リスト.add(get略称10(調査項目, 連番20));
                生活機能1リスト.add(get略称10(調査項目, 連番21));
                生活機能1リスト.add(get略称11(調査項目, 連番22));
                生活機能1リスト.add(get略称10(調査項目, 連番23));
                生活機能1リスト.add(get略称10(調査項目, 連番24));
                生活機能1リスト.add(get略称10(調査項目, 連番25));
                生活機能1リスト.add(get略称12(調査項目, 連番26));
                生活機能1リスト.add(get略称12(調査項目, 連番27));
                生活機能1リスト.add(get略称12(調査項目, 連番28));
                生活機能1リスト.add(get略称10(調査項目, 連番29));
                生活機能1リスト.add(get略称10(調査項目, 連番30));
                生活機能1リスト.add(get略称13(調査項目, 連番31));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                生活機能1リスト.add(get略称20(調査項目, 連番17));
                生活機能1リスト.add(RString.EMPTY);
                生活機能1リスト.add(get略称33(調査項目, 連番25));
                生活機能1リスト.add(get略称33(調査項目, 連番30));
                生活機能1リスト.add(RString.EMPTY);
                生活機能1リスト.add(RString.EMPTY);
                生活機能1リスト.add(get略称22(調査項目, 連番31));
                生活機能1リスト.add(get略称22(調査項目, 連番32));
                生活機能1リスト.add(get略称22(調査項目, 連番33));
                生活機能1リスト.add(get略称34(調査項目, 連番36));
                生活機能1リスト.add(get略称34(調査項目, 連番37));
                生活機能1リスト.add(RString.EMPTY);
            }
            if (識別コード02A.equals(厚労省IF識別コード)) {
                生活機能1リスト.add(get略称20(調査項目, 連番16));
                生活機能1リスト.add(get略称20(調査項目, 連番17));
                生活機能1リスト.add(get略称11(調査項目, 連番23));
                生活機能1リスト.add(get略称20(調査項目, 連番24));
                生活機能1リスト.add(get略称20(調査項目, 連番26));
                生活機能1リスト.add(get略称20(調査項目, 連番27));
                生活機能1リスト.add(get略称22(調査項目, 連番28));
                生活機能1リスト.add(get略称22(調査項目, 連番29));
                生活機能1リスト.add(get略称22(調査項目, 連番30));
                生活機能1リスト.add(get略称20(調査項目, 連番32));
                生活機能1リスト.add(get略称20(調査項目, 連番33));
                生活機能1リスト.add(RString.EMPTY);
            }
            if (識別コード06A.equals(厚労省IF識別コード)) {
                生活機能1リスト.add(get略称20(調査項目, 連番16));
                生活機能1リスト.add(get略称20(調査項目, 連番17));
                生活機能1リスト.add(get略称11(調査項目, 連番23));
                生活機能1リスト.add(get略称20(調査項目, 連番24));
                生活機能1リスト.add(get略称20(調査項目, 連番26));
                生活機能1リスト.add(get略称20(調査項目, 連番27));
                生活機能1リスト.add(get略称22(調査項目, 連番28));
                生活機能1リスト.add(get略称22(調査項目, 連番29));
                生活機能1リスト.add(get略称22(調査項目, 連番30));
                生活機能1リスト.add(get略称20(調査項目, 連番32));
                生活機能1リスト.add(get略称20(調査項目, 連番33));
                生活機能1リスト.add(get略称13(調査項目, 連番80));
            }
        } else {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                生活機能1リスト.add(get略称10_正常選択肢印刷無(調査項目, 連番20));
                生活機能1リスト.add(get略称10_正常選択肢印刷無(調査項目, 連番21));
                生活機能1リスト.add(get略称11_正常選択肢印刷無(調査項目, 連番22));
                生活機能1リスト.add(get略称10_正常選択肢印刷無(調査項目, 連番23));
                生活機能1リスト.add(get略称10_正常選択肢印刷無(調査項目, 連番24));
                生活機能1リスト.add(get略称10_正常選択肢印刷無(調査項目, 連番25));
                生活機能1リスト.add(get略称12_正常選択肢印刷無(調査項目, 連番26));
                生活機能1リスト.add(get略称12_正常選択肢印刷無(調査項目, 連番27));
                生活機能1リスト.add(get略称12_正常選択肢印刷無(調査項目, 連番28));
                生活機能1リスト.add(get略称10_正常選択肢印刷無(調査項目, 連番29));
                生活機能1リスト.add(get略称10_正常選択肢印刷無(調査項目, 連番30));
                生活機能1リスト.add(get略称13_正常選択肢印刷無(調査項目, 連番31));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番17));
                生活機能1リスト.add(RString.EMPTY);
                生活機能1リスト.add(get略称33_正常選択肢印刷無(調査項目, 連番25));
                生活機能1リスト.add(get略称33_正常選択肢印刷無(調査項目, 連番30));
                生活機能1リスト.add(RString.EMPTY);
                生活機能1リスト.add(RString.EMPTY);
                生活機能1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番31));
                生活機能1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番32));
                生活機能1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番33));
                生活機能1リスト.add(get略称34_正常選択肢印刷無(調査項目, 連番36));
                生活機能1リスト.add(get略称34_正常選択肢印刷無(調査項目, 連番37));
                生活機能1リスト.add(RString.EMPTY);
            }
            if (識別コード02A.equals(厚労省IF識別コード)) {
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番16));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番17));
                生活機能1リスト.add(get略称11_正常選択肢印刷無(調査項目, 連番23));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番24));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番26));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番27));
                生活機能1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番28));
                生活機能1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番29));
                生活機能1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番30));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番32));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番33));
                生活機能1リスト.add(RString.EMPTY);
            }
            if (識別コード06A.equals(厚労省IF識別コード)) {
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番16));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番17));
                生活機能1リスト.add(get略称11_正常選択肢印刷無(調査項目, 連番23));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番24));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番26));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番27));
                生活機能1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番28));
                生活機能1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番29));
                生活機能1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番30));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番32));
                生活機能1リスト.add(get略称20_正常選択肢印刷無(調査項目, 連番33));
                生活機能1リスト.add(get略称13_正常選択肢印刷無(調査項目, 連番80));
            }
        }
        return 生活機能1リスト;
    }

    private static List<RString> set認知機能差分02A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称14(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番32
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番40 : 連番46));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番42, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番33
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番42 : 連番48));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番43, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番34
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番43 : 連番49));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番44, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番35
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番44 : 連番50));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番45, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番36
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番45 : 連番51));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番37
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番46 : 連番52));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番47, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番38
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番47 : 連番53));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番57, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称16(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番39
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番57 : 連番63));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番59, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称16(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番40
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番59 : 連番65));
        } else {
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称14_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番32
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番40 : 連番46));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番42, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番33
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番42 : 連番48));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番43, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番34
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番43 : 連番49));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番44, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番35
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番44 : 連番50));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番45, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番36
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番45 : 連番51));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番37
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番46 : 連番52));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番47, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番38
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番47 : 連番53));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番57, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称16_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番39
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番57 : 連番63));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番59, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称16_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番40
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番59 : 連番65));
        }
        return 認知機能4リスト;
    }

    private static List<RString> set認知機能差分99A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称14(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番32
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番40 : 連番46));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番48, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番33
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番42 : 連番48));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番49, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番34
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番43 : 連番49));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番50, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番35
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番44 : 連番50));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番51, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番36
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番45 : 連番51));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番52, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番37
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番46 : 連番52));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番53, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番38
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番47 : 連番53));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番63, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称16(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番39
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番57 : 連番63));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番65, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称16(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番40
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番59 : 連番65));
        } else {
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称14_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番32
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番40 : 連番46));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番48, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番33
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番42 : 連番48));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番49, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番34
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番43 : 連番49));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番50, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番35
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番44 : 連番50));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番51, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番36
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番45 : 連番51));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番52, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番37
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番46 : 連番52));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番53, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称15_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番38
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番47 : 連番53));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番63, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称16_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番39
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番57 : 連番63));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番65, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : get略称16_正常選択肢印刷無(dbt5211Entity, is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? 連番40
                            : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? 連番59 : 連番65));
        }
        return 認知機能4リスト;
    }

    private static RString 機能差分結果(List<NinteichosahyoChosaItem> 意見書項目,
            List<NinteichosahyoChosaItem> 前回意見書項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get調査項目())) {
            今回調査 = 意見書項目.get(連番).get調査項目();
        }
        if (連番 < 前回意見書項目.size() && !RString.isNullOrEmpty(前回意見書項目.get(連番).get調査項目())) {
            RString 前回調査 = 前回意見書項目.get(連番).get調査項目();
            if (!今回調査.equals(前回調査)) {
                return 前回調査;
            }
        }
        return RString.EMPTY;
    }

    private static RString 機能差分結果(List<NinteichosahyoChosaItem> 意見書項目,
            List<NinteichosahyoChosaItem> 前回意見書項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get調査項目())) {
            今回調査 = 意見書項目.get(連番).get調査項目();
        }
        if (連番 < 前回意見書項目.size()) {
            int 前回連番 = change連番_認知機能(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回意見書項目.get(前回連番).get調査項目())) {
                RString 前回調査 = 前回意見書項目.get(前回連番).get調査項目();
                if (!今回調査.equals(前回調査)) {
                    return 前回調査;
                }
            }
        }
        return RString.EMPTY;
    }

    private static List<RString> get身体機能09B(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString get略称01_正常選択肢印刷無) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (印字する.equals(get略称01_正常選択肢印刷無)) {
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番6, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01(dbt5211Entity, 連番6) : get略称01(dbt5211Entity, 連番7));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番7, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01(dbt5211Entity, 連番7) : get略称01(dbt5211Entity, 連番8));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番8, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01(dbt5211Entity, 連番8) : get略称01(dbt5211Entity, 連番10));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番9, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番9) : get略称02(dbt5211Entity, 連番11));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番10, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番10) : get略称02(dbt5211Entity, 連番12));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番11, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称03(dbt5211Entity, 連番11) : get略称03(dbt5211Entity, 連番13));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番12, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04(dbt5211Entity, 連番12)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称04(dbt5211Entity, 連番14) : get略称04(dbt5211Entity, 連番15));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番13, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番13)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番15) : get略称02(dbt5211Entity, 連番16));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番14, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番14) : get略称02(dbt5211Entity, 連番18));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番15, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04(dbt5211Entity, 連番15) : get略称04(dbt5211Entity, 連番19));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番16, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称06(dbt5211Entity, 連番16)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称21(dbt5211Entity, 連番20) : get略称21(dbt5211Entity, 連番21));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番17, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称07(dbt5211Entity, 連番17)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番31) : get略称22(dbt5211Entity, 連番34));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番18, 連番13, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称08(dbt5211Entity, 連番18)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称08(dbt5211Entity, 連番38) : get略称08(dbt5211Entity, 連番44));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番19, 連番14, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称09(dbt5211Entity, 連番19)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称09(dbt5211Entity, 連番39) : get略称09(dbt5211Entity, 連番45));
        } else {
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番6, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01_正常選択肢印刷無(dbt5211Entity, 連番6) : get略称01_正常選択肢印刷無(dbt5211Entity, 連番7));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番7, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01_正常選択肢印刷無(dbt5211Entity, 連番7) : get略称01_正常選択肢印刷無(dbt5211Entity, 連番8));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番8, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01_正常選択肢印刷無(dbt5211Entity, 連番8) : get略称01_正常選択肢印刷無(dbt5211Entity, 連番10));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番9, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番9) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番11));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番10, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番10) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番12));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番11, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称03_正常選択肢印刷無(dbt5211Entity, 連番11) : get略称03_正常選択肢印刷無(dbt5211Entity, 連番13));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番12, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04_正常選択肢印刷無(dbt5211Entity, 連番12)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称04_正常選択肢印刷無(dbt5211Entity, 連番14) : get略称04_正常選択肢印刷無(dbt5211Entity, 連番15));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番13, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番13)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番15) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番16));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番14, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番14) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番18));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番15, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04_正常選択肢印刷無(dbt5211Entity, 連番15) : get略称04_正常選択肢印刷無(dbt5211Entity, 連番19));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番16, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称06_正常選択肢印刷無(dbt5211Entity, 連番16)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称21_正常選択肢印刷無(dbt5211Entity, 連番20) : get略称21_正常選択肢印刷無(dbt5211Entity, 連番21));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番17, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称07_正常選択肢印刷無(dbt5211Entity, 連番17)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番31) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番34));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番18, 連番13, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称08_正常選択肢印刷無(dbt5211Entity, 連番18)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称08_正常選択肢印刷無(dbt5211Entity, 連番38) : get略称08_正常選択肢印刷無(dbt5211Entity, 連番44));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番19, 連番14, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称09_正常選択肢印刷無(dbt5211Entity, 連番19)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称09_正常選択肢印刷無(dbt5211Entity, 連番39) : get略称09_正常選択肢印刷無(dbt5211Entity, 連番45));
        }
        return 身体機能_起居動作4リスト;
    }

    private static List<RString> get身体機能02A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番7, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01(dbt5211Entity, 連番6) : get略称01(dbt5211Entity, 連番7));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番8, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01(dbt5211Entity, 連番7) : get略称01(dbt5211Entity, 連番8));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番10, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01(dbt5211Entity, 連番8) : get略称01(dbt5211Entity, 連番10));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番11, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番9) : get略称02(dbt5211Entity, 連番11));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番12, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番10) : get略称02(dbt5211Entity, 連番12));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番13, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称03(dbt5211Entity, 連番11) : get略称03(dbt5211Entity, 連番13));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番14, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04(dbt5211Entity, 連番12)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称04(dbt5211Entity, 連番14) : get略称04(dbt5211Entity, 連番15));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番15, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番13)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番15) : get略称02(dbt5211Entity, 連番16));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番18, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番14) : get略称02(dbt5211Entity, 連番18));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番19, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04(dbt5211Entity, 連番15) : get略称04(dbt5211Entity, 連番19));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番20, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称06(dbt5211Entity, 連番16)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称21(dbt5211Entity, 連番20) : get略称21(dbt5211Entity, 連番21));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番31, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称07(dbt5211Entity, 連番17)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番31) : get略称22(dbt5211Entity, 連番34));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番38, 連番13, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称08(dbt5211Entity, 連番18)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称08(dbt5211Entity, 連番38) : get略称08(dbt5211Entity, 連番44));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番39, 連番14, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称09(dbt5211Entity, 連番19)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称09(dbt5211Entity, 連番39) : get略称09(dbt5211Entity, 連番45));
        } else {
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番7, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01_正常選択肢印刷無(dbt5211Entity, 連番6) : get略称01_正常選択肢印刷無(dbt5211Entity, 連番7));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番8, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01_正常選択肢印刷無(dbt5211Entity, 連番7) : get略称01_正常選択肢印刷無(dbt5211Entity, 連番8));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番10, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01_正常選択肢印刷無(dbt5211Entity, 連番8) : get略称01_正常選択肢印刷無(dbt5211Entity, 連番10));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番11, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番9) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番11));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番12, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番10) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番12));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番13, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称03_正常選択肢印刷無(dbt5211Entity, 連番11) : get略称03_正常選択肢印刷無(dbt5211Entity, 連番13));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番14, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04_正常選択肢印刷無(dbt5211Entity, 連番12)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称04_正常選択肢印刷無(dbt5211Entity, 連番14) : get略称04_正常選択肢印刷無(dbt5211Entity, 連番15));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番15, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番13)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番15) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番16));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番18, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番14) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番18));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番19, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04_正常選択肢印刷無(dbt5211Entity, 連番15) : get略称04_正常選択肢印刷無(dbt5211Entity, 連番19));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番20, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称06_正常選択肢印刷無(dbt5211Entity, 連番16)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称21_正常選択肢印刷無(dbt5211Entity, 連番20) : get略称21_正常選択肢印刷無(dbt5211Entity, 連番21));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番31, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称07_正常選択肢印刷無(dbt5211Entity, 連番17)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番31) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番34));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番38, 連番13, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称08_正常選択肢印刷無(dbt5211Entity, 連番18)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称08_正常選択肢印刷無(dbt5211Entity, 連番38) : get略称08_正常選択肢印刷無(dbt5211Entity, 連番44));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番39, 連番14, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称09_正常選択肢印刷無(dbt5211Entity, 連番19)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称09_正常選択肢印刷無(dbt5211Entity, 連番39) : get略称09_正常選択肢印刷無(dbt5211Entity, 連番45));
        }
        return 身体機能_起居動作4リスト;
    }

    private static List<RString> get身体機能99A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番7, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01(dbt5211Entity, 連番6) : get略称01(dbt5211Entity, 連番7));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番8, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01(dbt5211Entity, 連番7) : get略称01(dbt5211Entity, 連番8));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番10, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01(dbt5211Entity, 連番8) : get略称01(dbt5211Entity, 連番10));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番11, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番9) : get略称02(dbt5211Entity, 連番11));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番12, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番10) : get略称02(dbt5211Entity, 連番12));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番13, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称03(dbt5211Entity, 連番11) : get略称03(dbt5211Entity, 連番13));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番15, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04(dbt5211Entity, 連番12)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称04(dbt5211Entity, 連番14) : get略称04(dbt5211Entity, 連番15));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番16, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番13)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番15) : get略称02(dbt5211Entity, 連番16));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番18, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02(dbt5211Entity, 連番14) : get略称02(dbt5211Entity, 連番18));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番19, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04(dbt5211Entity, 連番15) : get略称04(dbt5211Entity, 連番19));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番21, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称06(dbt5211Entity, 連番16)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称21(dbt5211Entity, 連番20) : get略称21(dbt5211Entity, 連番21));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番34, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称07(dbt5211Entity, 連番17)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22(dbt5211Entity, 連番31) : get略称22(dbt5211Entity, 連番34));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番44, 連番13, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称08(dbt5211Entity, 連番18)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称08(dbt5211Entity, 連番38) : get略称08(dbt5211Entity, 連番44));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番45, 連番14, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称09(dbt5211Entity, 連番19)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称09(dbt5211Entity, 連番39) : get略称09(dbt5211Entity, 連番45));
        } else {
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番7, 連番1, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01_正常選択肢印刷無(dbt5211Entity, 連番6) : get略称01_正常選択肢印刷無(dbt5211Entity, 連番7));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番8, 連番2, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01_正常選択肢印刷無(dbt5211Entity, 連番7) : get略称01_正常選択肢印刷無(dbt5211Entity, 連番8));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番10, 連番3, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称01_正常選択肢印刷無(dbt5211Entity, 連番8) : get略称01_正常選択肢印刷無(dbt5211Entity, 連番10));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番11, 連番4, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番9) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番11));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番12, 連番5, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番10) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番12));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番13, 連番6, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称03_正常選択肢印刷無(dbt5211Entity, 連番11) : get略称03_正常選択肢印刷無(dbt5211Entity, 連番13));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番15, 連番7, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04_正常選択肢印刷無(dbt5211Entity, 連番12)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称04_正常選択肢印刷無(dbt5211Entity, 連番14) : get略称04_正常選択肢印刷無(dbt5211Entity, 連番15));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番16, 連番8, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番13)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番15) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番16));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番18, 連番9, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称02_正常選択肢印刷無(dbt5211Entity, 連番14) : get略称02_正常選択肢印刷無(dbt5211Entity, 連番18));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番19, 連番10, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称04_正常選択肢印刷無(dbt5211Entity, 連番15) : get略称04_正常選択肢印刷無(dbt5211Entity, 連番19));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番21, 連番11, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称06_正常選択肢印刷無(dbt5211Entity, 連番16)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称21_正常選択肢印刷無(dbt5211Entity, 連番20) : get略称21_正常選択肢印刷無(dbt5211Entity, 連番21));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番34, 連番12, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称07_正常選択肢印刷無(dbt5211Entity, 連番17)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称22_正常選択肢印刷無(dbt5211Entity, 連番31) : get略称22_正常選択肢印刷無(dbt5211Entity, 連番34));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番44, 連番13, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称08_正常選択肢印刷無(dbt5211Entity, 連番18)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称08_正常選択肢印刷無(dbt5211Entity, 連番38) : get略称08_正常選択肢印刷無(dbt5211Entity, 連番44));
            身体機能_起居動作4リスト.add(機能差分結果_身体機能(調査項目, dbt5211Entity, 連番45, 連番14, 前回厚労省IF識別コード).isEmpty() ? RString.EMPTY
                    : is厚労省識別コードが09B_09A(前回厚労省IF識別コード) ? get略称09_正常選択肢印刷無(dbt5211Entity, 連番19)
                    : is厚労省識別コードが06A_02A(前回厚労省IF識別コード) ? get略称09_正常選択肢印刷無(dbt5211Entity, 連番39) : get略称09_正常選択肢印刷無(dbt5211Entity, 連番45));
        }
        return 身体機能_起居動作4リスト;
    }

    private static List<RString> 身体機能差分(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 0).isEmpty() ? RString.EMPTY : get略称01(dbt5211Entity, 0));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番1).isEmpty() ? RString.EMPTY : get略称01(dbt5211Entity, 連番1));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番2).isEmpty() ? RString.EMPTY : get略称01(dbt5211Entity, 連番2));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番3).isEmpty() ? RString.EMPTY : get略称01(dbt5211Entity, 連番3));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番4).isEmpty() ? RString.EMPTY : get略称01(dbt5211Entity, 連番4));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番5).isEmpty() ? RString.EMPTY : get略称01(dbt5211Entity, 連番5));
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                身体機能_起居動作4リスト.addAll(get身体機能09B(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無));
            }
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード06A.equals(厚労省IF識別コード)) {
                身体機能_起居動作4リスト.addAll(get身体機能02A(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                身体機能_起居動作4リスト.addAll(get身体機能99A(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無));
            }
        } else {
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 0).isEmpty() ? RString.EMPTY : get略称01_正常選択肢印刷無(dbt5211Entity, 0));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番1).isEmpty() ? RString.EMPTY : get略称01_正常選択肢印刷無(dbt5211Entity, 連番1));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番2).isEmpty() ? RString.EMPTY : get略称01_正常選択肢印刷無(dbt5211Entity, 連番2));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番3).isEmpty() ? RString.EMPTY : get略称01_正常選択肢印刷無(dbt5211Entity, 連番3));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番4).isEmpty() ? RString.EMPTY : get略称01_正常選択肢印刷無(dbt5211Entity, 連番4));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番5).isEmpty() ? RString.EMPTY : get略称01_正常選択肢印刷無(dbt5211Entity, 連番5));
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                身体機能_起居動作4リスト.addAll(get身体機能09B(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無));
            }
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード06A.equals(厚労省IF識別コード)) {
                身体機能_起居動作4リスト.addAll(get身体機能02A(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                身体機能_起居動作4リスト.addAll(get身体機能99A(調査項目, dbt5211Entity, 前回厚労省IF識別コード, 前回正常選択肢印刷有無));
            }
        }
        return 身体機能_起居動作4リスト;
    }

    private static List<RString> 身体機能全部(List<NinteichosahyoChosaItem> dbt5211Entity, RString 前回厚労省IF識別コード, RString 前回正常選択肢印刷有無) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (印字する.equals(前回正常選択肢印刷有無)) {
            身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 0));
            身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番1));
            身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番2));
            身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番3));
            身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番4));
            身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番5));
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番6));
                身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番7));
                身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番8));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番9));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番10));
                身体機能_起居動作4リスト.add(get略称03(dbt5211Entity, 連番11));
                身体機能_起居動作4リスト.add(get略称04(dbt5211Entity, 連番12));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番13));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番14));
                身体機能_起居動作4リスト.add(get略称04(dbt5211Entity, 連番15));
                身体機能_起居動作4リスト.add(get略称06(dbt5211Entity, 連番16));
                身体機能_起居動作4リスト.add(get略称07(dbt5211Entity, 連番17));
                身体機能_起居動作4リスト.add(get略称08(dbt5211Entity, 連番18));
                身体機能_起居動作4リスト.add(get略称09(dbt5211Entity, 連番19));
            }
            if (識別コード02A.equals(前回厚労省IF識別コード) || 識別コード06A.equals(前回厚労省IF識別コード)) {
                身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番7));
                身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番8));
                身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番10));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番11));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番12));
                身体機能_起居動作4リスト.add(get略称03(dbt5211Entity, 連番13));
                身体機能_起居動作4リスト.add(get略称04(dbt5211Entity, 連番14));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番15));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番18));
                身体機能_起居動作4リスト.add(get略称04(dbt5211Entity, 連番19));
                身体機能_起居動作4リスト.add(get略称21(dbt5211Entity, 連番20));
                身体機能_起居動作4リスト.add(get略称22(dbt5211Entity, 連番31));
                身体機能_起居動作4リスト.add(get略称08(dbt5211Entity, 連番38));
                身体機能_起居動作4リスト.add(get略称09(dbt5211Entity, 連番39));
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番7));
                身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番8));
                身体機能_起居動作4リスト.add(get略称01(dbt5211Entity, 連番10));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番11));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番12));
                身体機能_起居動作4リスト.add(get略称03(dbt5211Entity, 連番13));
                身体機能_起居動作4リスト.add(get略称04(dbt5211Entity, 連番15));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番16));
                身体機能_起居動作4リスト.add(get略称02(dbt5211Entity, 連番18));
                身体機能_起居動作4リスト.add(get略称04(dbt5211Entity, 連番19));
                身体機能_起居動作4リスト.add(get略称21(dbt5211Entity, 連番21));
                身体機能_起居動作4リスト.add(get略称22(dbt5211Entity, 連番34));
                身体機能_起居動作4リスト.add(get略称08(dbt5211Entity, 連番44));
                身体機能_起居動作4リスト.add(get略称09(dbt5211Entity, 連番45));
            }
        } else {
            身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 0));
            身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番1));
            身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番2));
            身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番3));
            身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番4));
            身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番5));
            if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
                身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番6));
                身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番7));
                身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番8));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番9));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番10));
                身体機能_起居動作4リスト.add(get略称03_正常選択肢印刷無(dbt5211Entity, 連番11));
                身体機能_起居動作4リスト.add(get略称04_正常選択肢印刷無(dbt5211Entity, 連番12));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番13));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番14));
                身体機能_起居動作4リスト.add(get略称04_正常選択肢印刷無(dbt5211Entity, 連番15));
                身体機能_起居動作4リスト.add(get略称06_正常選択肢印刷無(dbt5211Entity, 連番16));
                身体機能_起居動作4リスト.add(get略称07_正常選択肢印刷無(dbt5211Entity, 連番17));
                身体機能_起居動作4リスト.add(get略称08_正常選択肢印刷無(dbt5211Entity, 連番18));
                身体機能_起居動作4リスト.add(get略称09_正常選択肢印刷無(dbt5211Entity, 連番19));
            }
            if (識別コード02A.equals(前回厚労省IF識別コード) || 識別コード06A.equals(前回厚労省IF識別コード)) {
                身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番7));
                身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番8));
                身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番10));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番11));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番12));
                身体機能_起居動作4リスト.add(get略称03_正常選択肢印刷無(dbt5211Entity, 連番13));
                身体機能_起居動作4リスト.add(get略称04_正常選択肢印刷無(dbt5211Entity, 連番14));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番15));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番18));
                身体機能_起居動作4リスト.add(get略称04_正常選択肢印刷無(dbt5211Entity, 連番19));
                身体機能_起居動作4リスト.add(get略称21_正常選択肢印刷無(dbt5211Entity, 連番20));
                身体機能_起居動作4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番31));
                身体機能_起居動作4リスト.add(get略称08_正常選択肢印刷無(dbt5211Entity, 連番38));
                身体機能_起居動作4リスト.add(get略称09_正常選択肢印刷無(dbt5211Entity, 連番39));
            }
            if (識別コード99A.equals(前回厚労省IF識別コード)) {
                身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番7));
                身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番8));
                身体機能_起居動作4リスト.add(get略称01_正常選択肢印刷無(dbt5211Entity, 連番10));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番11));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番12));
                身体機能_起居動作4リスト.add(get略称03_正常選択肢印刷無(dbt5211Entity, 連番13));
                身体機能_起居動作4リスト.add(get略称04_正常選択肢印刷無(dbt5211Entity, 連番15));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番16));
                身体機能_起居動作4リスト.add(get略称02_正常選択肢印刷無(dbt5211Entity, 連番18));
                身体機能_起居動作4リスト.add(get略称04_正常選択肢印刷無(dbt5211Entity, 連番19));
                身体機能_起居動作4リスト.add(get略称21_正常選択肢印刷無(dbt5211Entity, 連番21));
                身体機能_起居動作4リスト.add(get略称22_正常選択肢印刷無(dbt5211Entity, 連番34));
                身体機能_起居動作4リスト.add(get略称08_正常選択肢印刷無(dbt5211Entity, 連番44));
                身体機能_起居動作4リスト.add(get略称09_正常選択肢印刷無(dbt5211Entity, 連番45));
            }
        }
        return 身体機能_起居動作4リスト;
    }

    private static RString 機能差分結果_身体機能(List<NinteichosahyoChosaItem> 意見書項目,
            List<NinteichosahyoChosaItem> 前回意見書項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get調査項目())) {
            今回調査 = 意見書項目.get(連番).get調査項目();
        }
        if (連番 < 前回意見書項目.size()) {
            int 前回連番 = change連番_身体機能(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回意見書項目.get(前回連番).get調査項目())) {
                RString 前回調査 = 前回意見書項目.get(前回連番).get調査項目();
                if (!今回調査.equals(前回調査)) {
                    return 前回調査;
                }
            }
        }
        return RString.EMPTY;
    }

    private static RString 機能差分結果_生活機能(List<NinteichosahyoChosaItem> 意見書項目,
            List<NinteichosahyoChosaItem> 前回意見書項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get調査項目())) {
            今回調査 = 意見書項目.get(連番).get調査項目();
        }
        if (連番 < 前回意見書項目.size()) {
            int 前回連番 = change連番_生活機能(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回意見書項目.get(前回連番).get調査項目())) {
                RString 前回調査 = 前回意見書項目.get(前回連番).get調査項目();
                if (!今回調査.equals(前回調査)) {
                    return 前回調査;
                }
            }
        }
        return RString.EMPTY;
    }

    private static RString 機能差分結果_精神障害(List<NinteichosahyoChosaItem> 意見書項目,
            List<NinteichosahyoChosaItem> 前回意見書項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get調査項目())) {
            今回調査 = 意見書項目.get(連番).get調査項目();
        }
        if (連番 < 前回意見書項目.size()) {
            int 前回連番 = change連番_精神障害(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回意見書項目.get(前回連番).get調査項目())) {
                RString 前回調査 = 前回意見書項目.get(前回連番).get調査項目();
                if (!今回調査.equals(前回調査)) {
                    return 前回調査;
                }
            }
        }
        return RString.EMPTY;
    }

    private static RString 機能差分結果_社会生活(List<NinteichosahyoChosaItem> 意見書項目,
            List<NinteichosahyoChosaItem> 前回意見書項目, int 連番, int 項目連番, RString 前回厚労省IF識別コード) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get調査項目())) {
            今回調査 = 意見書項目.get(連番).get調査項目();
        }
        if (連番 < 前回意見書項目.size()) {
            int 前回連番 = change連番_社会生活(前回厚労省IF識別コード, 項目連番);
            if (前回連番 != 0 && !RString.isNullOrEmpty(前回意見書項目.get(前回連番).get調査項目())) {
                RString 前回調査 = 前回意見書項目.get(前回連番).get調査項目();
                if (!今回調査.equals(前回調査)) {
                    return 前回調査;
                }
            }
        }
        return RString.EMPTY;
    }

    private static int change連番_身体機能(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番6;
            } else if (連番 == 連番2) {
                return 連番7;
            } else if (連番 == 連番3) {
                return 連番8;
            } else if (連番 == 連番4) {
                return 連番9;
            } else if (連番 == 連番5) {
                return 連番10;
            } else if (連番 == 連番6) {
                return 連番11;
            } else if (連番 == 連番7) {
                return 連番12;
            } else if (連番 == 連番8) {
                return 連番13;
            } else if (連番 == 連番9) {
                return 連番14;
            } else if (連番 == 連番10) {
                return 連番15;
            } else if (連番 == 連番11) {
                return 連番16;
            } else if (連番 == 連番12) {
                return 連番17;
            } else if (連番 == 連番13) {
                return 連番18;
            } else if (連番 == 連番14) {
                return 連番19;
            }
        } else if (識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番7;
            } else if (連番 == 連番2) {
                return 連番8;
            } else if (連番 == 連番3) {
                return 連番10;
            } else if (連番 == 連番4) {
                return 連番11;
            } else if (連番 == 連番5) {
                return 連番12;
            } else if (連番 == 連番6) {
                return 連番13;
            } else if (連番 == 連番7) {
                return 連番15;
            } else if (連番 == 連番8) {
                return 連番16;
            } else if (連番 == 連番9) {
                return 連番18;
            } else if (連番 == 連番10) {
                return 連番19;
            } else if (連番 == 連番11) {
                return 連番21;
            } else if (連番 == 連番12) {
                return 連番34;
            } else if (連番 == 連番13) {
                return 連番44;
            } else if (連番 == 連番14) {
                return 連番45;
            }
        } else if (識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番7;
            } else if (連番 == 連番2) {
                return 連番8;
            } else if (連番 == 連番3) {
                return 連番10;
            } else if (連番 == 連番4) {
                return 連番11;
            } else if (連番 == 連番5) {
                return 連番12;
            } else if (連番 == 連番6) {
                return 連番13;
            } else if (連番 == 連番7) {
                return 連番14;
            } else if (連番 == 連番8) {
                return 連番15;
            } else if (連番 == 連番9) {
                return 連番18;
            } else if (連番 == 連番10) {
                return 連番19;
            } else if (連番 == 連番11) {
                return 連番20;
            } else if (連番 == 連番12) {
                return 連番31;
            } else if (連番 == 連番13) {
                return 連番38;
            } else if (連番 == 連番14) {
                return 連番39;
            }
        }
        return 0;
    }

    private static int change連番_生活機能(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番20;
            } else if (連番 == 連番2) {
                return 連番21;
            } else if (連番 == 連番3) {
                return 連番22;
            } else if (連番 == 連番4) {
                return 連番23;
            } else if (連番 == 連番5) {
                return 連番24;
            } else if (連番 == 連番6) {
                return 連番25;
            } else if (連番 == 連番7) {
                return 連番26;
            } else if (連番 == 連番8) {
                return 連番27;
            } else if (連番 == 連番9) {
                return 連番28;
            } else if (連番 == 連番10) {
                return 連番29;
            } else if (連番 == 連番11) {
                return 連番30;
            } else if (連番 == 連番12) {
                return 連番31;
            }
        } else if (識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番17;
            } else if (連番 == 連番3) {
                return 連番25;
            } else if (連番 == 連番4) {
                return 連番30;
            } else if (連番 == 連番7) {
                return 連番31;
            } else if (連番 == 連番8) {
                return 連番32;
            } else if (連番 == 連番9) {
                return 連番33;
            } else if (連番 == 連番10) {
                return 連番36;
            } else if (連番 == 連番11) {
                return 連番37;
            }
        } else if (識別コード06A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番16;
            } else if (連番 == 連番2) {
                return 連番17;
            } else if (連番 == 連番3) {
                return 連番23;
            } else if (連番 == 連番4) {
                return 連番24;
            } else if (連番 == 連番5) {
                return 連番26;
            } else if (連番 == 連番6) {
                return 連番27;
            } else if (連番 == 連番7) {
                return 連番28;
            } else if (連番 == 連番8) {
                return 連番29;
            } else if (連番 == 連番9) {
                return 連番30;
            } else if (連番 == 連番10) {
                return 連番32;
            } else if (連番 == 連番11) {
                return 連番33;
            } else if (連番 == 連番12) {
                return 連番80;
            }
        } else if (識別コード02A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番16;
            } else if (連番 == 連番2) {
                return 連番17;
            } else if (連番 == 連番3) {
                return 連番23;
            } else if (連番 == 連番4) {
                return 連番24;
            } else if (連番 == 連番5) {
                return 連番26;
            } else if (連番 == 連番6) {
                return 連番27;
            } else if (連番 == 連番7) {
                return 連番28;
            } else if (連番 == 連番8) {
                return 連番29;
            } else if (連番 == 連番9) {
                return 連番30;
            } else if (連番 == 連番10) {
                return 連番32;
            } else if (連番 == 連番11) {
                return 連番33;
            }
        }
        return 0;
    }

    private static int change連番_精神障害(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番41;
            } else if (連番 == 連番2) {
                return 連番42;
            } else if (連番 == 連番3) {
                return 連番43;
            } else if (連番 == 連番4) {
                return 連番44;
            } else if (連番 == 連番5) {
                return 連番45;
            } else if (連番 == 連番6) {
                return 連番46;
            } else if (連番 == 連番7) {
                return 連番47;
            } else if (連番 == 連番8) {
                return 連番48;
            } else if (連番 == 連番9) {
                return 連番49;
            } else if (連番 == 連番10) {
                return 連番50;
            } else if (連番 == 連番11) {
                return 連番51;
            } else if (連番 == 連番12) {
                return 連番52;
            } else if (連番 == 連番13) {
                return 連番53;
            } else if (連番 == 連番14) {
                return 連番54;
            } else if (連番 == 連番15) {
                return 連番55;
            }
        } else if (識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番54;
            } else if (連番 == 連番2) {
                return 連番55;
            } else if (連番 == 連番3) {
                return 連番57;
            } else if (連番 == 連番4) {
                return 連番58;
            } else if (連番 == 連番5) {
                return 連番60;
            } else if (連番 == 連番6) {
                return 連番61;
            } else if (連番 == 連番7) {
                return 連番62;
            } else if (連番 == 連番8) {
                return 連番64;
            } else if (連番 == 連番9) {
                return 連番66;
            } else if (連番 == 連番10) {
                return 連番67;
            } else if (連番 == 連番11) {
                return 連番69;
            } else if (連番 == 連番11) {
                return 連番42;
            }
        } else if (識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番48;
            } else if (連番 == 連番2) {
                return 連番49;
            } else if (連番 == 連番3) {
                return 連番51;
            } else if (連番 == 連番4) {
                return 連番52;
            } else if (連番 == 連番5) {
                return 連番54;
            } else if (連番 == 連番6) {
                return 連番55;
            } else if (連番 == 連番7) {
                return 連番56;
            } else if (連番 == 連番8) {
                return 連番58;
            } else if (連番 == 連番9) {
                return 連番60;
            } else if (連番 == 連番10) {
                return 連番61;
            } else if (連番 == 連番11) {
                return 連番63;
            } else if (連番 == 連番12) {
                return 連番66;
            }
        }
        return 0;
    }

    private static int change連番_社会生活(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番56;
            } else if (連番 == 連番2) {
                return 連番57;
            } else if (連番 == 連番3) {
                return 連番58;
            } else if (連番 == 連番4) {
                return 連番59;
            } else if (連番 == 連番5) {
                return 連番60;
            } else if (連番 == 連番6) {
                return 連番61;
            }
        } else if (識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番34;
            } else if (連番 == 連番2) {
                return 連番35;
            } else if (連番 == 連番3) {
                return 連番37;
            }
        } else if (識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番40;
            } else if (連番 == 連番2) {
                return 連番41;
            }
        }
        return 0;
    }

    private static int change連番_特別な医療1(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番62;
            } else if (連番 == 連番2) {
                return 連番63;
            } else if (連番 == 連番3) {
                return 連番64;
            } else if (連番 == 連番4) {
                return 連番65;
            } else if (連番 == 連番5) {
                return 連番66;
            } else if (連番 == 連番6) {
                return 連番67;
            }
        } else if (識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番73;
            } else if (連番 == 連番2) {
                return 連番74;
            } else if (連番 == 連番3) {
                return 連番75;
            } else if (連番 == 連番4) {
                return 連番76;
            } else if (連番 == 連番5) {
                return 連番77;
            } else if (連番 == 連番6) {
                return 連番78;
            }
        } else if (識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番67;
            } else if (連番 == 連番2) {
                return 連番68;
            } else if (連番 == 連番3) {
                return 連番69;
            } else if (連番 == 連番4) {
                return 連番70;
            } else if (連番 == 連番5) {
                return 連番71;
            } else if (連番 == 連番6) {
                return 連番72;
            }
        }
        return 0;
    }

    private static int change連番_特別な医療2(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番68;
            } else if (連番 == 連番2) {
                return 連番69;
            } else if (連番 == 連番3) {
                return 連番70;
            } else if (連番 == 連番4) {
                return 連番71;
            } else if (連番 == 連番5) {
                return 連番72;
            } else if (連番 == 連番6) {
                return 連番73;
            }
        } else if (識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番79;
            } else if (連番 == 連番2) {
                return 連番80;
            } else if (連番 == 連番3) {
                return 連番81;
            } else if (連番 == 連番4) {
                return 連番82;
            } else if (連番 == 連番5) {
                return 連番83;
            } else if (連番 == 連番6) {
                return 連番84;
            }
        } else if (識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番73;
            } else if (連番 == 連番2) {
                return 連番74;
            } else if (連番 == 連番3) {
                return 連番75;
            } else if (連番 == 連番4) {
                return 連番76;
            } else if (連番 == 連番5) {
                return 連番77;
            } else if (連番 == 連番6) {
                return 連番78;
            }
        }
        return 0;
    }

    private static int change連番_認知機能(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番32;
            } else if (連番 == 連番2) {
                return 連番33;
            } else if (連番 == 連番3) {
                return 連番34;
            } else if (連番 == 連番4) {
                return 連番35;
            } else if (連番 == 連番5) {
                return 連番36;
            } else if (連番 == 連番6) {
                return 連番37;
            } else if (連番 == 連番7) {
                return 連番38;
            } else if (連番 == 連番8) {
                return 連番39;
            } else if (連番 == 連番9) {
                return 連番40;
            }
        } else if (識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番46;
            } else if (連番 == 連番2) {
                return 連番48;
            } else if (連番 == 連番3) {
                return 連番49;
            } else if (連番 == 連番4) {
                return 連番50;
            } else if (連番 == 連番5) {
                return 連番51;
            } else if (連番 == 連番6) {
                return 連番52;
            } else if (連番 == 連番7) {
                return 連番53;
            } else if (連番 == 連番8) {
                return 連番63;
            } else if (連番 == 連番9) {
                return 連番65;
            }
        } else if (識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番40;
            } else if (連番 == 連番2) {
                return 連番42;
            } else if (連番 == 連番3) {
                return 連番43;
            } else if (連番 == 連番4) {
                return 連番44;
            } else if (連番 == 連番5) {
                return 連番45;
            } else if (連番 == 連番6) {
                return 連番46;
            } else if (連番 == 連番7) {
                return 連番47;
            } else if (連番 == 連番8) {
                return 連番57;
            } else if (連番 == 連番9) {
                return 連番59;
            }
        }
        return 0;
    }

    private static int change主治医差分連番(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)
                || 識別コード06A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番13;
            } else if (連番 == 連番2) {
                return 連番14;
            } else if (連番 == 連番3) {
                return 連番15;
            } else if (連番 == 連番4) {
                return 連番16;
            } else if (連番 == 連番5) {
                return 連番68;
            }
        } else if (識別コード02A.equals(前回厚労省IF識別コード) || 識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番14;
            } else if (連番 == 連番2) {
                return 連番15;
            } else if (連番 == 連番3) {
                return 連番16;
            } else if (連番 == 連番4) {
                return 連番17;
            } else if (連番 == 連番5) {
                return 連番18;
            }
        }
        return 0;
    }

    private static boolean is厚労省識別コードが09B_09A(RString 前回厚労省IF識別コード) {
        return 識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード);
    }

    private static boolean is厚労省識別コードが06A_02A(RString 前回厚労省IF識別コード) {
        return 識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード);
    }

    private static boolean is厚労省識別コードが06A(RString 前回厚労省IF識別コード) {
        return 識別コード06A.equals(前回厚労省IF識別コード);
    }

    private static List<RString> set身体機能_起居動作4リスト(List<NinteichosahyoChosaItem> 調査項目, List<NinteichosahyoChosaItem> 前回調査項目,
            RString 認定調査前回結果印刷有無, RString 前回正常選択肢印刷有無, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (!前回調査項目.isEmpty()) {
            if (差分のみ印刷.equals(認定調査前回結果印刷有無)) {
                return 身体機能差分(調査項目, 前回調査項目, 厚労省IF識別コード, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
            if (印刷しない.equals(認定調査前回結果印刷有無)) {
                for (int count = 1; count <= COUNT_20; count++) {
                    身体機能_起居動作4リスト.add(RString.EMPTY);
                }
            }
            if (印刷する.equals(認定調査前回結果印刷有無)) {
                return 身体機能全部(前回調査項目, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
        } else {
            for (int count = 1; count <= COUNT_20; count++) {
                身体機能_起居動作4リスト.add(RString.EMPTY);
            }
        }
        return 身体機能_起居動作4リスト;
    }

    private static List<RString> set身体機能_起居動作3リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 身体機能_起居動作3リスト = new ArrayList<>();
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 0));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番1));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番2));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番3));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番4));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番5));
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番6, 連番1, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番7, 連番2, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番8, 連番3, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番9, 連番4, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番10, 連番5, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番11, 連番6, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番12, 連番7, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番13, 連番8, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番14, 連番9, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番15, 連番10, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番16, 連番11, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番17, 連番12, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番18, 連番13, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番19, 連番14, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番7, 連番1, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番8, 連番2, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番10, 連番3, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番11, 連番4, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番12, 連番5, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番13, 連番6, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番14, 連番7, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番15, 連番8, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番18, 連番9, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番19, 連番10, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番20, 連番11, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番31, 連番12, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番38, 連番13, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番39, 連番14, 前回厚労省IF識別コード));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番7, 連番1, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番8, 連番2, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番10, 連番3, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番11, 連番4, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番12, 連番5, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番13, 連番6, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番15, 連番7, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番16, 連番8, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番18, 連番9, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番19, 連番10, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番21, 連番11, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番34, 連番12, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番44, 連番13, 前回厚労省IF識別コード));
            身体機能_起居動作3リスト.add(get状況結果_身体機能(調査項目, 前回調査項目, 連番45, 連番14, 前回厚労省IF識別コード));
        }
        return 身体機能_起居動作3リスト;
    }

    private static List<RString> set身体機能_起居動作2リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 身体機能_起居動作2リスト = new ArrayList<>();
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 0));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番1));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番2));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番3));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番4));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番5));
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番6, 連番1, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番7, 連番2, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番8, 連番3, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番9, 連番4, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番10, 連番5, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番11, 連番6, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番12, 連番7, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番13, 連番8, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番14, 連番9, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番15, 連番10, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番16, 連番11, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番17, 連番12, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番18, 連番13, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番19, 連番14, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番7, 連番1, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番8, 連番2, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番10, 連番3, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番11, 連番4, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番12, 連番5, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番13, 連番6, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番14, 連番7, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番15, 連番8, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番18, 連番9, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番19, 連番10, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番20, 連番11, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番31, 連番12, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番38, 連番13, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番39, 連番14, 前回厚労省IF識別コード));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番7, 連番1, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番8, 連番2, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番10, 連番3, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番11, 連番4, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番12, 連番5, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番13, 連番6, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番15, 連番7, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番16, 連番8, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番18, 連番9, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番19, 連番10, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番21, 連番11, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番34, 連番12, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番44, 連番13, 前回厚労省IF識別コード));
            身体機能_起居動作2リスト.add(get調査連番_身体機能(調査項目, 前回調査項目, 連番45, 連番14, 前回厚労省IF識別コード));
        }
        return 身体機能_起居動作2リスト;
    }

    private static List<RString> set身体機能_起居動作1リスト(List<NinteichosahyoChosaItem> 調査項目,
            RString 正常選択肢印刷有無, RString 厚労省IF識別コード) {
        List<RString> 身体機能_起居動作1リスト = new ArrayList<>();
        if (印字する.equals(正常選択肢印刷有無)) {
            身体機能_起居動作1リスト.add(get略称01(調査項目, 0));
            身体機能_起居動作1リスト.add(get略称01(調査項目, 連番1));
            身体機能_起居動作1リスト.add(get略称01(調査項目, 連番2));
            身体機能_起居動作1リスト.add(get略称01(調査項目, 連番3));
            身体機能_起居動作1リスト.add(get略称01(調査項目, 連番4));
            身体機能_起居動作1リスト.add(get略称01(調査項目, 連番5));
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                身体機能_起居動作1リスト.add(get略称01(調査項目, 連番6));
                身体機能_起居動作1リスト.add(get略称01(調査項目, 連番7));
                身体機能_起居動作1リスト.add(get略称01(調査項目, 連番8));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番9));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番10));
                身体機能_起居動作1リスト.add(get略称03(調査項目, 連番11));
                身体機能_起居動作1リスト.add(get略称04(調査項目, 連番12));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番13));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番14));
                身体機能_起居動作1リスト.add(get略称04(調査項目, 連番15));
                身体機能_起居動作1リスト.add(get略称06(調査項目, 連番16));
                身体機能_起居動作1リスト.add(get略称07(調査項目, 連番17));
                身体機能_起居動作1リスト.add(get略称08(調査項目, 連番18));
                身体機能_起居動作1リスト.add(get略称09(調査項目, 連番19));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                身体機能_起居動作1リスト.add(get略称01(調査項目, 連番7));
                身体機能_起居動作1リスト.add(get略称01(調査項目, 連番8));
                身体機能_起居動作1リスト.add(get略称01(調査項目, 連番10));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番11));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番12));
                身体機能_起居動作1リスト.add(get略称03(調査項目, 連番13));
                身体機能_起居動作1リスト.add(get略称04(調査項目, 連番14));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番15));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番18));
                身体機能_起居動作1リスト.add(get略称04(調査項目, 連番19));
                身体機能_起居動作1リスト.add(get略称21(調査項目, 連番20));
                身体機能_起居動作1リスト.add(get略称22(調査項目, 連番31));
                身体機能_起居動作1リスト.add(get略称08(調査項目, 連番38));
                身体機能_起居動作1リスト.add(get略称09(調査項目, 連番39));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                身体機能_起居動作1リスト.add(get略称01(調査項目, 連番7));
                身体機能_起居動作1リスト.add(get略称01(調査項目, 連番8));
                身体機能_起居動作1リスト.add(get略称01(調査項目, 連番10));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番11));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番12));
                身体機能_起居動作1リスト.add(get略称03(調査項目, 連番13));
                身体機能_起居動作1リスト.add(get略称04(調査項目, 連番15));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番16));
                身体機能_起居動作1リスト.add(get略称02(調査項目, 連番18));
                身体機能_起居動作1リスト.add(get略称04(調査項目, 連番19));
                身体機能_起居動作1リスト.add(get略称21(調査項目, 連番21));
                身体機能_起居動作1リスト.add(get略称22(調査項目, 連番34));
                身体機能_起居動作1リスト.add(get略称08(調査項目, 連番44));
                身体機能_起居動作1リスト.add(get略称09(調査項目, 連番45));
            }
        } else {
            身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 0));
            身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番1));
            身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番2));
            身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番3));
            身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番4));
            身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番5));
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番6));
                身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番7));
                身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番8));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番9));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番10));
                身体機能_起居動作1リスト.add(get略称03_正常選択肢印刷無(調査項目, 連番11));
                身体機能_起居動作1リスト.add(get略称04_正常選択肢印刷無(調査項目, 連番12));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番13));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番14));
                身体機能_起居動作1リスト.add(get略称04_正常選択肢印刷無(調査項目, 連番15));
                身体機能_起居動作1リスト.add(get略称06_正常選択肢印刷無(調査項目, 連番16));
                身体機能_起居動作1リスト.add(get略称07_正常選択肢印刷無(調査項目, 連番17));
                身体機能_起居動作1リスト.add(get略称08_正常選択肢印刷無(調査項目, 連番18));
                身体機能_起居動作1リスト.add(get略称09_正常選択肢印刷無(調査項目, 連番19));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番7));
                身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番8));
                身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番10));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番11));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番12));
                身体機能_起居動作1リスト.add(get略称03_正常選択肢印刷無(調査項目, 連番13));
                身体機能_起居動作1リスト.add(get略称04_正常選択肢印刷無(調査項目, 連番14));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番15));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番18));
                身体機能_起居動作1リスト.add(get略称04_正常選択肢印刷無(調査項目, 連番19));
                身体機能_起居動作1リスト.add(get略称21_正常選択肢印刷無(調査項目, 連番20));
                身体機能_起居動作1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番31));
                身体機能_起居動作1リスト.add(get略称08_正常選択肢印刷無(調査項目, 連番38));
                身体機能_起居動作1リスト.add(get略称09_正常選択肢印刷無(調査項目, 連番39));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番7));
                身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番8));
                身体機能_起居動作1リスト.add(get略称01_正常選択肢印刷無(調査項目, 連番10));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番11));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番12));
                身体機能_起居動作1リスト.add(get略称03_正常選択肢印刷無(調査項目, 連番13));
                身体機能_起居動作1リスト.add(get略称04_正常選択肢印刷無(調査項目, 連番15));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番16));
                身体機能_起居動作1リスト.add(get略称02_正常選択肢印刷無(調査項目, 連番18));
                身体機能_起居動作1リスト.add(get略称04_正常選択肢印刷無(調査項目, 連番19));
                身体機能_起居動作1リスト.add(get略称21_正常選択肢印刷無(調査項目, 連番21));
                身体機能_起居動作1リスト.add(get略称22_正常選択肢印刷無(調査項目, 連番34));
                身体機能_起居動作1リスト.add(get略称08_正常選択肢印刷無(調査項目, 連番44));
                身体機能_起居動作1リスト.add(get略称09_正常選択肢印刷無(調査項目, 連番45));
            }
        }
        return 身体機能_起居動作1リスト;
    }

    private static List<RString> set認知機能4リスト(List<NinteichosahyoChosaItem> dbt5211Entity,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 認定調査前回結果印刷有無, RString 前回正常選択肢印刷有無,
            RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        if (!前回調査項目.isEmpty()) {
            if (差分のみ印刷.equals(認定調査前回結果印刷有無)) {
                return 認知機能差分(dbt5211Entity, 前回調査項目, 厚労省IF識別コード, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
            if (印刷しない.equals(認定調査前回結果印刷有無)) {
                認知機能4リスト.add(RString.EMPTY);
                認知機能4リスト.add(RString.EMPTY);
                認知機能4リスト.add(RString.EMPTY);
                認知機能4リスト.add(RString.EMPTY);
                認知機能4リスト.add(RString.EMPTY);
                認知機能4リスト.add(RString.EMPTY);
                認知機能4リスト.add(RString.EMPTY);
                認知機能4リスト.add(RString.EMPTY);
                認知機能4リスト.add(RString.EMPTY);
            }
            if (印刷する.equals(認定調査前回結果印刷有無)) {
                return 認知機能全部(前回調査項目, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
        } else {
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
        }
        return 認知機能4リスト;
    }

    private static List<RString> set認知機能3リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 認知機能3リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番32, 連番1, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番33, 連番2, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番34, 連番3, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番35, 連番4, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番36, 連番5, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番37, 連番6, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番38, 連番7, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番39, 連番8, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番40, 連番9, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番40, 連番1, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番42, 連番2, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番43, 連番3, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番44, 連番4, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番45, 連番5, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番46, 連番6, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番47, 連番7, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番57, 連番8, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番59, 連番9, 前回厚労省IF識別コード));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番46, 連番1, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番48, 連番2, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番49, 連番3, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番50, 連番4, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番51, 連番5, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番52, 連番6, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番53, 連番7, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番63, 連番8, 前回厚労省IF識別コード));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番65, 連番9, 前回厚労省IF識別コード));
        }
        return 認知機能3リスト;
    }

    private static List<RString> set認知機能2リスト(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 認知機能2リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番32, 連番1, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番33, 連番2, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番34, 連番3, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番35, 連番4, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番36, 連番5, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番37, 連番6, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番38, 連番7, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番39, 連番8, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番40, 連番9, 前回厚労省IF識別コード));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番40, 連番1, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番42, 連番2, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番43, 連番3, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番44, 連番4, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番45, 連番5, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番46, 連番6, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番47, 連番7, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番57, 連番8, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番59, 連番9, 前回厚労省IF識別コード));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番46, 連番1, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番48, 連番2, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番49, 連番3, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番50, 連番4, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番51, 連番5, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番52, 連番6, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番53, 連番7, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番63, 連番8, 前回厚労省IF識別コード));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番65, 連番9, 前回厚労省IF識別コード));
        }
        return 認知機能2リスト;
    }

    private static List<RString> set認知機能1リスト(List<NinteichosahyoChosaItem> 調査項目,
            RString 正常選択肢印刷有無, RString 厚労省IF識別コード) {
        List<RString> 認知機能1リスト = new ArrayList<>();
        if (印字する.equals(正常選択肢印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                認知機能1リスト.add(get略称14(調査項目, 連番32));
                認知機能1リスト.add(get略称15(調査項目, 連番33));
                認知機能1リスト.add(get略称15(調査項目, 連番34));
                認知機能1リスト.add(get略称15(調査項目, 連番35));
                認知機能1リスト.add(get略称15(調査項目, 連番36));
                認知機能1リスト.add(get略称15(調査項目, 連番37));
                認知機能1リスト.add(get略称15(調査項目, 連番38));
                認知機能1リスト.add(get略称16(調査項目, 連番39));
                認知機能1リスト.add(get略称16(調査項目, 連番40));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                認知機能1リスト.add(get略称14(調査項目, 連番40));
                認知機能1リスト.add(get略称15(調査項目, 連番42));
                認知機能1リスト.add(get略称15(調査項目, 連番43));
                認知機能1リスト.add(get略称15(調査項目, 連番44));
                認知機能1リスト.add(get略称15(調査項目, 連番45));
                認知機能1リスト.add(get略称15(調査項目, 連番46));
                認知機能1リスト.add(get略称15(調査項目, 連番47));
                認知機能1リスト.add(get略称16(調査項目, 連番57));
                認知機能1リスト.add(get略称16(調査項目, 連番59));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                認知機能1リスト.add(get略称14(調査項目, 連番46));
                認知機能1リスト.add(get略称15(調査項目, 連番48));
                認知機能1リスト.add(get略称15(調査項目, 連番49));
                認知機能1リスト.add(get略称15(調査項目, 連番50));
                認知機能1リスト.add(get略称15(調査項目, 連番51));
                認知機能1リスト.add(get略称15(調査項目, 連番52));
                認知機能1リスト.add(get略称15(調査項目, 連番53));
                認知機能1リスト.add(get略称16(調査項目, 連番63));
                認知機能1リスト.add(get略称16(調査項目, 連番65));
            }
        } else {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                認知機能1リスト.add(get略称14_正常選択肢印刷無(調査項目, 連番32));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番33));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番34));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番35));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番36));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番37));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番38));
                認知機能1リスト.add(get略称16_正常選択肢印刷無(調査項目, 連番39));
                認知機能1リスト.add(get略称16_正常選択肢印刷無(調査項目, 連番40));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                認知機能1リスト.add(get略称14_正常選択肢印刷無(調査項目, 連番40));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番42));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番43));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番44));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番45));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番46));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番47));
                認知機能1リスト.add(get略称16_正常選択肢印刷無(調査項目, 連番57));
                認知機能1リスト.add(get略称16_正常選択肢印刷無(調査項目, 連番59));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                認知機能1リスト.add(get略称14_正常選択肢印刷無(調査項目, 連番46));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番48));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番49));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番50));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番51));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番52));
                認知機能1リスト.add(get略称15_正常選択肢印刷無(調査項目, 連番53));
                認知機能1リスト.add(get略称16_正常選択肢印刷無(調査項目, 連番63));
                認知機能1リスト.add(get略称16_正常選択肢印刷無(調査項目, 連番65));
            }
        }
        return 認知機能1リスト;
    }

    private static List<RString> set主治医意見書項目4リスト(List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> 前回意見書項目, RString 認定調査前回結果印刷有無, RString 前回正常選択肢印刷有無,
            RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 主治医意見書項目4リスト = new ArrayList<>();
        if (!前回意見書項目.isEmpty()) {
            if (差分のみ印刷.equals(認定調査前回結果印刷有無)) {
                return 主治医差分(意見書項目, 前回意見書項目, 厚労省IF識別コード, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
            if (印刷しない.equals(認定調査前回結果印刷有無)) {
                主治医意見書項目4リスト.add(RString.EMPTY);
                主治医意見書項目4リスト.add(RString.EMPTY);
                主治医意見書項目4リスト.add(RString.EMPTY);
                主治医意見書項目4リスト.add(RString.EMPTY);
                主治医意見書項目4リスト.add(RString.EMPTY);
            }
            if (印刷する.equals(認定調査前回結果印刷有無)) {
                return 主治医全部(前回意見書項目, 前回厚労省IF識別コード, 前回正常選択肢印刷有無);
            }
        } else {
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
        }
        return 主治医意見書項目4リスト;
    }

    private static List<RString> set主治医意見書項目3リスト(List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> 前回意見書項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 主治医意見書項目3リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番13, 連番1, 前回厚労省IF識別コード));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番14, 連番2, 前回厚労省IF識別コード));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番15, 連番3, 前回厚労省IF識別コード));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番16, 連番4, 前回厚労省IF識別コード));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番68, 連番5, 前回厚労省IF識別コード));
        }
        if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番14, 連番1, 前回厚労省IF識別コード));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番15, 連番2, 前回厚労省IF識別コード));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番16, 連番3, 前回厚労省IF識別コード));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番17, 連番4, 前回厚労省IF識別コード));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番18, 連番5, 前回厚労省IF識別コード));
        }
        return 主治医意見書項目3リスト;
    }

    private static List<RString> set主治医意見書項目2リスト(List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> 前回意見書項目, RString 厚労省IF識別コード, RString 前回厚労省IF識別コード) {
        List<RString> 主治医意見書項目2リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番13, 連番1, 前回厚労省IF識別コード));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番14, 連番2, 前回厚労省IF識別コード));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番15, 連番3, 前回厚労省IF識別コード));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番16, 連番4, 前回厚労省IF識別コード));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番68, 連番5, 前回厚労省IF識別コード));
        }
        if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番14, 連番1, 前回厚労省IF識別コード));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番15, 連番2, 前回厚労省IF識別コード));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番16, 連番3, 前回厚労省IF識別コード));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番17, 連番4, 前回厚労省IF識別コード));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番18, 連番5, 前回厚労省IF識別コード));
        }
        return 主治医意見書項目2リスト;
    }

    private static List<RString> set主治医意見書項目1リスト(List<ShujiiIkenshoIkenItem> dbt5304Entity,
            RString 正常選択肢印刷有無, RString 厚労省IF識別コード) {
        List<RString> 主治医意見書項目1リスト = new ArrayList<>();
        if (印字する.equals(正常選択肢印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                    || 識別コード06A.equals(厚労省IF識別コード)) {
                主治医意見書項目1リスト.add(get意見書名称03(dbt5304Entity, 連番13));
                主治医意見書項目1リスト.add(get意見書名称04(dbt5304Entity, 連番14));
                主治医意見書項目1リスト.add(get意見書名称05(dbt5304Entity, 連番15));
                主治医意見書項目1リスト.add(get意見書名称06(dbt5304Entity, 連番16));
                主治医意見書項目1リスト.add(get意見書名称14(dbt5304Entity, 連番68));
            }
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
                主治医意見書項目1リスト.add(get意見書名称03(dbt5304Entity, 連番14));
                主治医意見書項目1リスト.add(get意見書名称04(dbt5304Entity, 連番15));
                主治医意見書項目1リスト.add(get意見書名称05(dbt5304Entity, 連番16));
                主治医意見書項目1リスト.add(get意見書名称06(dbt5304Entity, 連番17));
                主治医意見書項目1リスト.add(get意見書名称14(dbt5304Entity, 連番18));
            }
        } else {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                    || 識別コード06A.equals(厚労省IF識別コード)) {
                主治医意見書項目1リスト.add(get意見書名称03_正常選択肢印刷無(dbt5304Entity, 連番13));
                主治医意見書項目1リスト.add(get意見書名称04_正常選択肢印刷無(dbt5304Entity, 連番14));
                主治医意見書項目1リスト.add(get意見書名称05_正常選択肢印刷無(dbt5304Entity, 連番15));
                主治医意見書項目1リスト.add(get意見書名称06_正常選択肢印刷無(dbt5304Entity, 連番16));
                主治医意見書項目1リスト.add(get意見書名称14_正常選択肢印刷無(dbt5304Entity, 連番68));
            }
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
                主治医意見書項目1リスト.add(get意見書名称03_正常選択肢印刷無(dbt5304Entity, 連番14));
                主治医意見書項目1リスト.add(get意見書名称04_正常選択肢印刷無(dbt5304Entity, 連番15));
                主治医意見書項目1リスト.add(get意見書名称05_正常選択肢印刷無(dbt5304Entity, 連番16));
                主治医意見書項目1リスト.add(get意見書名称06_正常選択肢印刷無(dbt5304Entity, 連番17));
                主治医意見書項目1リスト.add(get意見書名称14_正常選択肢印刷無(dbt5304Entity, 連番18));
            }
        }
        return 主治医意見書項目1リスト;
    }

    private static IchijihanteikekkahyoEntity setBodyItem(YokaigoNinteiJohoTeikyoEntity entity, RString 一次判定結果マスキング区分) {
        IchijihanteikekkahyoEntity ichijiEntity = new IchijihanteikekkahyoEntity();
        setBodyItem02(ichijiEntity, entity);
        setBodyItem03(ichijiEntity, entity);
        setBodyItem04(ichijiEntity, entity);
        ichijiEntity.setタイトル(認定情報_事務局用);
        ichijiEntity.set合議体番号((entity.get合議体番号() != null)
                ? entity.get合議体番号().padZeroToLeft(合議体番号_LENGTH)
                : entity.get合議体番号());
        ichijiEntity.set審査順(entity.get審査会審査順());
        ichijiEntity.set被保険者区分(RString.isNullOrEmpty(entity.get被保険者区分コード()) ? RString.EMPTY
                : HihokenshaKubunCode.toValue(remove半角スペース(entity.get被保険者区分コード())).get名称());
        ichijiEntity.set申請区分(RString.isNullOrEmpty(entity.get申請区分_申()) ? RString.EMPTY
                : NinteiShinseiShinseijiKubunCode.toValue(remove半角スペース(entity.get申請区分_申())).get名称());
        ichijiEntity.set年齢(new RStringBuilder().append(entity.get年齢()).append(new RString("歳")).toRString());
        ichijiEntity.set性別(RString.isNullOrEmpty(entity.get性別()) ? RString.EMPTY
                : Seibetsu.toValue(remove半角スペース(entity.get性別())).get名称());
        ichijiEntity.set現在の状況(RString.isNullOrEmpty(entity.get施設利用()) ? RString.EMPTY
                : GenzainoJokyoCode.toValue(remove半角スペース(entity.get施設利用())).get名称());
        ichijiEntity.set前々回認定有効期間((entity.get前々回認定有効期間() != null)
                ? new RStringBuilder().append(entity.get前々回認定有効期間()).append("月間").toRString()
                : RString.EMPTY);
        ichijiEntity.set前々回認定有効期間開始年月日(entity.get前々回認定有効期間_開始());
        ichijiEntity.set前々回認定有効期間終了年月日(entity.get前々回認定有効期間_終了());
        ichijiEntity.set前回認定有効期間((entity.get前回認定有効期間() != null)
                ? new RStringBuilder().append(entity.get前回認定有効期間()).append("月間").toRString()
                : RString.EMPTY);
        ichijiEntity.set前回認定有効期間開始年月日(entity.get前回認定有効期間_開始());
        ichijiEntity.set前回認定有効期間終了年月日(entity.get前回認定有効期間_終了());
        ichijiEntity.set前回認定日(entity.get前回二次判定年月日());
        ichijiEntity.set前回状態像(RString.isNullOrEmpty(entity.get前回状態像()) ? RString.EMPTY
                : YokaigoJotaizoReiCode.toValue(remove半角スペース(entity.get前回状態像())).get名称());
        ichijiEntity.set管理番号(entity.get申請書管理番号());
        setマスキング情報(ichijiEntity, entity, 一次判定結果マスキング区分);
        ichijiEntity.set認定有効期間(entity.get認定有効期間());
        ichijiEntity.set認定有効期間開始年月日(entity.get認定有効期間開始年月日() == null ? RString.EMPTY
                : new RString(entity.get認定有効期間開始年月日().toString()));
        ichijiEntity.set認定有効期間終了年月日(entity.get認定有効期間終了年月日() == null ? RString.EMPTY
                : new RString(entity.get認定有効期間終了年月日().toString()));
        ichijiEntity.set特定疾病名(RString.isNullOrEmpty(entity.get特定疾病()) ? RString.EMPTY
                : TokuteiShippei.toValue(remove半角スペース(entity.get特定疾病())).get名称());
        ichijiEntity.set状態像名称(RString.isNullOrEmpty(entity.get要介護状態像例コード()) ? RString.EMPTY
                : YokaigoJotaizoReiCode.toValue(remove半角スペース(entity.get要介護状態像例コード())).get名称());
        RString 要介護認定等基準時間;
        if (entity.get要介護認定等基準時間() == null) {
            要介護認定等基準時間 = new RString("0");
        } else {
            要介護認定等基準時間 = new RStringBuilder()
                    .append(new Decimal(entity.get要介護認定等基準時間().toString()).divide(時間算出用数値_10).toString("##0.0"))
                    .append("分")
                    .toRString();
            if (entity.get要介護認定等基準時間_認知症加算() != null && !entity.get要介護認定等基準時間_認知症加算().equals(new RString("0"))) {
                要介護認定等基準時間 = new RStringBuilder()
                        .append(要介護認定等基準時間)
                        .append(" ＋ ")
                        .append(new Decimal(entity.get要介護認定等基準時間_認知症加算().toString()).divide(時間算出用数値_10).toString("##0.0"))
                        .append("分 ＝ ")
                        .append(new Decimal(entity.get要介護認定等基準時間().toString())
                                .add(new Decimal(entity.get要介護認定等基準時間_認知症加算().toString()))
                                .divide(時間算出用数値_10).toString("##0.0"))
                        .append("分")
                        .toRString();
            }
        }
        ichijiEntity.set要介護認定等基準時間(要介護認定等基準時間);
        List<EachBarImage> imageList = new ArrayList();
        if (0 < getNumber(entity.get要介護認定等基準時間_食事())) {
            imageList.add(new EachBarImage(getNumber(entity.get要介護認定等基準時間_食事()), BarImageType.PATTERN1));
        }
        if (0 < getNumber(entity.get要介護認定等基準時間_排泄())) {
            imageList.add(new EachBarImage(getNumber(entity.get要介護認定等基準時間_排泄()), BarImageType.PATTERN2));
        }
        if (0 < getNumber(entity.get要介護認定等基準時間_移動())) {
            imageList.add(new EachBarImage(getNumber(entity.get要介護認定等基準時間_移動()), BarImageType.PATTERN3));
        }
        if (0 < getNumber(entity.get要介護認定等基準時間_清潔保持())) {
            imageList.add(new EachBarImage(getNumber(entity.get要介護認定等基準時間_清潔保持()), BarImageType.PATTERN4));
        }
        if (0 < getNumber(entity.get要介護認定等基準時間_間接ケア())) {
            imageList.add(new EachBarImage(getNumber(entity.get要介護認定等基準時間_間接ケア()), BarImageType.PATTERN5));
        }
        if (0 < getNumber(entity.get要介護認定等基準時間_BPSD関連())) {
            imageList.add(new EachBarImage(getNumber(entity.get要介護認定等基準時間_BPSD関連()), BarImageType.PATTERN6));
        }
        if (0 < getNumber(entity.get要介護認定等基準時間_機能訓練())) {
            imageList.add(new EachBarImage(getNumber(entity.get要介護認定等基準時間_機能訓練()), BarImageType.PATTERN7));
        }
        if (0 < getNumber(entity.get要介護認定等基準時間_医療関連())) {
            imageList.add(new EachBarImage(getNumber(entity.get要介護認定等基準時間_医療関連()), BarImageType.PATTERN8));
        }
        if (0 < getNumber(entity.get要介護認定等基準時間_認知症加算())) {
            imageList.add(new EachBarImage(getNumber(entity.get要介護認定等基準時間_認知症加算()), BarImageType.PATTERN9));
        }
        RString path = new StackBarImage().createHorizontalBarImage(IMAGE_WIDTH, IMAGE_HEIGHT, imageList);
        ichijiEntity.set要介護認定等基準時間イメージ(path);
        ichijiEntity.set要介護認定等基準時間_食事(entity.get要介護認定等基準時間_食事() == null ? new RString("0")
                : new RString(new Decimal(entity.get要介護認定等基準時間_食事().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set要介護認定等基準時間_排泄(entity.get要介護認定等基準時間_排泄() == null ? new RString("0")
                : new RString(new Decimal(entity.get要介護認定等基準時間_排泄().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set要介護認定等基準時間_移動(entity.get要介護認定等基準時間_移動() == null ? new RString("0")
                : new RString(new Decimal(entity.get要介護認定等基準時間_移動().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set要介護認定等基準時間_清潔保持(entity.get要介護認定等基準時間_清潔保持() == null ? new RString("0")
                : new RString(new Decimal(entity.get要介護認定等基準時間_清潔保持().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set要介護認定等基準時間_間接(entity.get要介護認定等基準時間_間接ケア() == null ? new RString("0")
                : new RString(new Decimal(entity.get要介護認定等基準時間_間接ケア().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set要介護認定等基準時間_BPSD関連(entity.get要介護認定等基準時間_BPSD関連() == null ? new RString("0")
                : new RString(new Decimal(entity.get要介護認定等基準時間_BPSD関連().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set要介護認定等基準時間_機能訓練(entity.get要介護認定等基準時間_機能訓練() == null ? new RString("0")
                : new RString(new Decimal(entity.get要介護認定等基準時間_機能訓練().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set要介護認定等基準時間_医療関連(entity.get要介護認定等基準時間_医療関連() == null ? new RString("0")
                : new RString(new Decimal(entity.get要介護認定等基準時間_医療関連().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set要介護認定等基準時間_認知症加算(entity.get要介護認定等基準時間_認知症加算() == null ? new RString("0")
                : new RString(new Decimal(entity.get要介護認定等基準時間_認知症加算().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set警告コード(entity.get警告コード());
        ichijiEntity.set中間評価項目得点第1群(entity.get中間評価項目得点第1群() == null ? new RString("0")
                : new RString(new Decimal(entity.get中間評価項目得点第1群().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set中間評価項目得点第2群(entity.get中間評価項目得点第2群() == null ? new RString("0")
                : new RString(new Decimal(entity.get中間評価項目得点第2群().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set中間評価項目得点第3群(entity.get中間評価項目得点第3群() == null ? new RString("0")
                : new RString(new Decimal(entity.get中間評価項目得点第3群().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set中間評価項目得点第4群(entity.get中間評価項目得点第4群() == null ? new RString("0")
                : new RString(new Decimal(entity.get中間評価項目得点第4群().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set中間評価項目得点第5群(entity.get中間評価項目得点第5群() == null ? new RString("0")
                : new RString(new Decimal(entity.get中間評価項目得点第5群().toString()).divide(時間算出用数値_10).toString()));
        ichijiEntity.set認定調査結果認知症高齢者自立度(RString.isNullOrEmpty(entity.get認知症高齢者自立度()) ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(remove半角スペース(entity.get認知症高齢者自立度())).get名称());
        ichijiEntity.set認知症自立度Ⅱ以上の蓋然性((entity.get蓋然性() == null
                || entity.get蓋然性().equals(new RString("0"))
                || entity.get蓋然性().equals(new RString("-1")))
                ? RString.EMPTY
                : RStringUtil.convert半角to全角(new RString(
                                new Decimal(entity.get蓋然性().toString()).divide(時間算出用数値_10).toString("##0.0"))));
        ichijiEntity.set状態の安定性(RString.isNullOrEmpty(entity.get安定性()) ? RString.EMPTY
                : JotaiAnteiseiCode.toValue(remove半角スペース(entity.get安定性())).get名称());
        ichijiEntity.set給付区分(RString.isNullOrEmpty(entity.get給付区分()) ? RString.EMPTY
                : SuiteiKyufuKubunCode.toValue(remove半角スペース(entity.get給付区分())).get名称());
        ichijiEntity.set現在のサービス利用状況名(
                (RString.isNullOrEmpty(entity.getサービス区分コード()) || entity.getサービス区分コード().equals(ServiceKubunCode.なし.getコード()))
                ? RString.EMPTY
                : ServiceKubunCode.toValue(remove半角スペース(entity.getサービス区分コード())).get名称());
        ichijiEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        ichijiEntity.set前回厚労省IF識別コード(entity.get前回厚労省IF識別コード());
        List<RString> 高齢者自立度リスト = new ArrayList<>();
        高齢者自立度リスト.add(RString.isNullOrEmpty(entity.get障害高齢者自立度()) ? RString.EMPTY
                : ShogaiNichijoSeikatsuJiritsudoCode.toValue(remove半角スペース(entity.get障害高齢者自立度())).get名称());
        高齢者自立度リスト.add(RString.isNullOrEmpty(entity.get認知症高齢者自立度()) ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(remove半角スペース(entity.get認知症高齢者自立度())).get名称());
        ichijiEntity.set高齢者自立度リスト(高齢者自立度リスト);
        return ichijiEntity;
    }

    private static void setマスキング情報(IchijihanteikekkahyoEntity ichijiEntity,
            YokaigoNinteiJohoTeikyoEntity entity, RString 一次判定結果マスキング区分) {
        boolean マスキングあり = マスキング_あり.equals(一次判定結果マスキング区分);
        ichijiEntity.set氏名(マスキングあり ? RString.EMPTY : entity.get被保険者氏名());
        ichijiEntity.set被保険者番号(マスキングあり ? RString.EMPTY : entity.get被保険者番号());
        ichijiEntity.set保険者番号(マスキングあり ? RString.EMPTY : entity.get保険者番号());
        ichijiEntity.set所属(マスキングあり ? RString.EMPTY : entity.get所属());
        ichijiEntity.set市町村名(マスキングあり ? RString.EMPTY : entity.get市町村名());
        ichijiEntity.set事業者番号(マスキングあり ? RString.EMPTY : entity.get事業者番号());
        ichijiEntity.set事業者名(マスキングあり ? RString.EMPTY : entity.get事業者名称());
        ichijiEntity.set認定調査員番号(マスキングあり ? RString.EMPTY : entity.get認定調査員コード());
        ichijiEntity.set認定調査員氏名(マスキングあり ? RString.EMPTY : マスキング_調査員名.equals(一次判定結果マスキング区分)
                ? RString.EMPTY : entity.get調査員氏名());
        ichijiEntity.set認定調査員資格(マスキングあり ? RString.EMPTY
                : RString.isNullOrEmpty(entity.get調査員資格()) ? RString.EMPTY
                : RString.isNullOrEmpty(remove半角スペース(entity.get調査員資格())) ? RString.EMPTY
                : Sikaku.toValue(entity.get調査員資格()).get名称());
        ichijiEntity.set医療機関番号(マスキングあり ? RString.EMPTY : entity.get主治医医療機関コード());
        ichijiEntity.set医療機関名称(マスキングあり ? RString.EMPTY : entity.get医療機関名称());
        ichijiEntity.set主治医番号(マスキングあり ? RString.EMPTY : entity.get主治医コード());
        ichijiEntity.set主治医氏名(マスキングあり ? RString.EMPTY : entity.get主治医氏名());
    }

    private static RString remove半角スペース(RString target) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(target);
        builder.replace(" ", "");
        return builder.toRString();
    }

    private static void setBodyItem03(IchijihanteikekkahyoEntity ichijiEntity, YokaigoNinteiJohoTeikyoEntity entity) {
        ichijiEntity.set申請日_元号(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ichijiEntity.set申請日_年(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ichijiEntity.set申請日_月(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ichijiEntity.set申請日_日(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ichijiEntity.set作成日_元号(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ichijiEntity.set作成日_年(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ichijiEntity.set作成日_月(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ichijiEntity.set作成日_日(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ichijiEntity.set調査日_元号(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ichijiEntity.set調査日_年(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ichijiEntity.set調査日_月(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ichijiEntity.set調査日_日(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ichijiEntity.set審査日_元号(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ichijiEntity.set審査日_年(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ichijiEntity.set審査日_月(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ichijiEntity.set審査日_日(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
    }

    private static int getNumber(RString 各基準時間) {
        if (!RString.isNullOrEmpty(各基準時間)) {
            return Integer.parseInt(各基準時間.toString()) * 5 / 12;
        } else {
            return 0;
        }
    }

    private static void setBodyItem02(IchijihanteikekkahyoEntity ichijiEntity, YokaigoNinteiJohoTeikyoEntity entity) {
        if (判定結果コード09.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ichijiEntity.set前々回要介護度(RString.isNullOrEmpty(entity.get前々回要介護度()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(remove半角スペース(entity.get前々回要介護度())).get名称());
            ichijiEntity.set前回要介護度(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(remove半角スペース(entity.get前回認定結果())).get名称());
            RString 一次判定結果;
            if (RString.isNullOrEmpty(entity.get一次判定結果())) {
                一次判定結果 = RString.EMPTY;
            } else {
                一次判定結果 = IchijiHanteiKekkaCode09.toValue(remove半角スペース(entity.get一次判定結果())).get名称();
                if (!RString.isNullOrEmpty(entity.get一次判定結果_認知症加算())
                        && !entity.get一次判定結果().equals(entity.get一次判定結果_認知症加算())) {
                    一次判定結果 = new RStringBuilder()
                            .append(一次判定結果)
                            .append("→")
                            .append(IchijiHanteiKekkaCode09.toValue(remove半角スペース(entity.get一次判定結果_認知症加算())).get名称())
                            .toRString();
                }
            }
            ichijiEntity.set一次判定結果(一次判定結果);
            ichijiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(remove半角スペース(entity.get二次判定結果())).get名称());
        }
        if (判定結果コード06.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ichijiEntity.set前々回要介護度(RString.isNullOrEmpty(entity.get前々回要介護度()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(remove半角スペース(entity.get前々回要介護度())).get名称());
            ichijiEntity.set前回要介護度(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(remove半角スペース(entity.get前回認定結果())).get名称());
            RString 一次判定結果;
            if (RString.isNullOrEmpty(entity.get一次判定結果())) {
                一次判定結果 = RString.EMPTY;
            } else {
                一次判定結果 = YokaigoJotaiKubun06.toValue(remove半角スペース(entity.get一次判定結果())).get名称();
                if (!RString.isNullOrEmpty(entity.get一次判定結果_認知症加算())
                        && !entity.get一次判定結果().equals(entity.get一次判定結果_認知症加算())) {
                    一次判定結果 = new RStringBuilder()
                            .append(一次判定結果)
                            .append("→")
                            .append(YokaigoJotaiKubun06.toValue(remove半角スペース(entity.get一次判定結果_認知症加算())).get名称())
                            .toRString();
                }
            }
            ichijiEntity.set一次判定結果(一次判定結果);
            ichijiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(remove半角スペース(entity.get二次判定結果())).get名称());
        }
    }

    private static void setBodyItem04(IchijihanteikekkahyoEntity ichijiEntity, YokaigoNinteiJohoTeikyoEntity entity) {
        if (判定結果コード02.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ichijiEntity.set前々回要介護度(RString.isNullOrEmpty(entity.get前々回要介護度()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(remove半角スペース(entity.get前々回要介護度())).get名称());
            ichijiEntity.set前回要介護度(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(remove半角スペース(entity.get前回認定結果())).get名称());
            RString 一次判定結果;
            if (RString.isNullOrEmpty(entity.get一次判定結果())) {
                一次判定結果 = RString.EMPTY;
            } else {
                一次判定結果 = YokaigoJotaiKubun02.toValue(remove半角スペース(entity.get一次判定結果())).get名称();
                if (!RString.isNullOrEmpty(entity.get一次判定結果_認知症加算())
                        && !entity.get一次判定結果().equals(entity.get一次判定結果_認知症加算())) {
                    一次判定結果 = new RStringBuilder()
                            .append(一次判定結果)
                            .append("→")
                            .append(YokaigoJotaiKubun02.toValue(remove半角スペース(entity.get一次判定結果_認知症加算())).get名称())
                            .toRString();
                }
            }
            ichijiEntity.set一次判定結果(一次判定結果);
            ichijiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(remove半角スペース(entity.get二次判定結果())).get名称());
        }
        if (判定結果コード99.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ichijiEntity.set前々回要介護度(RString.isNullOrEmpty(entity.get前々回要介護度()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(remove半角スペース(entity.get前々回要介護度())).get名称());
            ichijiEntity.set前回要介護度(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(remove半角スペース(entity.get前回認定結果())).get名称());
            RString 一次判定結果;
            if (RString.isNullOrEmpty(entity.get一次判定結果())) {
                一次判定結果 = RString.EMPTY;
            } else {
                一次判定結果 = YokaigoJotaiKubun99.toValue(remove半角スペース(entity.get一次判定結果())).get名称();
                if (!RString.isNullOrEmpty(entity.get一次判定結果_認知症加算())
                        && !entity.get一次判定結果().equals(entity.get一次判定結果_認知症加算())) {
                    一次判定結果 = new RStringBuilder()
                            .append(一次判定結果)
                            .append("→")
                            .append(YokaigoJotaiKubun99.toValue(remove半角スペース(entity.get一次判定結果_認知症加算())).get名称())
                            .toRString();
                }
            }
            ichijiEntity.set一次判定結果(一次判定結果);
            ichijiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(remove半角スペース(entity.get二次判定結果())).get名称());
        }
    }

    private static RString get略称34(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser34.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称33(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser33.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称22(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser22.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称21(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser21.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称20(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser20.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称17(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser17.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称16(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser16.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称15(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser15.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称14(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser14.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称13(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser13.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称11(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser11.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称10(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser10.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称09(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser09.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称08(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser08.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称07(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser07.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称06(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser06.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称04(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser04.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称03(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser03.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称02(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser02.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称12(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser12.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称01(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size() && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser01.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称14(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size() && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku14.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称06(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size() && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku06.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称05(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size() && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku05.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称04(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size() && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku04.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称03(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size() && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku03.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get略称34_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser34.自立.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser34.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称33_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser33.できる.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser33.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称22_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser22.自立.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser22.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称21_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser21.自立.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser21.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称20_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser20.自立.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser20.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称17_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser17.できる_特別な場合でもできる.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser17.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称16_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser16.ない.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser16.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称15_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser15.できる.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser15.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称14_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser14.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称13_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser13.週1回以上.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser13.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称11_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser11.できる.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser11.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称10_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser10.介助されていない.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser10.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称09_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser09.普通.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser09.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称08_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser08.普通_日常生活に支障がない.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser08.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称07_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser07.介助されていない.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser07.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称06_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser06.介助されていない.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser06.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称04_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser04.支えなしでできる.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser04.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称03_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser03.できる.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser03.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称02_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser02.つかまらないでできる.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser02.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称12_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser12.介助されていない.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser12.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get略称01_正常選択肢印刷無(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()
                && !RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())
                && !ChosaAnser01.ない.getコード().equals(dbt5211Entity.get(連番).get調査項目())) {
            return ChosaAnser01.toValue(remove半角スペース(dbt5211Entity.get(連番).get調査項目())).get略称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称14_正常選択肢印刷無(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()
                && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())
                && !IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku14.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称06_正常選択肢印刷無(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()
                && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())
                && !IkenKomoku06.伝えられる.getコード().equals(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku06.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称05_正常選択肢印刷無(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()
                && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())
                && !IkenKomoku05.自立.getコード().equals(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku05.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称04_正常選択肢印刷無(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()
                && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())
                && !IkenKomoku04.問題なし.getコード().equals(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku04.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称03_正常選択肢印刷無(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()
                && !RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())
                && !IkenKomoku03.自立.getコード().equals(dbt5304Entity.get(連番).get意見項目())) {
            return IkenKomoku03.toValue(remove半角スペース(dbt5304Entity.get(連番).get意見項目())).get名称();
        }
        return RString.EMPTY;
    }

    private static List<DbT5304ShujiiIkenshoIkenItemEntity> toDbT5304ShujiiIkenshoIkenItemEntity(
            List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List) {
        List<DbT5304ShujiiIkenshoIkenItemEntity> entityList = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 主治医意見書意見項目List) {
            entityList.add(item.toEntity());
        }
        return entityList;
    }
}
