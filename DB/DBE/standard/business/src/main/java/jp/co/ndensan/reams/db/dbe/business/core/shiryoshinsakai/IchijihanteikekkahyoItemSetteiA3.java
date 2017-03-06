/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TiyosaKekka;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class IchijihanteikekkahyoItemSetteiA3 {

    private static final RString 認定調査主治結果 = new RString("未");
    private static final RString 印字する = new RString("1");
    private static final RString IMAGEFILENAME_概況調査特記 = new RString("C0007");
    private static final RString 調査結果_正常値 = new RString("1");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final int INT_15 = 15;
    private static final int INT_16 = 16;
    private static final int INT_17 = 17;
    private static final int INT_18 = 18;
    private static final int INT_19 = 19;

    /**
     * 事務局一次判定結果票Entityの設定。
     *
     * @param entity ItiziHanteiEntity
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @param 調査票調査項目 調査票調査項目
     * @param 前回調査票調査項目 前回調査票調査項目
     * @param 主治医意見書項目情報 主治医意見書項目情報
     * @param 前主治医意見書項目情報 前主治医意見書項目情報
     * @param サービス状況フラグ サービス状況フラグ
     * @param 予防給付 予防給付
     * @param 介護給付 介護給付
     * @param データ件数 データ件数
     * @param 共通情報 共通情報
     * @param 主治医意見書項目 主治医意見書項目
     * @param 合議体番号 合議体番号
     * @param 特記情報 特記情報
     * @param ファイルパス ファイルパス
     * @return 事務局一次判定結果票のEntity
     */
    public IchijihanteikekkahyoA3Entity set項目(ItiziHanteiEntity entity,
            List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報, List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目情報,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報, List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付,
            List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付, DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ,
            int データ件数, ShinsakaiSiryoKyotsuEntity 共通情報, List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目, RString 合議体番号,
            List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報, RString ファイルパス) {
        IchijihanteikekkahyoA3Entity 項目 = new IchijihanteikekkahyoA3Entity();
        SabisuJyoukyoA3 settei = new SabisuJyoukyoA3();
        Code 厚労省IF識別コード = entity.getKoroshoIfShikibetsuCode();
        settei.set項目(項目, entity, ファイルパス);
        項目.set合議体番号(合議体番号);
        項目.set審査人数合計(new RString(データ件数));
        settei.setサービスの状況(entity, 項目, 予防給付, 介護給付, サービス状況フラグ, 共通情報, ファイルパス);
        RDate 日期 = RDate.getNowDate();
        boolean is前回結果 = false;
        boolean is今回結果 = false;
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回基本調査項目結果の正常選択肢印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            is今回結果 = true;
        }
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回基本調査項目結果の正常選択肢印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            is前回結果 = true;
        } else {
            if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回前回比較で変化有で前回正常選択肢表示印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
                is前回結果 = true;
            }
        }
        if (共通情報 != null) {
            RString 共有ファイル名 = 共通情報.getShoKisaiHokenshaNo().concat(共通情報.getHihokenshaNo());
            RString path = copySharedFilesBatch(共通情報.getImageSharedFileId(), 共有ファイル名, ファイルパス);
            IchijihanteiekkahyoTokkijiko tokkijiko = new IchijihanteiekkahyoTokkijiko(特記情報, 共通情報, ファイルパス);
            項目.set概況調査テキスト_イメージ区分(共通情報.getGaikyoChosaTextImageKubun());
            項目.set概況特記のテキスト(共通情報.getTokki());
            if (共通情報.isJimukyoku()) {
                項目.set概況特記のイメージ(DBEImageUtil.getOriginalImageFilePath(path, IMAGEFILENAME_概況調査特記));
            } else {
                項目.set概況特記のイメージ(DBEImageUtil.getMaskOrOriginalImageFilePath(path, IMAGEFILENAME_概況調査特記));
            }
            項目.set特記事項テキスト_イメージ区分(tokkijiko.get特記事項テキスト_イメージ区分());
            項目.set特記パターン(DbBusinessConfig.get(ConfigNameDBE.審査会資料調査特記パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
            項目.set特記事項_listChosa1(tokkijiko.get短冊情報リスト());
            項目.set特記事項_tokkiText(tokkijiko.getTokkiText());
            項目.set特記事項_tokkiImg(tokkijiko.getTokkiImg());
            項目.set名前(tokkijiko.get名前());
            項目.set認定申請年月日(tokkijiko.get認定申請年月日());
            項目.set認定調査実施年月日(tokkijiko.get認定調査実施年月日());
            項目.set介護認定審査会開催年月日(tokkijiko.get介護認定審査会開催年月日());
            項目.set特記事項保険者番号(tokkijiko.get保険者番号());
            項目.set特記事項被保険者番号(tokkijiko.get被保険者番号());
        }
        List<RString> 認定調査特記事項 = settei.get認定調査特記事項番号(認定調査票_特記情報);
        項目.set第１群リスト(get第１群リスト(厚労省IF識別コード, 調査票調査項目, is今回結果, 前回調査票調査項目, is前回結果, 主治医意見書項目, 認定調査特記事項));
        項目.set第２群リスト(get第２群リスト(厚労省IF識別コード, 調査票調査項目, is今回結果, 前回調査票調査項目, is前回結果, 主治医意見書項目, 認定調査特記事項));
        項目.set第３群リスト(get第３群リスト(厚労省IF識別コード, 調査票調査項目, is今回結果, 前回調査票調査項目, is前回結果, 主治医意見書項目, 認定調査特記事項));
        項目.set第４群リスト(get第４群リスト(厚労省IF識別コード, 調査票調査項目, is今回結果, 前回調査票調査項目, is前回結果, 主治医意見書項目, 認定調査特記事項));
        項目.set第５群リスト(get第５群リスト(厚労省IF識別コード, 調査票調査項目, is今回結果, 前回調査票調査項目, is前回結果, 主治医意見書項目, 認定調査特記事項));
        項目.set主治医意見書(get主治医意見書リスト(厚労省IF識別コード, 主治医意見書項目情報, 前主治医意見書項目情報, is前回結果));
        項目.set特別な医療リスト１(get特別な医療リスト１(厚労省IF識別コード, 調査票調査項目, is今回結果, 前回調査票調査項目, 主治医意見書項目, 認定調査特記事項));
        項目.set特別な医療リスト２(get特別な医療リスト２(厚労省IF識別コード, 調査票調査項目, is今回結果, 前回調査票調査項目, 主治医意見書項目, 認定調査特記事項));
        項目.set識別コード(entity.getShoKisaiHokenshaNo().substring(INT_0, INT_5).concat(entity.getHihokenshaNo()));
        return 項目;
    }

    private List<TiyosaKekka> get第１群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報, boolean is今回結果,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目, List<RString> 認定調査票_特記情報) {
        List<TiyosaKekka> 第１群リスト = new IchijihanteikekkahyoKekka().get第１群リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoItemSetteiTwoA3 setteiT = new IchijihanteikekkahyoItemSetteiTwoA3();
        SabisuJyoukyoA3 sbbisuJyoukyo = new SabisuJyoukyoA3();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第１群;
            RString 調査結果;
            RString 調査結果コード;
            RString 調査項目連番 = new RString(調査票調査項目.getRemban());
            if (調査項目連番.equals(settei.get麻痺_左上肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_0);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set特記事項有無(setteiT.get麻痺特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_0, 第１群);
            } else if (調査項目連番.equals(settei.get麻痺_右上肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_1);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set特記事項有無(setteiT.get麻痺特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_1, 第１群);
            } else if (調査項目連番.equals(settei.get麻痺_左下肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_2);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set特記事項有無(setteiT.get麻痺特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_2, 第１群);
            } else if (調査項目連番.equals(settei.get麻痺_右下肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_3);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set特記事項有無(setteiT.get麻痺特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_3, 第１群);
            } else if (調査項目連番.equals(settei.get麻痺_その他(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_4);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set特記事項有無(setteiT.get麻痺特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_4, 第１群);
            } else if (調査項目連番.equals(settei.get拘縮_肩関節(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_5);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set特記事項有無(setteiT.get拘縮特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_5, 第１群);
            } else if (調査項目連番.equals(settei.get拘縮_股関節(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_6);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get拘縮特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_6, 第１群);
            } else if (調査項目連番.equals(settei.get拘縮_膝関節(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_7);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get拘縮特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_7, 第１群);
            } else if (調査項目連番.equals(settei.get拘縮_その他(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_8);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get拘縮特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_8, 第１群);
            } else if (調査項目連番.equals(settei.get寝返り(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_9);
                調査結果 = ChosaAnser02.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser02.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get寝返特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_9, 第１群);
            }
        }
        get第１群リスト１(厚労省IF識別コード, 調査票調査項目情報, is今回結果, 認定調査票_特記情報, 第１群リスト);
        set前回結果(厚労省IF識別コード, 前回調査票調査項目, 第１群リスト, is前回結果);
        sbbisuJyoukyo.set認定調査と主治医意見書比較１(厚労省IF識別コード, 第１群リスト, 主治医意見書項目);
        return 第１群リスト;
    }

    private void set今回調査結果(TiyosaKekka 調査群, DbT5211NinteichosahyoChosaItemEntity 調査票調査項目,
            RString 調査結果, boolean is今回結果) {
        if (is今回結果) {
            調査群.set調査結果(調査結果);
        } else {
            if (調査結果_正常値.equals(調査票調査項目.getResearchItem())) {
                調査群.set調査結果(RString.EMPTY);
            } else {
                調査群.set調査結果(調査結果);
            }
        }
    }

    private void set前回結果(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第１群リスト,
            boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第１群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get麻痺_左上肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_0);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set麻痺今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get麻痺_右上肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_1);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set麻痺今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get麻痺_左下肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_2);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set麻痺今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get麻痺_右下肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_3);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set麻痺今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get麻痺_その他(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_4);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set麻痺今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            }
        }
        set前回結果比(厚労省IF識別コード, 前回調査票調査項目, 第１群リスト, is前回結果);
    }

    private void set前回結果比(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第１群リスト,
            boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第１群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get拘縮_肩関節(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_5);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set麻痺今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get拘縮_股関節(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_6);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set麻痺今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get拘縮_膝関節(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_7);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set麻痺今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get拘縮_その他(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_8);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set麻痺今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get寝返り(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_9);
                前回調査結果 = ChosaAnser02.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser02.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set寝返起き上今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get起き上(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_10);
                前回調査結果 = ChosaAnser02.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser02.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set寝返起き上今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            }
        }
        set前回結果１(厚労省IF識別コード, 前回調査票調査項目, 第１群リスト, is前回結果);
    }

    private void set前回結果１(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第１群リスト,
            boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第１群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get座位保持(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_11);
                前回調査結果 = ChosaAnser03.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser03.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set座位保持今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get両足での立位(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_12);
                前回調査結果 = ChosaAnser04.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser04.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set両足での立位今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get歩行(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_13);
                前回調査結果 = ChosaAnser02.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser02.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set寝返起き上今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get立ち上(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_14);
                前回調査結果 = ChosaAnser02.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser02.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set寝返起き上今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            }
        }
        set前回結果比１(厚労省IF識別コード, 前回調査票調査項目, 第１群リスト, is前回結果);
    }

    private void set前回結果比１(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第１群リスト,
            boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第１群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get片足での立位(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_15);
                前回調査結果 = ChosaAnser04.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser04.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set両足での立位今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get洗身(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_16);
                前回調査結果 = ChosaAnser06.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser06.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set洗身今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.getつめ切り(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_17);
                前回調査結果 = ChosaAnser07.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser07.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.setつめ切り今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get視力(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_18);
                前回調査結果 = ChosaAnser08.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser08.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set視力今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            } else if (前回調査票調査連番.equals(settei.get聴力(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_19);
                前回調査結果 = ChosaAnser09.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser09.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set聴力今回結果前回結果比(第１群.get調査結果コード(), 前回調査結果コード, 第１群);
            }
        }
    }

    private List<TiyosaKekka> get第２群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報, boolean is今回結果,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果, List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目,
            List<RString> 認定調査票_特記情報) {
        List<TiyosaKekka> 第２群リスト = new IchijihanteikekkahyoKekka().get第２群リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoItemSetteiTwoA3 setteiT = new IchijihanteikekkahyoItemSetteiTwoA3();
        SabisuJyoukyoA3 sbbisuJyoukyo = new SabisuJyoukyoA3();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第２群;
            RString 調査結果;
            RString 調査結果コード;
            RString 調査項目連番 = new RString(調査票調査項目.getRemban());
            if (調査項目連番.equals(settei.get移乗(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_0);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get移乗特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_0, 第２群);
            } else if (調査項目連番.equals(settei.get移動(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_1);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get移動特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_1, 第２群);
            } else if (調査項目連番.equals(settei.getえん下(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_2);
                調査結果 = ChosaAnser11.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser11.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.getえん下特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_2, 第２群);
            } else if (調査項目連番.equals(settei.get食事摂取(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_3);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set特記事項有無(setteiT.get食事摂取特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_3, 第２群);
            } else if (調査項目連番.equals(settei.get排尿(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_4);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get排尿特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_4, 第２群);
            } else if (調査項目連番.equals(settei.get排便(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_5);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get排便特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_5, 第２群);
            } else if (調査項目連番.equals(settei.get口腔清潔(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_6);
                調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get口腔清潔特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_6, 第２群);
            } else if (調査項目連番.equals(settei.get洗顔(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_7);
                調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get洗顔特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_7, 第２群);
            } else if (調査項目連番.equals(settei.get整髪(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_8);
                調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get整髪特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_8, 第２群);
            } else if (調査項目連番.equals(settei.get上衣の着脱(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_9);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get上衣の着脱特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_9, 第２群);
            } else if (調査項目連番.equals(settei.getズボン等の着脱(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_10);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.getズボン等の着脱特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_10, 第２群);
            } else if (調査項目連番.equals(settei.get外出頻度(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_11);
                調査結果 = ChosaAnser13.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser13.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果, is今回結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get外出頻度特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_11, 第２群);
            }
        }
        set前回結果２(厚労省IF識別コード, 前回調査票調査項目, 第２群リスト, is前回結果);
        sbbisuJyoukyo.set認定調査と主治医意見書比較２(厚労省IF識別コード, 第２群リスト, 主治医意見書項目);
        return 第２群リスト;
    }

    private void set前回結果２(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第２群リスト,
            boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第２群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get移乗(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_0);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get移動(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_1);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.getえん下(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_2);
                前回調査結果 = ChosaAnser11.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser11.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.setえん下今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get食事摂取(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_3);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get排尿(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_4);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get排便(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_5);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            }
        }
        set前回結果比２(厚労省IF識別コード, 前回調査票調査項目, 第２群リスト, is前回結果);
    }

    private void set前回結果比２(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第２群リスト,
            boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第２群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get口腔清潔(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_6);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set口腔清潔今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get洗顔(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_7);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set口腔清潔今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get整髪(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_8);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set口腔清潔今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get上衣の着脱(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_9);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.getズボン等の着脱(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_10);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get外出頻度(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_11);
                前回調査結果 = ChosaAnser13.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser13.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set外出頻度今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            }
        }
    }

    private List<TiyosaKekka> get第３群リスト(Code 厚労省IF識別コード, 
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報, boolean is今回結果,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果, 
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目, List<RString> 認定調査票_特記情報) {
        List<TiyosaKekka> 第３群リスト = new IchijihanteikekkahyoKekka().get第３群リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoItemSetteiTwoA3 setteiT = new IchijihanteikekkahyoItemSetteiTwoA3();
        SabisuJyoukyoA3 sbbisuJyoukyo = new SabisuJyoukyoA3();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第３群;
            RString 調査結果;
            RString 調査結果コード;
            RString 調査項目連番 = new RString(調査票調査項目.getRemban());
            if (調査項目連番.equals(settei.get意思の伝達(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_0);
                調査結果 = ChosaAnser14.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser14.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果, is今回結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set特記事項有無(setteiT.get意思の伝達特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_0, 第３群);
            } else if (調査項目連番.equals(settei.get毎日の日課を理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_1);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果, is今回結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get毎日の日課を理解特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_1, 第３群);
            } else if (調査項目連番.equals(settei.get生年月日(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_2);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果, is今回結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get生年月日特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_2, 第３群);
            } else if (調査項目連番.equals(settei.get短期記憶(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_3);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果, is今回結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set特記事項有無(setteiT.get短期記憶特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_3, 第３群);
            } else if (調査項目連番.equals(settei.get自分の名前(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_4);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果, is今回結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get自分の名前特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_4, 第３群);
            } else if (調査項目連番.equals(settei.get今の季節を理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_5);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果, is今回結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get今の季節を理解特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_5, 第３群);
            } else if (調査項目連番.equals(settei.get場所の理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_6);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果, is今回結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get場所の理解特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_6, 第３群);
            } else if (調査項目連番.equals(settei.get徘徊(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_7);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                第３群.set特記事項有無(setteiT.get徘徊特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                set今回調査結果(第３群, 調査票調査項目, 調査結果, is今回結果);
                第３群.set調査結果コード(調査結果コード);
                第３群リスト.set(INT_7, 第３群);
            } else if (調査項目連番.equals(settei.get外出して戻(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_8);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果, is今回結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get外出して戻特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_8, 第３群);
            }
        }
        set前回結果３(厚労省IF識別コード, 前回調査票調査項目, 第３群リスト, is前回結果);
        sbbisuJyoukyo.set認定調査と主治医意見書比較３(厚労省IF識別コード, 第３群リスト, 主治医意見書項目);
        return 第３群リスト;
    }

    private void set前回結果３(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第３群リスト, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第３群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get意思の伝達(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_0);
                前回調査結果 = ChosaAnser14.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser14.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set意思の伝達今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get毎日の日課を理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_1);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get生年月日(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_2);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get短期記憶(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_3);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get自分の名前(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_4);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            }
        }
        set前回結果比３(厚労省IF識別コード, 前回調査票調査項目, 第３群リスト, is前回結果);
    }

    private void set前回結果比３(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第３群リスト, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第３群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get今の季節を理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_5);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get場所の理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_6);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get徘徊(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_7);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get外出して戻(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_8);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            }
        }
    }

    private List<TiyosaKekka> get第４群リスト(Code 厚労省IF識別コード, 
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報, boolean is今回結果,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果, 
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目, List<RString> 認定調査票_特記情報) {
        List<TiyosaKekka> 第４群リスト = new IchijihanteikekkahyoKekka().get第４群リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoItemSetteiTwoA3 setteiT = new IchijihanteikekkahyoItemSetteiTwoA3();
        SabisuJyoukyoA3 sbbisuJyoukyo = new SabisuJyoukyoA3();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第４群;
            RString 調査結果;
            RString 調査結果コード;
            RString 調査項目連番 = new RString(調査票調査項目.getRemban());
            if (調査項目連番.equals(settei.get被害的(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_0);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set特記事項有無(setteiT.get被害的特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_0, 第４群);
            } else if (調査項目連番.equals(settei.get作話(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_1);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get作話特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_1, 第４群);
            } else if (調査項目連番.equals(settei.get感情が不安定(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_2);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get感情が不安定特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_2, 第４群);
            } else if (調査項目連番.equals(settei.get昼夜逆転(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_3);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set特記事項有無(setteiT.get昼夜逆転特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_3, 第４群);
            } else if (調査項目連番.equals(settei.get同じ話をする(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_4);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get同じ話をする特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_4, 第４群);
            } else if (調査項目連番.equals(settei.get大声を出す(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_5);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get大声を出す特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_5, 第４群);
            } else if (調査項目連番.equals(settei.get介護に抵抗(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_6);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set特記事項有無(setteiT.get介護に抵抗特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_6, 第４群);
            } else if (調査項目連番.equals(settei.get落ち着きなし(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_7);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get落ち着きなし特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_7, 第４群);
            } else if (調査項目連番.equals(settei.get一人で出たがる(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_8);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get一人で出たがる特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_8, 第４群);
            } else if (調査項目連番.equals(settei.get収集癖(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_9);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get収集癖特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_9, 第４群);
            } else if (調査項目連番.equals(settei.get物や衣類を壊す(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_10);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get物や衣類を壊す特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_10, 第４群);
            } else if (調査項目連番.equals(settei.getひどい物忘れ(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_11);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.getひどい物忘れ特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_11, 第４群);
            } else if (調査項目連番.equals(settei.get独り言独り笑い(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_12);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get独り言独り笑い特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_12, 第４群);
            } else if (調査項目連番.equals(settei.get自分勝手(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_13);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get自分勝手特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_13, 第４群);
            } else if (調査項目連番.equals(settei.get話がまとまらない(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_14);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果, is今回結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get話がまとまらない特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_14, 第４群);
            }
        }
        set前回結果４(厚労省IF識別コード, 前回調査票調査項目, 第４群リスト, is前回結果);
        sbbisuJyoukyo.set認定調査と主治医意見書比較４(厚労省IF識別コード, 第４群リスト, 主治医意見書項目);
        return 第４群リスト;
    }

    private void set前回結果４(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第４群リスト, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第４群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get被害的(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_0);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get作話(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_1);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get感情が不安定(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_2);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get昼夜逆転(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_3);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get同じ話をする(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_4);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get大声を出す(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_5);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get介護に抵抗(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_6);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get落ち着きなし(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_7);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            }
        }
        set前回結果比４(厚労省IF識別コード, 前回調査票調査項目, 第４群リスト, is前回結果);
    }

    private void set前回結果比４(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第４群リスト, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第４群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get一人で出たがる(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_8);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get収集癖(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_9);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get物や衣類を壊す(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_10);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.getひどい物忘れ(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_11);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get独り言独り笑い(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_12);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get自分勝手(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_13);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get話がまとまらない(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_14);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            }
        }
    }

    private List<TiyosaKekka> get第５群リスト(Code 厚労省IF識別コード, 
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報, boolean is今回結果,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果, 
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目, List<RString> 認定調査票_特記情報) {
        List<TiyosaKekka> 第５群リスト = new IchijihanteikekkahyoKekka().get第５群リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoItemSetteiTwoA3 setteiT = new IchijihanteikekkahyoItemSetteiTwoA3();
        SabisuJyoukyoA3 sbbisuJyoukyo = new SabisuJyoukyoA3();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第５群;
            RString 調査結果;
            RString 調査結果コード;
            RString 調査項目連番 = new RString(調査票調査項目.getRemban());
            if (調査項目連番.equals(settei.get薬の内服(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_0);
                調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果, is今回結果);
                第５群.set調査結果コード(調査結果コード);
                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get薬の内服特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_0, 第５群);
            } else if (調査項目連番.equals(settei.get金銭の管理(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_1);
                調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果, is今回結果);
                第５群.set調査結果コード(調査結果コード);
                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get金銭の管理特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_1, 第５群);
            } else if (調査項目連番.equals(settei.get日常の意思決定(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_2);
                調査結果 = ChosaAnser17.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser17.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果, is今回結果);
                第５群.set調査結果コード(調査結果コード);
                第５群.set特記事項有無(setteiT.get日常の意思決定特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_2, 第５群);
            } else if (調査項目連番.equals(settei.get集団への不適応(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_3);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果, is今回結果);
                第５群.set調査結果コード(調査結果コード);
                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get集団への不適応特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_3, 第５群);
            } else if (調査項目連番.equals(settei.get買い物(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_4);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果, is今回結果);
                第５群.set調査結果コード(調査結果コード);
                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get買い物特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_4, 第５群);
            } else if (調査項目連番.equals(settei.get簡単な調理(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_5);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果, is今回結果);
                第５群.set調査結果コード(調査結果コード);
                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get簡単な調理特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_5, 第５群);
            }
        }
        set前回結果５(厚労省IF識別コード, 前回調査票調査項目, 第５群リスト, is前回結果);
        sbbisuJyoukyo.set認定調査と主治医意見書比較５(厚労省IF識別コード, 第５群リスト, 主治医意見書項目);
        return 第５群リスト;
    }

    private void set前回結果５(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第５群リスト, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 第５群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get薬の内服(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_0);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set口腔清潔今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get金銭の管理(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_1);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set口腔清潔今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get日常の意思決定(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_2);
                前回調査結果 = ChosaAnser17.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser17.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set日常の意思決定今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get集団への不適応(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_3);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set徘徊今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get買い物(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_4);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set移乗今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get簡単な調理(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_5);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set移乗今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            }
        }
    }

    private List<TiyosaKekka> get特別な医療リスト１(Code 厚労省IF識別コード, 
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報, boolean is今回結果,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, 
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目, List<RString> 認定調査票_特記情報) {
        List<TiyosaKekka> 特別な医療リスト１ = new IchijihanteikekkahyoKekka().get第５群リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoItemSetteiTwoA3 setteiT = new IchijihanteikekkahyoItemSetteiTwoA3();
        SabisuJyoukyoA3 sbbisuJyoukyo = new SabisuJyoukyoA3();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 特別な医療１;
            RString 調査結果;
            RString 調査結果コード;
            RString 調査項目連番 = new RString(調査票調査項目.getRemban());
            if (調査項目連番.equals(settei.get点滴の管理(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_0);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果, is今回結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.get点滴の管理特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_0, 特別な医療１);
            } else if (調査項目連番.equals(settei.get中心静脈栄養(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_1);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果, is今回結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.get中心静脈栄養特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_1, 特別な医療１);
            } else if (調査項目連番.equals(settei.get透析(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_2);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果, is今回結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.get透析特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_2, 特別な医療１);
            } else if (調査項目連番.equals(settei.getストーマの処置(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_3);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果, is今回結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.getストーマの処置特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_3, 特別な医療１);
            } else if (調査項目連番.equals(settei.get酸素療法(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_4);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果, is今回結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.get酸素療法特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_4, 特別な医療１);
            } else if (調査項目連番.equals(settei.getレスピレーター(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_5);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果, is今回結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.getレスピレーター特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_5, 特別な医療１);
            }
        }
        set特別な医療１(厚労省IF識別コード, 前回調査票調査項目, 特別な医療リスト１);
        sbbisuJyoukyo.set特別な医療リスト認定調査と主治医意見書比較１(厚労省IF識別コード, 特別な医療リスト１, 主治医意見書項目);
        return 特別な医療リスト１;
    }

    private void set特別な医療１(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 特別な医療リスト１) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 特別な医療１;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get点滴の管理(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_0);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療１.get調査結果コード(), 前回調査結果コード, 特別な医療１);
            } else if (前回調査票調査連番.equals(settei.get中心静脈栄養(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_1);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療１.get調査結果コード(), 前回調査結果コード, 特別な医療１);
            } else if (前回調査票調査連番.equals(settei.get透析(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_2);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療１.get調査結果コード(), 前回調査結果コード, 特別な医療１);
            } else if (前回調査票調査連番.equals(settei.getストーマの処置(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_3);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療１.get調査結果コード(), 前回調査結果コード, 特別な医療１);
            } else if (前回調査票調査連番.equals(settei.get酸素療法(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_4);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療１.get調査結果コード(), 前回調査結果コード, 特別な医療１);
            } else if (前回調査票調査連番.equals(settei.getレスピレーター(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_5);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療１.get調査結果コード(), 前回調査結果コード, 特別な医療１);
            }
        }
    }

    private void get第１群リスト１(Code 厚労省IF識別コード, List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            boolean is今回結果, List<RString> 認定調査票_特記情報, List<TiyosaKekka> 第１群リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoItemSetteiTwoA3 setteiT = new IchijihanteikekkahyoItemSetteiTwoA3();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第１群;
            RString 調査結果;
            RString 調査結果コード;
            RString 調査項目連番 = new RString(調査票調査項目.getRemban());
            if (調査項目連番.equals(settei.get起き上(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_10);
                調査結果 = ChosaAnser02.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser02.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                第１群.set調査結果(調査結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get起き上特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_10, 第１群);
            } else if (調査項目連番.equals(settei.get座位保持(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_11);
                調査結果 = ChosaAnser03.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser03.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get座位保持特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_11, 第１群);
            } else if (調査項目連番.equals(settei.get両足での立位(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_12);
                調査結果 = ChosaAnser04.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser04.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get両足での立位特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_12, 第１群);
            } else if (調査項目連番.equals(settei.get歩行(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_13);
                調査結果 = ChosaAnser02.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser02.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get歩行特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_13, 第１群);
            } else if (調査項目連番.equals(settei.get立ち上(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_14);
                調査結果 = ChosaAnser02.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser02.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get立ち上特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_14, 第１群);
            } else if (調査項目連番.equals(settei.get片足での立位(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_15);
                調査結果 = ChosaAnser04.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser04.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get片足での立位特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_15, 第１群);
            } else if (調査項目連番.equals(settei.get洗身(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_16);
                調査結果 = ChosaAnser06.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser06.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get洗身特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_16, 第１群);
            } else if (調査項目連番.equals(settei.getつめ切り(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_17);
                調査結果 = ChosaAnser07.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser07.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.getつめ切り特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_17, 第１群);
            } else if (調査項目連番.equals(settei.get視力(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_18);
                調査結果 = ChosaAnser08.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser08.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get視力特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_18, 第１群);
            } else if (調査項目連番.equals(settei.get聴力(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(INT_19);
                調査結果 = ChosaAnser09.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser09.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第１群, 調査票調査項目, 調査結果, is今回結果);
                第１群.set調査結果コード(調査結果コード);
                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第１群.set特記事項有無(setteiT.get聴力特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第１群リスト.set(INT_19, 第１群);
            }
        }
    }

    private List<TiyosaKekka> get特別な医療リスト２(Code 厚労省IF識別コード, 
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報, boolean is今回結果,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, 
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目, List<RString> 認定調査票_特記情報) {
        List<TiyosaKekka> 特別な医療リスト２ = new IchijihanteikekkahyoKekka().get第５群リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoItemSetteiTwoA3 setteiT = new IchijihanteikekkahyoItemSetteiTwoA3();
        SabisuJyoukyoA3 sbbisuJyoukyo = new SabisuJyoukyoA3();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 特別な医療２;
            RString 調査結果;
            RString 調査結果コード;
            RString 調査項目連番 = new RString(調査票調査項目.getRemban());
            if (調査項目連番.equals(settei.get気管切開の処置(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_0);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果, is今回結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.get気管切開の処置特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_0, 特別な医療２);
            } else if (調査項目連番.equals(settei.get疼痛の看護(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_1);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果, is今回結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.get疼痛の看護特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_1, 特別な医療２);
            } else if (調査項目連番.equals(settei.get経管栄養(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_2);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果, is今回結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.get経管栄養特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_2, 特別な医療２);
            } else if (調査項目連番.equals(settei.getモニター測定(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_3);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果, is今回結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.getモニター測定特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_3, 特別な医療２);
            } else if (調査項目連番.equals(settei.getじょくそうの処置(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_4);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果, is今回結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.getじょくそうの処置特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_4, 特別な医療２);
            } else if (調査項目連番.equals(settei.getカテーテル(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_5);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果, is今回結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.getカテーテル特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_5, 特別な医療２);
            }
        }
        set特別な医療２(厚労省IF識別コード, 前回調査票調査項目, 特別な医療リスト２);
        sbbisuJyoukyo.set特別な医療リスト認定調査と主治医意見書比較２(厚労省IF識別コード, 特別な医療リスト２, 主治医意見書項目);
        return 特別な医療リスト２;
    }

    private void set特別な医療２(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 特別な医療リスト２) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            TiyosaKekka 特別な医療２;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get気管切開の処置(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_0);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療２.get調査結果コード(), 前回調査結果コード, 特別な医療２);
            } else if (前回調査票調査連番.equals(settei.get疼痛の看護(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_1);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療２.get調査結果コード(), 前回調査結果コード, 特別な医療２);
            } else if (前回調査票調査連番.equals(settei.get経管栄養(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_2);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療２.get調査結果コード(), 前回調査結果コード, 特別な医療２);
            } else if (前回調査票調査連番.equals(settei.getモニター測定(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_3);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療２.get調査結果コード(), 前回調査結果コード, 特別な医療２);
            } else if (前回調査票調査連番.equals(settei.getじょくそうの処置(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_4);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療２.get調査結果コード(), 前回調査結果コード, 特別な医療２);
            } else if (前回調査票調査連番.equals(settei.getカテーテル(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_5);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(前回調査結果);
                kekka.set麻痺今回結果前回結果比(特別な医療２.get調査結果コード(), 前回調査結果コード, 特別な医療２);
            }
        }
    }

    private List<TiyosaKekka> get主治医意見書リスト(Code 厚労省IF識別コード, List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目情報,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報, boolean is前回結果) {
        List<TiyosaKekka> 主治医意見書リスト = new IchijihanteikekkahyoKekka().get主治医意見書リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書項目 : 主治医意見書項目情報) {
            TiyosaKekka 主治医意見書;
            RString 調査結果;
            RString 調査結果コード;
            RString 主治医意見書項目連番 = new RString(主治医意見書項目.getRemban());
            if (主治医意見書項目連番.equals(settei.get日常生活自立度(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_0);
                調査結果 = IkenKomoku03.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = IkenKomoku03.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_0, 主治医意見書);
            } else if (主治医意見書項目連番.equals(settei.get短期記憶意見書(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_1);
                調査結果 = IkenKomoku04.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = IkenKomoku04.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_1, 主治医意見書);
            } else if (主治医意見書項目連番.equals(settei.get認知能力(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_2);
                調査結果 = IkenKomoku05.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = IkenKomoku05.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_2, 主治医意見書);
            } else if (主治医意見書項目連番.equals(settei.get伝達能力(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_3);
                調査結果 = IkenKomoku06.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = IkenKomoku06.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_3, 主治医意見書);
            } else if (主治医意見書項目連番.equals(settei.get食事行為(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_4);
                調査結果 = IkenKomoku14.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = IkenKomoku14.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_4, 主治医意見書);
            }
        }
        set主治医意見書(厚労省IF識別コード, 前主治医意見書項目情報, 主治医意見書リスト, is前回結果);
        return 主治医意見書リスト;
    }

    private void set主治医意見書(Code 厚労省IF識別コード,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報, List<TiyosaKekka> 主治医意見書リスト, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5304ShujiiIkenshoIkenItemEntity 前主治医意見書項目 : 前主治医意見書項目情報) {
            TiyosaKekka 主治医意見書;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前主治医意見書項目連番 = new RString(前主治医意見書項目.getRemban());
            if (前主治医意見書項目連番.equals(settei.get日常生活自立度(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_0);
                前回調査結果 = IkenKomoku03.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = IkenKomoku03.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set日常生活自立度今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            } else if (前主治医意見書項目連番.equals(settei.get短期記憶意見書(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_1);
                前回調査結果 = IkenKomoku04.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = IkenKomoku04.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set短期記憶意見書今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            } else if (前主治医意見書項目連番.equals(settei.get認知能力(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_2);
                前回調査結果 = IkenKomoku05.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = IkenKomoku05.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set認知能力今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            } else if (前主治医意見書項目連番.equals(settei.get伝達能力(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_3);
                前回調査結果 = IkenKomoku06.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = IkenKomoku06.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set伝達能力今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            } else if (前主治医意見書項目連番.equals(settei.get食事行為(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_4);
                前回調査結果 = IkenKomoku14.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = IkenKomoku14.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                kekka.set食事行為今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            }
        }
    }

    private RString get前回結果(boolean is前回結果, RString 前回調査結果) {
        if (is前回結果) {
            return 前回調査結果;
        }
        return RString.EMPTY;
    }

    private RString copySharedFilesBatch(RDateTime sharedFileId, RString sharedFileName, RString path) {
        if (sharedFileId == null || RString.isNullOrEmpty(sharedFileName)) {
            return RString.EMPTY;
        }
        try {
            return DBEImageUtil.copySharedFiles(sharedFileId, sharedFileName, path);
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }

    private RString getコード_半角スペース除去(RString 編集前) {
        if (RString.isNullOrEmpty(編集前)) {
            return RString.EMPTY;
        }
        return 編集前.replace(" ", "");
    }
}
