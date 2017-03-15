/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.definition.core.kanri.ImageFileName;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TiyosaKekka;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.AnswerPattern;
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
import jp.co.ndensan.reams.uz.uza.lang.cast._CastDataTypeFactory;

/**
 * 事務局一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class IchijihanteikekkahyoItemSetteiA3 {

    private static final RString 認定調査主治結果 = new RString("未");
    private static final RString 印字する = new RString("1");
    private static final RString 差分のみ印字する = new RString("3");
    private static final RString IMAGEFILENAME_概況調査特記 = new RString("C0007");
    private static final RString 調査結果_正常値 = new RString("1");
    private static final RString 凡例文言_前回との比較_改善 = new RString("▽n：前回よりn段階改善");
    private static final RString 凡例文言_前回との比較_悪化 = new RString("▲n：前回よりn段階悪化");
    private static final RString 凡例文言_特記事項符号 = new RString(" ※：特記事項");
    private static final RString 凡例文言_主治医が問題視 = new RString("★：（不整合）主治医が問題視");
    private static final RString 凡例文言_調査員が問題視 = new RString("☆：（不整合）調査員が問題視");
    private static final RString 凡例文言_意見書が未記入 = new RString("未：（不整合）意見書が未記入");
    private static final RString 前回結果認定ソフトバージョン記号 = new RString("(*)");
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
    private boolean is前回結果印字 = false;
    private boolean is前回結果差分のみ印字 = false;
    private boolean is前回結果正常値印字 = false;
    private boolean is今回結果正常値印字 = false;
    private boolean is前回今回比較結果印字 = false;
    private boolean is調査意見書比較結果印字 = false;

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
        
        RDate 日期 = RDate.getNowDate();
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回基本調査項目結果の正常選択肢印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            is今回結果正常値印字 = true;
        }
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            is前回結果印字 = true;
            if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回前回比較で変化有で前回正常選択肢表示印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
                is前回結果正常値印字 = true;
            }
        } else if (差分のみ印字する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            is前回結果差分のみ印字 = true;
            if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回前回比較で変化有で前回正常選択肢表示印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
                is前回結果正常値印字 = true;
            }
        }
        
        IchijihanteikekkahyoA3Entity 項目 = new IchijihanteikekkahyoA3Entity();
        項目.set合議体番号(合議体番号);
        項目.set審査人数合計(new RString(データ件数));
        項目.set識別コード(entity.getShoKisaiHokenshaNo().substring(INT_0, INT_5).concat(entity.getHihokenshaNo()));
        
        RString 共有ファイル名 = 共通情報.getShoKisaiHokenshaNo().concat(共通情報.getHihokenshaNo());
        RString path = copySharedFilesBatch(共通情報.getImageSharedFileId(), 共有ファイル名, ファイルパス);
        SabisuJyoukyoA3 settei = new SabisuJyoukyoA3();
        settei.set項目(項目, entity);
        settei.setサービスの状況(entity, 項目, 予防給付, 介護給付, サービス状況フラグ, 共通情報, path);
        
        項目.set概況調査テキスト_イメージ区分(共通情報.getGaikyoChosaTextImageKubun());
        項目.set概況特記のテキスト(共通情報.getTokki());
        if (共通情報.isJimukyoku()) {
            項目.set概況特記のイメージ(DBEImageUtil.getOriginalImageFilePath(path, ImageFileName.概況調査特記.getImageFileName()));
        } else {
            項目.set概況特記のイメージ(DBEImageUtil.getMaskOrOriginalImageFilePath(path, ImageFileName.概況調査特記.getImageFileName()));
        }
        
        IchijihanteiekkahyoTokkijiko tokkijiko = new IchijihanteiekkahyoTokkijiko(特記情報, 共通情報, path);
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
        
        Code 厚労省IF識別コード = entity.getKoroshoIfShikibetsuCode();
        List<RString> 認定調査特記事項 = settei.get認定調査特記事項番号(認定調査票_特記情報);
        項目.set第１群リスト(get第１群リスト(厚労省IF識別コード, 調査票調査項目, 前回調査票調査項目, 主治医意見書項目, 認定調査特記事項));
        項目.set第２群リスト(get第２群リスト(厚労省IF識別コード, 調査票調査項目, 前回調査票調査項目, 主治医意見書項目, 認定調査特記事項));
        項目.set第３群リスト(get第３群リスト(厚労省IF識別コード, 調査票調査項目, 前回調査票調査項目, 主治医意見書項目, 認定調査特記事項));
        項目.set第４群リスト(get第４群リスト(厚労省IF識別コード, 調査票調査項目, 前回調査票調査項目, 主治医意見書項目, 認定調査特記事項));
        項目.set第５群リスト(get第５群リスト(厚労省IF識別コード, 調査票調査項目, 前回調査票調査項目, 主治医意見書項目, 認定調査特記事項));
        項目.set主治医意見書(get主治医意見書リスト(厚労省IF識別コード, 主治医意見書項目情報, 前主治医意見書項目情報));
        項目.set特別な医療リスト１(get特別な医療リスト１(厚労省IF識別コード, 調査票調査項目, 前回調査票調査項目, 主治医意見書項目, 認定調査特記事項));
        項目.set特別な医療リスト２(get特別な医療リスト２(厚労省IF識別コード, 調査票調査項目, 前回調査票調査項目, 主治医意見書項目, 認定調査特記事項));
        
        set凡例文言(項目);
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査項目 : 前回調査票調査項目) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査項目.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査項目.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査項目.getKoroshoIfShikibetsuCode().getColumnValue())) {
                項目.set前回結果バージョン記号(前回結果認定ソフトバージョン記号);
            } else {
                項目.set前回結果バージョン記号(RString.EMPTY);
            }
            break;
        }
        return 項目;
    }

    private void set凡例文言(IchijihanteikekkahyoA3Entity 項目) {
        boolean is前回との結果比較印刷する = false;
        boolean is特記事項符号印刷する = false;
        boolean is認定調査と意見書の結果比較印刷する = false;
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.前回との結果比較印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            is前回との結果比較印刷する = true;
        }
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.特記事項符号印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            is特記事項符号印刷する = true;
        }
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査と主治医意見書の結果比較印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            is認定調査と意見書の結果比較印刷する = true;
        }

        項目.set凡例1(RString.EMPTY);
        項目.set凡例2(RString.EMPTY);
        項目.set凡例3(RString.EMPTY);
        項目.set凡例4(RString.EMPTY);
        項目.set凡例5(RString.EMPTY);
        項目.set凡例6(RString.EMPTY);
        if (is前回との結果比較印刷する) {
            項目.set凡例1(凡例文言_前回との比較_改善);
            項目.set凡例2(凡例文言_前回との比較_悪化);
            if (is特記事項符号印刷する) {
                項目.set凡例3(凡例文言_特記事項符号);
            }
            if (is認定調査と意見書の結果比較印刷する) {
                項目.set凡例4(凡例文言_主治医が問題視);
                項目.set凡例5(凡例文言_調査員が問題視);
                項目.set凡例6(凡例文言_意見書が未記入);
            }
        } else {
            if (is特記事項符号印刷する) {
                項目.set凡例1(凡例文言_特記事項符号);
                if (is認定調査と意見書の結果比較印刷する) {
                    項目.set凡例4(凡例文言_主治医が問題視);
                    項目.set凡例5(凡例文言_調査員が問題視);
                    項目.set凡例6(凡例文言_意見書が未記入);
                }
            } else {
                if (is認定調査と意見書の結果比較印刷する) {
                    項目.set凡例1(凡例文言_主治医が問題視);
                    項目.set凡例2(凡例文言_調査員が問題視);
                    項目.set凡例3(凡例文言_意見書が未記入);
                }
            }
        }
    }

    private List<TiyosaKekka> get第１群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目, List<RString> 認定調査票_特記情報) {
        List<TiyosaKekka> 第１群リスト = new IchijihanteikekkahyoKekka().get第１群リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        SabisuJyoukyoA3 sbbisuJyoukyo = new SabisuJyoukyoA3();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            RString 調査項目連番 = new RString(調査票調査項目.getRemban());
            if (調査項目連番.equals(settei.get麻痺_左上肢(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_0);
            } else if (調査項目連番.equals(settei.get麻痺_右上肢(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_1);
            } else if (調査項目連番.equals(settei.get麻痺_左下肢(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_2);
            } else if (調査項目連番.equals(settei.get麻痺_右下肢(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_3);
            } else if (調査項目連番.equals(settei.get麻痺_その他(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_4);
            } else if (調査項目連番.equals(settei.get拘縮_肩関節(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_5);
            } else if (調査項目連番.equals(settei.get拘縮_股関節(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_6);
            } else if (調査項目連番.equals(settei.get拘縮_膝関節(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_7);
            } else if (調査項目連番.equals(settei.get拘縮_その他(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_8);
            } else if (調査項目連番.equals(settei.get寝返り(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_9);
            } else if (調査項目連番.equals(settei.get起き上(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_10);
            } else if (調査項目連番.equals(settei.get座位保持(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_11);
            } else if (調査項目連番.equals(settei.get両足での立位(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_12);
            } else if (調査項目連番.equals(settei.get歩行(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_13);
            } else if (調査項目連番.equals(settei.get立ち上(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_14);
            } else if (調査項目連番.equals(settei.get片足での立位(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_15);
            } else if (調査項目連番.equals(settei.get洗身(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_16);
            } else if (調査項目連番.equals(settei.getつめ切り(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_17);
            } else if (調査項目連番.equals(settei.get視力(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_18);
            } else if (調査項目連番.equals(settei.get聴力(厚労省IF識別コード))) {
                set今回結果(厚労省IF識別コード, 認定調査票_特記情報, 調査票調査項目, 第１群リスト, INT_19);
            }
        }
        set前回結果_第１群(厚労省IF識別コード, 前回調査票調査項目, 第１群リスト);
        sbbisuJyoukyo.set認定調査と主治医意見書比較_第１群(厚労省IF識別コード, 第１群リスト, 主治医意見書項目);
        return 第１群リスト;
    }

    private void set今回調査結果(TiyosaKekka 調査群, DbT5211NinteichosahyoChosaItemEntity 調査票調査項目, RString 調査結果) {
        if (is今回結果正常値印字) {
            調査群.set調査結果(調査結果);
        } else {
            if (調査結果_正常値.equals(調査票調査項目.getResearchItem())) {
                調査群.set調査結果(RString.EMPTY);
            } else {
                調査群.set調査結果(調査結果);
            }
        }
    }

    private void set今回結果(Code 厚労省IF識別コード, List<RString> 認定調査票_特記情報,
            DbT5211NinteichosahyoChosaItemEntity 調査票調査項目, List<TiyosaKekka> 調査結果リスト, int index) {
        TiyosaKekka 調査結果 = 調査結果リスト.get(index);
        AnswerPattern answerPattern = getAnswerPattern(厚労省IF識別コード, 調査票調査項目);
        if (answerPattern != null) {
            RString 調査結果名称 = answerPattern.get回答略称(getコード_半角スペース除去(調査票調査項目.getResearchItem()));
            RString 調査結果コード = answerPattern.get回答コード(getコード_半角スペース除去(調査票調査項目.getResearchItem()));
            set今回調査結果(調査結果, 調査票調査項目, 調査結果名称);
            調査結果.set調査結果コード(調査結果コード);
        }
//                第１群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
        set特記事項有無(厚労省IF識別コード, 認定調査票_特記情報, 調査結果, index);
        調査結果リスト.set(index, 調査結果);
    }

    private void set特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査票_特記情報, TiyosaKekka 調査結果, int index) {
        IchijihanteikekkahyoItemSetteiTwoA3 一次判定結果票特記事項設定 = new IchijihanteikekkahyoItemSetteiTwoA3();
        switch (index) {
            case 0:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get麻痺特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 1:
                調査結果.set特記事項有無(RString.EMPTY);
                break;
            case 2:
                調査結果.set特記事項有無(RString.EMPTY);
                break;
            case 3:
                調査結果.set特記事項有無(RString.EMPTY);
                break;
            case 4:
                調査結果.set特記事項有無(RString.EMPTY);
                break;
            case 5:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get拘縮特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 6:
                調査結果.set特記事項有無(RString.EMPTY);
                break;
            case 7:
                調査結果.set特記事項有無(RString.EMPTY);
                break;
            case 8:
                調査結果.set特記事項有無(RString.EMPTY);
                break;
            case 9:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get寝返特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 10:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get起き上特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 11:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get座位保持特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 12:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get両足での立位特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 13:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get歩行特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 14:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get立ち上特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 15:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get片足での立位特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 16:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get洗身特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 17:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.getつめ切り特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 18:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get視力特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            case 19:
                調査結果.set特記事項有無(一次判定結果票特記事項設定.get聴力特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                break;
            default:
                調査結果.set特記事項有無(RString.EMPTY);
        }
    }

    private AnswerPattern getAnswerPattern(Code 厚労省IF識別コード, DbT5211NinteichosahyoChosaItemEntity 調査票調査項目) {
        if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return AnswerPattern.toValue(NinteichosaKomokuMapping99A.toValue(new RString(調査票調査項目.getRemban())).getパターンNo());
        } else if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return AnswerPattern.toValue(NinteichosaKomokuMapping02A.toValue(new RString(調査票調査項目.getRemban())).getパターンNo());
        } else if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return AnswerPattern.toValue(NinteichosaKomokuMapping06A.toValue(new RString(調査票調査項目.getRemban())).getパターンNo());
        } else if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return AnswerPattern.toValue(NinteichosaKomokuMapping09A.toValue(new RString(調査票調査項目.getRemban())).getパターンNo());
        } else if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return AnswerPattern.toValue(NinteichosaKomokuMapping09B.toValue(new RString(調査票調査項目.getRemban())).getパターンNo());
        } else {
            return null;
        }
    }

    private void set前回結果_第１群(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 調査結果リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        RString 前回調査票調査連番;
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get麻痺_左上肢(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_0);
            } else if (前回調査票調査連番.equals(settei.get麻痺_右上肢(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_1);
            } else if (前回調査票調査連番.equals(settei.get麻痺_左下肢(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_2);
            } else if (前回調査票調査連番.equals(settei.get麻痺_右下肢(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_3);
            } else if (前回調査票調査連番.equals(settei.get麻痺_その他(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_4);
            } else if (前回調査票調査連番.equals(settei.get拘縮_肩関節(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_5);
            } else if (前回調査票調査連番.equals(settei.get拘縮_股関節(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_6);
            } else if (前回調査票調査連番.equals(settei.get拘縮_膝関節(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_7);
            } else if (前回調査票調査連番.equals(settei.get拘縮_その他(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_8);
            } else if (前回調査票調査連番.equals(settei.get寝返り(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_9);
            } else if (前回調査票調査連番.equals(settei.get起き上(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_10);
            } else if (前回調査票調査連番.equals(settei.get座位保持(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_11);
            } else if (前回調査票調査連番.equals(settei.get両足での立位(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_12);
            } else if (前回調査票調査連番.equals(settei.get歩行(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_13);
            } else if (前回調査票調査連番.equals(settei.get立ち上(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_14);
            } else if (前回調査票調査連番.equals(settei.get片足での立位(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_15);
            } else if (前回調査票調査連番.equals(settei.get洗身(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_16);
            } else if (前回調査票調査連番.equals(settei.getつめ切り(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_17);
            } else if (前回調査票調査連番.equals(settei.get視力(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_18);
            } else if (前回調査票調査連番.equals(settei.get聴力(厚労省IF識別コード))) {
                set前回今回比較結果(厚労省IF識別コード, 前回調査票調査, 調査結果リスト, INT_19);
            }
        }
    }

    private void set前回今回比較結果(Code 厚労省IF識別コード, DbT5211NinteichosahyoChosaItemEntity 前回調査票調査, 
            List<TiyosaKekka> 調査結果リスト, int index) {
        TiyosaKekka 調査結果 = 調査結果リスト.get(index);
        AnswerPattern answerPattern = getAnswerPattern(厚労省IF識別コード, 前回調査票調査);
        if (answerPattern != null) {
            RString 前回調査結果 = answerPattern.get回答略称(getコード_半角スペース除去(前回調査票調査.getResearchItem()));
            調査結果.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
            RString 前回調査結果コード = answerPattern.get回答コード(getコード_半角スペース除去(前回調査票調査.getResearchItem()));
            set前回今回比較結果By回答パターン(調査結果, 前回調査結果コード, answerPattern);
        }
    }

    private void set前回今回比較結果By回答パターン(TiyosaKekka 調査結果, RString 前回調査結果コード, AnswerPattern answerPattern) {
        IchijihanteikekkahyoKekka 一次判定結果 = new IchijihanteikekkahyoKekka();
        if (AnswerPattern.回答パターン1.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン１(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン2.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン２(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン3.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン３(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン4.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン４(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン6.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン６(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン7.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン７(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン8.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン８(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン9.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン９(調査結果, 前回調査結果コード);
        }
    }

    private List<TiyosaKekka> get第２群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目,
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
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get移乗特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_0, 第２群);
            } else if (調査項目連番.equals(settei.get移動(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_1);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get移動特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_1, 第２群);
            } else if (調査項目連番.equals(settei.getえん下(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_2);
                調査結果 = ChosaAnser11.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser11.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.getえん下特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_2, 第２群);
            } else if (調査項目連番.equals(settei.get食事摂取(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_3);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
                第２群.set特記事項有無(setteiT.get食事摂取特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_3, 第２群);
            } else if (調査項目連番.equals(settei.get排尿(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_4);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get排尿特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_4, 第２群);
            } else if (調査項目連番.equals(settei.get排便(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_5);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get排便特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_5, 第２群);
            } else if (調査項目連番.equals(settei.get口腔清潔(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_6);
                調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get口腔清潔特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_6, 第２群);
            } else if (調査項目連番.equals(settei.get洗顔(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_7);
                調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get洗顔特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_7, 第２群);
            } else if (調査項目連番.equals(settei.get整髪(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_8);
                調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get整髪特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_8, 第２群);
            } else if (調査項目連番.equals(settei.get上衣の着脱(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_9);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get上衣の着脱特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_9, 第２群);
            } else if (調査項目連番.equals(settei.getズボン等の着脱(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_10);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.getズボン等の着脱特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_10, 第２群);
            } else if (調査項目連番.equals(settei.get外出頻度(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_11);
                調査結果 = ChosaAnser13.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser13.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第２群, 調査票調査項目, 調査結果);
                第２群.set調査結果コード(調査結果コード);
//                第２群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第２群.set特記事項有無(setteiT.get外出頻度特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第２群リスト.set(INT_11, 第２群);
            }
        }
        set前回結果２(厚労省IF識別コード, 前回調査票調査項目, 第２群リスト);
        sbbisuJyoukyo.set認定調査と主治医意見書比較_第２群(厚労省IF識別コード, 第２群リスト, 主治医意見書項目);
        return 第２群リスト;
    }

    private void set前回結果２(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第２群リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 第２群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get移乗(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_0);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get移動(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_1);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.getえん下(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_2);
                前回調査結果 = ChosaAnser11.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser11.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.setえん下今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get食事摂取(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_3);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get排尿(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_4);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get排便(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_5);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            }
        }
        set前回結果比２(厚労省IF識別コード, 前回調査票調査項目, 第２群リスト);
    }

    private void set前回結果比２(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第２群リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 第２群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get口腔清潔(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_6);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set口腔清潔今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get洗顔(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_7);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set口腔清潔今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get整髪(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_8);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set口腔清潔今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get上衣の着脱(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_9);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.getズボン等の着脱(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_10);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set移乗今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            } else if (前回調査票調査連番.equals(settei.get外出頻度(厚労省IF識別コード))) {
                第２群 = 第２群リスト.get(INT_11);
                前回調査結果 = ChosaAnser13.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser13.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第２群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set外出頻度今回結果前回結果比(第２群.get調査結果コード(), 前回調査結果コード, 第２群);
            }
        }
    }

    private List<TiyosaKekka> get第３群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目,
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
                set今回調査結果(第３群, 調査票調査項目, 調査結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set特記事項有無(setteiT.get意思の伝達特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_0, 第３群);
            } else if (調査項目連番.equals(settei.get毎日の日課を理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_1);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果);
                第３群.set調査結果コード(調査結果コード);
//                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get毎日の日課を理解特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_1, 第３群);
            } else if (調査項目連番.equals(settei.get生年月日(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_2);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果);
                第３群.set調査結果コード(調査結果コード);
//                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get生年月日特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_2, 第３群);
            } else if (調査項目連番.equals(settei.get短期記憶(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_3);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果);
                第３群.set調査結果コード(調査結果コード);
                第３群.set特記事項有無(setteiT.get短期記憶特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_3, 第３群);
            } else if (調査項目連番.equals(settei.get自分の名前(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_4);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果);
                第３群.set調査結果コード(調査結果コード);
//                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get自分の名前特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_4, 第３群);
            } else if (調査項目連番.equals(settei.get今の季節を理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_5);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果);
                第３群.set調査結果コード(調査結果コード);
//                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get今の季節を理解特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_5, 第３群);
            } else if (調査項目連番.equals(settei.get場所の理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_6);
                調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果);
                第３群.set調査結果コード(調査結果コード);
//                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get場所の理解特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_6, 第３群);
            } else if (調査項目連番.equals(settei.get徘徊(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_7);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                第３群.set特記事項有無(setteiT.get徘徊特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                set今回調査結果(第３群, 調査票調査項目, 調査結果);
                第３群.set調査結果コード(調査結果コード);
                第３群リスト.set(INT_7, 第３群);
            } else if (調査項目連番.equals(settei.get外出して戻(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_8);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第３群, 調査票調査項目, 調査結果);
                第３群.set調査結果コード(調査結果コード);
//                第３群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第３群.set特記事項有無(setteiT.get外出して戻特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第３群リスト.set(INT_8, 第３群);
            }
        }
        set前回結果３(厚労省IF識別コード, 前回調査票調査項目, 第３群リスト);
        sbbisuJyoukyo.set認定調査と主治医意見書比較_第３群(厚労省IF識別コード, 第３群リスト, 主治医意見書項目);
        return 第３群リスト;
    }

    private void set前回結果３(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第３群リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 第３群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get意思の伝達(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_0);
                前回調査結果 = ChosaAnser14.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser14.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set意思の伝達今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get毎日の日課を理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_1);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get生年月日(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_2);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get短期記憶(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_3);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get自分の名前(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_4);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            }
        }
        set前回結果比３(厚労省IF識別コード, 前回調査票調査項目, 第３群リスト);
    }

    private void set前回結果比３(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第３群リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 第３群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get今の季節を理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_5);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get場所の理解(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_6);
                前回調査結果 = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser15.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set毎日の日課を理解今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get徘徊(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_7);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            } else if (前回調査票調査連番.equals(settei.get外出して戻(厚労省IF識別コード))) {
                第３群 = 第３群リスト.get(INT_8);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第３群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第３群.get調査結果コード(), 前回調査結果コード, 第３群);
            }
        }
    }

    private List<TiyosaKekka> get第４群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目,
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
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set特記事項有無(setteiT.get被害的特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_0, 第４群);
            } else if (調査項目連番.equals(settei.get作話(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_1);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get作話特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_1, 第４群);
            } else if (調査項目連番.equals(settei.get感情が不安定(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_2);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get感情が不安定特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_2, 第４群);
            } else if (調査項目連番.equals(settei.get昼夜逆転(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_3);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set特記事項有無(setteiT.get昼夜逆転特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_3, 第４群);
            } else if (調査項目連番.equals(settei.get同じ話をする(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_4);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get同じ話をする特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_4, 第４群);
            } else if (調査項目連番.equals(settei.get大声を出す(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_5);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get大声を出す特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_5, 第４群);
            } else if (調査項目連番.equals(settei.get介護に抵抗(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_6);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
                第４群.set特記事項有無(setteiT.get介護に抵抗特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_6, 第４群);
            } else if (調査項目連番.equals(settei.get落ち着きなし(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_7);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get落ち着きなし特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_7, 第４群);
            } else if (調査項目連番.equals(settei.get一人で出たがる(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_8);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get一人で出たがる特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_8, 第４群);
            } else if (調査項目連番.equals(settei.get収集癖(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_9);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get収集癖特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_9, 第４群);
            } else if (調査項目連番.equals(settei.get物や衣類を壊す(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_10);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get物や衣類を壊す特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_10, 第４群);
            } else if (調査項目連番.equals(settei.getひどい物忘れ(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_11);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.getひどい物忘れ特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_11, 第４群);
            } else if (調査項目連番.equals(settei.get独り言独り笑い(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_12);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get独り言独り笑い特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_12, 第４群);
            } else if (調査項目連番.equals(settei.get自分勝手(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_13);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get自分勝手特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_13, 第４群);
            } else if (調査項目連番.equals(settei.get話がまとまらない(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_14);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第４群, 調査票調査項目, 調査結果);
                第４群.set調査結果コード(調査結果コード);
//                第４群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第４群.set特記事項有無(setteiT.get話がまとまらない特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第４群リスト.set(INT_14, 第４群);
            }
        }
        set前回結果４(厚労省IF識別コード, 前回調査票調査項目, 第４群リスト);
        sbbisuJyoukyo.set認定調査と主治医意見書比較_第４群(厚労省IF識別コード, 第４群リスト, 主治医意見書項目);
        return 第４群リスト;
    }

    private void set前回結果４(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第４群リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 第４群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get被害的(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_0);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get作話(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_1);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get感情が不安定(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_2);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get昼夜逆転(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_3);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get同じ話をする(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_4);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get大声を出す(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_5);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get介護に抵抗(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_6);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get落ち着きなし(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_7);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            }
        }
        set前回結果比４(厚労省IF識別コード, 前回調査票調査項目, 第４群リスト);
    }

    private void set前回結果比４(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第４群リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 第４群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get一人で出たがる(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_8);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get収集癖(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_9);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get物や衣類を壊す(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_10);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.getひどい物忘れ(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_11);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get独り言独り笑い(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_12);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get自分勝手(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_13);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            } else if (前回調査票調査連番.equals(settei.get話がまとまらない(厚労省IF識別コード))) {
                第４群 = 第４群リスト.get(INT_14);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第４群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第４群.get調査結果コード(), 前回調査結果コード, 第４群);
            }
        }
    }

    private List<TiyosaKekka> get第５群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目,
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
                set今回調査結果(第５群, 調査票調査項目, 調査結果);
                第５群.set調査結果コード(調査結果コード);
//                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get薬の内服特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_0, 第５群);
            } else if (調査項目連番.equals(settei.get金銭の管理(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_1);
                調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果);
                第５群.set調査結果コード(調査結果コード);
//                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get金銭の管理特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_1, 第５群);
            } else if (調査項目連番.equals(settei.get日常の意思決定(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_2);
                調査結果 = ChosaAnser17.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser17.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果);
                第５群.set調査結果コード(調査結果コード);
                第５群.set特記事項有無(setteiT.get日常の意思決定特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_2, 第５群);
            } else if (調査項目連番.equals(settei.get集団への不適応(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_3);
                調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果);
                第５群.set調査結果コード(調査結果コード);
//                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get集団への不適応特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_3, 第５群);
            } else if (調査項目連番.equals(settei.get買い物(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_4);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果);
                第５群.set調査結果コード(調査結果コード);
//                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get買い物特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_4, 第５群);
            } else if (調査項目連番.equals(settei.get簡単な調理(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_5);
                調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(第５群, 調査票調査項目, 調査結果);
                第５群.set調査結果コード(調査結果コード);
//                第５群.set認定調査と主治医意見書の結果比較(認定調査主治結果);
                第５群.set特記事項有無(setteiT.get簡単な調理特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                第５群リスト.set(INT_5, 第５群);
            }
        }
        set前回結果５(厚労省IF識別コード, 前回調査票調査項目, 第５群リスト);
        sbbisuJyoukyo.set認定調査と主治医意見書比較_第５群(厚労省IF識別コード, 第５群リスト, 主治医意見書項目);
        return 第５群リスト;
    }

    private void set前回結果５(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<TiyosaKekka> 第５群リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 第５群;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get薬の内服(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_0);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set口腔清潔今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get金銭の管理(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_1);
                前回調査結果 = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser12.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set口腔清潔今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get日常の意思決定(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_2);
                前回調査結果 = ChosaAnser17.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser17.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set日常の意思決定今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get集団への不適応(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_3);
                前回調査結果 = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser16.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set徘徊今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get買い物(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_4);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set移乗今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            } else if (前回調査票調査連番.equals(settei.get簡単な調理(厚労省IF識別コード))) {
                第５群 = 第５群リスト.get(INT_5);
                前回調査結果 = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser10.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                第５群.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set移乗今回結果前回結果比(第５群.get調査結果コード(), 前回調査結果コード, 第５群);
            }
        }
    }

    private List<TiyosaKekka> get特別な医療リスト１(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
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
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.get点滴の管理特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_0, 特別な医療１);
            } else if (調査項目連番.equals(settei.get中心静脈栄養(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_1);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.get中心静脈栄養特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_1, 特別な医療１);
            } else if (調査項目連番.equals(settei.get透析(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_2);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.get透析特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_2, 特別な医療１);
            } else if (調査項目連番.equals(settei.getストーマの処置(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_3);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.getストーマの処置特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_3, 特別な医療１);
            } else if (調査項目連番.equals(settei.get酸素療法(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_4);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果);
                特別な医療１.set調査結果コード(調査結果コード);
                特別な医療１.set特記事項有無(setteiT.get酸素療法特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト１.set(INT_4, 特別な医療１);
            } else if (調査項目連番.equals(settei.getレスピレーター(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_5);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療１, 調査票調査項目, 調査結果);
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
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 特別な医療１;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get点滴の管理(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_0);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療１, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.get中心静脈栄養(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_1);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療１, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.get透析(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_2);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療１, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.getストーマの処置(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_3);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療１, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.get酸素療法(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_4);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療１, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.getレスピレーター(厚労省IF識別コード))) {
                特別な医療１ = 特別な医療リスト１.get(INT_5);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療１.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療１, 前回調査結果コード);
            }
        }
    }

    private List<TiyosaKekka> get特別な医療リスト２(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
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
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.get気管切開の処置特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_0, 特別な医療２);
            } else if (調査項目連番.equals(settei.get疼痛の看護(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_1);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.get疼痛の看護特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_1, 特別な医療２);
            } else if (調査項目連番.equals(settei.get経管栄養(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_2);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.get経管栄養特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_2, 特別な医療２);
            } else if (調査項目連番.equals(settei.getモニター測定(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_3);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.getモニター測定特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_3, 特別な医療２);
            } else if (調査項目連番.equals(settei.getじょくそうの処置(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_4);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果);
                特別な医療２.set調査結果コード(調査結果コード);
                特別な医療２.set特記事項有無(setteiT.getじょくそうの処置特記事項有無(厚労省IF識別コード, 認定調査票_特記情報));
                特別な医療リスト２.set(INT_4, 特別な医療２);
            } else if (調査項目連番.equals(settei.getカテーテル(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_5);
                調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).get略称();
                調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(調査票調査項目.getResearchItem())).getコード();
                set今回調査結果(特別な医療２, 調査票調査項目, 調査結果);
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
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回調査票調査.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 特別な医療２;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前回調査票調査連番 = new RString(前回調査票調査.getRemban());
            if (前回調査票調査連番.equals(settei.get気管切開の処置(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_0);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療２, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.get疼痛の看護(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_1);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療２, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.get経管栄養(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_2);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療２, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.getモニター測定(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_3);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療２, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.getじょくそうの処置(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_4);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療２, 前回調査結果コード);
            } else if (前回調査票調査連番.equals(settei.getカテーテル(厚労省IF識別コード))) {
                特別な医療２ = 特別な医療リスト２.get(INT_5);
                前回調査結果 = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).get略称();
                前回調査結果コード = ChosaAnser01.toValue(getコード_半角スペース除去(前回調査票調査.getResearchItem())).getコード();
                特別な医療２.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set前回今回比較結果_回答パターン１(特別な医療２, 前回調査結果コード);
            }
        }
    }

    private List<TiyosaKekka> get主治医意見書リスト(Code 厚労省IF識別コード, List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目情報,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報) {
        List<TiyosaKekka> 主治医意見書リスト = new IchijihanteikekkahyoKekka().get主治医意見書リスト();
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書項目 : 主治医意見書項目情報) {
            TiyosaKekka 主治医意見書;
            RString 調査結果;
            RString 調査結果コード;
            RString 主治医意見書項目連番 = new RString(主治医意見書項目.getRemban());
            if (主治医意見書項目連番.equals(settei.get日常生活自立度(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_0);
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku03.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku03.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_0, 主治医意見書);
            } else if (主治医意見書項目連番.equals(settei.get短期記憶意見書(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_1);
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku04.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku04.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_1, 主治医意見書);
            } else if (主治医意見書項目連番.equals(settei.get認知能力(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_2);
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku05.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku05.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_2, 主治医意見書);
            } else if (主治医意見書項目連番.equals(settei.get伝達能力(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_3);
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku06.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku06.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_3, 主治医意見書);
            } else if (主治医意見書項目連番.equals(settei.get食事行為(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_4);
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku14.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku14.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
                主治医意見書リスト.set(INT_4, 主治医意見書);
            }
        }
        set主治医意見書(厚労省IF識別コード, 前主治医意見書項目情報, 主治医意見書リスト);
        return 主治医意見書リスト;
    }

    private void set主治医意見書(Code 厚労省IF識別コード,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報, List<TiyosaKekka> 主治医意見書リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        for (DbT5304ShujiiIkenshoIkenItemEntity 前主治医意見書項目 : 前主治医意見書項目情報) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前主治医意見書項目.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前主治医意見書項目.getKoroshoIfShikibetsuCode().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前主治医意見書項目.getKoroshoIfShikibetsuCode().getColumnValue())) {
                break;
            }
            TiyosaKekka 主治医意見書;
            RString 前回調査結果コード;
            RString 前回調査結果;
            RString 前主治医意見書項目連番 = new RString(前主治医意見書項目.getRemban());
            if (前主治医意見書項目連番.equals(settei.get日常生活自立度(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_0);
                前回調査結果 = RString.isNullOrEmpty(前主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku03.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                        : IkenKomoku03.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set日常生活自立度今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            } else if (前主治医意見書項目連番.equals(settei.get短期記憶意見書(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_1);
                前回調査結果 = RString.isNullOrEmpty(前主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku04.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                        : IkenKomoku04.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set短期記憶意見書今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            } else if (前主治医意見書項目連番.equals(settei.get認知能力(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_2);
                前回調査結果 = RString.isNullOrEmpty(前主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku05.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                        : IkenKomoku05.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set認知能力今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            } else if (前主治医意見書項目連番.equals(settei.get伝達能力(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_3);
                前回調査結果 = RString.isNullOrEmpty(前主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku06.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                        : IkenKomoku06.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set伝達能力今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            } else if (前主治医意見書項目連番.equals(settei.get食事行為(厚労省IF識別コード))) {
                主治医意見書 = 主治医意見書リスト.get(INT_4);
                前回調査結果 = RString.isNullOrEmpty(前主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku14.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).get略称();
                前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                        : IkenKomoku14.toValue(getコード_半角スペース除去(前主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set前回結果(is前回結果印字 ? 前回調査結果 : RString.EMPTY);
                kekka.set食事行為今回結果前回結果比(主治医意見書.get調査結果コード(), 前回調査結果コード, 主治医意見書);
            }
        }
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
