/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryo.ChosahyoIkenshoComparisonItem09B;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TiyosaKekka;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.TokkijikoIchiranJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.INinteichosaKomokuMapping;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.AnswerPattern;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class IchijihanteikekkahyoItemSetteiA3 {

    private static final RString 印字する = new RString("1");
    private static final RString IMAGEFILENAME_概況調査特記 = new RString("C0007");
    private static final RString 調査結果_正常値 = new RString("1");
    private static final RString 凡例文言_前回との比較_改善 = new RString("▽n：前回よりn段階改善");
    private static final RString 凡例文言_前回との比較_悪化 = new RString("▲n：前回よりn段階悪化");
    private static final RString 凡例文言_特記事項符号 = new RString(" ※：特記事項");
    private static final RString 凡例文言_主治医が問題視 = new RString("★：（不整合）主治医が問題視");
    private static final RString 凡例文言_調査員が問題視 = new RString("☆：（不整合）調査員が問題視");
    private static final RString 凡例文言_意見書が未記入 = new RString("未：（不整合）意見書が未記入");
    private static final RString 前回結果認定ソフトバージョン記号 = new RString("(*)");
    private static final RString 特記事項有 = new RString("※");
    private static final RString ハイフン = new RString("－");
    private static final RString 第１群 = new RString("1");
    private static final RString 第２群 = new RString("2");
    private static final RString 第３群 = new RString("3");
    private static final RString 第４群 = new RString("4");
    private static final RString 第５群 = new RString("5");
    private static final RString 特別な医療群 = new RString("6");
    private static final int INT_0 = 0;
    private static final int INT_5 = 5;
    private boolean is前回結果正常値印字 = false;
    private boolean is今回結果正常値印字 = false;
    private boolean is特記事項符号印字 = false;

    /**
     * 事務局一次判定結果票Entityの設定。
     *
     * @param entity ItiziHanteiEntity
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
    public IchijihanteikekkahyoA3Entity set項目(ItiziHanteiEntity entity, List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目情報,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報, List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付,
            List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付, DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ,
            int データ件数, ShinsakaiSiryoKyotsuEntity 共通情報, List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目, RString 合議体番号,
            List<TokkijikoIchiranJohoRelateEntity> 特記情報, RString ファイルパス) {
        RDate 日期 = RDate.getNowDate();
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回基本調査項目結果の正常選択肢印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            is今回結果正常値印字 = true;
        }
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回前回比較で変化有で前回正常選択肢表示印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            is前回結果正常値印字 = true;
        }
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.特記事項符号印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            is特記事項符号印字 = true;
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
            項目.set概況特記のイメージ(DBEImageUtil.getOriginalImageFilePath(path, IMAGEFILENAME_概況調査特記));
        } else {
            項目.set概況特記のイメージ(DBEImageUtil.getMaskOrOriginalImageFilePath(path, IMAGEFILENAME_概況調査特記));
        }

        IchijihanteiekkahyoTokkijiko tokkijiko = new IchijihanteiekkahyoTokkijiko(特記情報, 共通情報, ファイルパス);
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
        Code 前回厚労省IF識別コード = entity.getZKoroshoIfShikibetsuCode();
        List<TiyosaKekka> 第１群リスト = new ArrayList<>();
        List<TiyosaKekka> 第２群リスト = new ArrayList<>();
        List<TiyosaKekka> 第３群リスト = new ArrayList<>();
        List<TiyosaKekka> 第４群リスト = new ArrayList<>();
        List<TiyosaKekka> 第５群リスト = new ArrayList<>();
        List<TiyosaKekka> 特別な医療リスト = new ArrayList<>();
        set基本調査結果リスト(厚労省IF識別コード, 調査票調査項目, 主治医意見書項目, 特記情報,
                第１群リスト, 第２群リスト, 第３群リスト, 第４群リスト, 第５群リスト, 特別な医療リスト);
        set前回調査結果(前回厚労省IF識別コード, 前回調査票調査項目, 第１群リスト, 第２群リスト, 第３群リスト, 第４群リスト, 第５群リスト, 特別な医療リスト);
        項目.set第１群リスト(第１群リスト);
        項目.set第２群リスト(第２群リスト);
        項目.set第３群リスト(第３群リスト);
        項目.set第４群リスト(第４群リスト);
        項目.set第５群リスト(第５群リスト);
        List<TiyosaKekka> 特別な医療リスト_前半 = new ArrayList<>();
        List<TiyosaKekka> 特別な医療リスト_後半 = new ArrayList<>();
        int 特別な医療調査結果_中間数 = 特別な医療リスト.size() / 2;
        for (int index = 0; index < 特別な医療リスト.size() - 1; index++) {
            if (index < 特別な医療調査結果_中間数) {
                特別な医療リスト_前半.add(特別な医療リスト.get(index));
            } else {
                特別な医療リスト_後半.add(特別な医療リスト.get(index));
            }
        }
        項目.set特別な医療リスト１(特別な医療リスト_前半);
        項目.set特別な医療リスト２(特別な医療リスト_後半);

        List<TiyosaKekka> 主治医意見書リスト = new ArrayList<>();
        set主治医意見書リスト(厚労省IF識別コード, 前回厚労省IF識別コード, 主治医意見書項目情報, 前主治医意見書項目情報, 主治医意見書リスト);
        項目.set主治医意見書(主治医意見書リスト);

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

    private void set基本調査結果リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目,
            List<TokkijikoIchiranJohoRelateEntity> 認定調査票_特記情報,
            List<TiyosaKekka> 第１群リスト,
            List<TiyosaKekka> 第２群リスト,
            List<TiyosaKekka> 第３群リスト,
            List<TiyosaKekka> 第４群リスト,
            List<TiyosaKekka> 第５群リスト,
            List<TiyosaKekka> 特別な医療リスト) {
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            INinteichosaKomokuMapping 認定調査項目マッピング = get認定調査項目マッピング(厚労省IF識別コード, 調査票調査項目);
            TiyosaKekka 調査結果 = get調査結果(認定調査項目マッピング, 認定調査票_特記情報, 調査票調査項目.getResearchItem(), 主治医意見書項目);
            if (第１群.equals(認定調査項目マッピング.get群番号())) {
                第１群リスト.add(調査結果);
            } else if (第２群.equals(認定調査項目マッピング.get群番号())) {
                第２群リスト.add(調査結果);
            } else if (第３群.equals(認定調査項目マッピング.get群番号())) {
                第３群リスト.add(調査結果);
            } else if (第４群.equals(認定調査項目マッピング.get群番号())) {
                第４群リスト.add(調査結果);
            } else if (第５群.equals(認定調査項目マッピング.get群番号())) {
                第５群リスト.add(調査結果);
            } else if (特別な医療群.equals(認定調査項目マッピング.get群番号())) {
                特別な医療リスト.add(調査結果);
            }
        }
    }

    private TiyosaKekka get調査結果(INinteichosaKomokuMapping 認定調査項目マッピング,
            List<TokkijikoIchiranJohoRelateEntity> 認定調査票_特記情報,
            RString 調査票調査結果,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目) {
        TiyosaKekka 調査結果 = new TiyosaKekka();
        SabisuJyoukyoA3 sbbisuJyoukyo = new SabisuJyoukyoA3();
        AnswerPattern answerPattern = AnswerPattern.toValue(認定調査項目マッピング.getパターンNo());
        調査結果.set連番(認定調査項目マッピング.get連番());
        調査結果.set調査結果コード(調査票調査結果);
        if (is今回調査結果印字(調査票調査結果)) {
            RString 調査結果名称 = answerPattern.get回答略称(getコード_半角スペース除去(調査票調査結果));
            調査結果.set調査結果(調査結果名称);
        } else {
            調査結果.set調査結果(RString.EMPTY);
        }
        ChosahyoIkenshoComparisonItem09B 調査票意見書比較項目;
        try {
            調査票意見書比較項目 = ChosahyoIkenshoComparisonItem09B.toValue_NinteiChosahyoItemRemban(認定調査項目マッピング.getコード());
        } catch (IllegalArgumentException e) {
            調査票意見書比較項目 = null;
        }
        if (調査票意見書比較項目 != null) {
            sbbisuJyoukyo.set認定調査と主治医意見書比較(調査票意見書比較項目, 認定調査項目マッピング, 調査結果, 主治医意見書項目);
        }
        調査結果.set特記事項有無(get特記事項符号(認定調査項目マッピング, 認定調査票_特記情報));
        return 調査結果;
    }

    private void set前回調査結果(Code 前回厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目,
            List<TiyosaKekka> 第１群リスト,
            List<TiyosaKekka> 第２群リスト,
            List<TiyosaKekka> 第３群リスト,
            List<TiyosaKekka> 第４群リスト,
            List<TiyosaKekka> 第５群リスト,
            List<TiyosaKekka> 特別な医療リスト) {
        outSide:
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            INinteichosaKomokuMapping 認定調査項目マッピング = get認定調査項目マッピング(前回厚労省IF識別コード, 前回調査票調査);
            if (第１群.equals(認定調査項目マッピング.get群番号())) {
                for (TiyosaKekka 調査結果 : 第１群リスト) {
                    if (調査結果.get連番() == 認定調査項目マッピング.get連番()) {
                        set前回今回比較結果(前回厚労省IF識別コード, 認定調査項目マッピング, 前回調査票調査.getResearchItem(), 調査結果);
                        continue outSide;
                    }
                }
            } else if (第２群.equals(認定調査項目マッピング.get群番号())) {
                for (TiyosaKekka 調査結果 : 第２群リスト) {
                    if (調査結果.get連番() == 認定調査項目マッピング.get連番()) {
                        set前回今回比較結果(前回厚労省IF識別コード, 認定調査項目マッピング, 前回調査票調査.getResearchItem(), 調査結果);
                        continue outSide;
                    }
                }
            } else if (第３群.equals(認定調査項目マッピング.get群番号())) {
                for (TiyosaKekka 調査結果 : 第３群リスト) {
                    if (調査結果.get連番() == 認定調査項目マッピング.get連番()) {
                        set前回今回比較結果(前回厚労省IF識別コード, 認定調査項目マッピング, 前回調査票調査.getResearchItem(), 調査結果);
                        continue outSide;
                    }
                }
            } else if (第４群.equals(認定調査項目マッピング.get群番号())) {
                for (TiyosaKekka 調査結果 : 第４群リスト) {
                    if (調査結果.get連番() == 認定調査項目マッピング.get連番()) {
                        set前回今回比較結果(前回厚労省IF識別コード, 認定調査項目マッピング, 前回調査票調査.getResearchItem(), 調査結果);
                        continue outSide;
                    }
                }
            } else if (第５群.equals(認定調査項目マッピング.get群番号())) {
                for (TiyosaKekka 調査結果 : 第５群リスト) {
                    if (調査結果.get連番() == 認定調査項目マッピング.get連番()) {
                        set前回今回比較結果(前回厚労省IF識別コード, 認定調査項目マッピング, 前回調査票調査.getResearchItem(), 調査結果);
                        continue outSide;
                    }
                }
            } else if (特別な医療群.equals(認定調査項目マッピング.get群番号())) {
                for (TiyosaKekka 調査結果 : 特別な医療リスト) {
                    if (調査結果.get連番() == 認定調査項目マッピング.get連番()) {
                        set前回今回比較結果(前回厚労省IF識別コード, 認定調査項目マッピング, 前回調査票調査.getResearchItem(), 調査結果);
                        continue outSide;
                    }
                }
            }
        }
        if (前回調査票調査項目 == null || 前回調査票調査項目.isEmpty()) {
            for (TiyosaKekka 調査結果 : 第１群リスト) {
                調査結果.set前回結果(ハイフン);
            }
            for (TiyosaKekka 調査結果 : 第２群リスト) {
                調査結果.set前回結果(ハイフン);
            }
            for (TiyosaKekka 調査結果 : 第３群リスト) {
                調査結果.set前回結果(ハイフン);
            }
            for (TiyosaKekka 調査結果 : 第４群リスト) {
                調査結果.set前回結果(ハイフン);
            }
            for (TiyosaKekka 調査結果 : 第５群リスト) {
                調査結果.set前回結果(ハイフン);
            }
            for (TiyosaKekka 調査結果 : 特別な医療リスト) {
                調査結果.set前回結果(ハイフン);
            }
        }
    }

    private boolean is今回調査結果印字(RString 調査票調査結果) {
        if (is今回結果正常値印字) {
            return true;
        } else {
            if (調査結果_正常値.equals(調査票調査結果)) {
                return false;
            } else {
                return true;
            }
        }
    }

    private RString get特記事項符号(INinteichosaKomokuMapping 認定調査項目マッピング, List<TokkijikoIchiranJohoRelateEntity> 認定調査票_特記情報) {
        for (TokkijikoIchiranJohoRelateEntity 特記事項Entity : 認定調査票_特記情報) {
            if (特記事項Entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoNo().equals(認定調査項目マッピング.get特記事項番号())) {
                return is特記事項符号印字 ? 特記事項有 : RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    private INinteichosaKomokuMapping get認定調査項目マッピング(Code 厚労省IF識別コード, DbT5211NinteichosahyoChosaItemEntity 調査票調査項目) {
        if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return NinteichosaKomokuMapping99A.toValue(new RString(調査票調査項目.getRemban()));
        } else if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return NinteichosaKomokuMapping02A.toValue(new RString(調査票調査項目.getRemban()));
        } else if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return NinteichosaKomokuMapping06A.toValue(new RString(調査票調査項目.getRemban()));
        } else if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return NinteichosaKomokuMapping09A.toValue(new RString(調査票調査項目.getRemban()));
        } else if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(厚労省IF識別コード.getColumnValue())) {
            return NinteichosaKomokuMapping09B.toValue(new RString(調査票調査項目.getRemban()));
        } else {
            return null;
        }
    }

    private void set前回今回比較結果(Code 前回厚労省IF識別コード,
            INinteichosaKomokuMapping 認定調査項目マッピング,
            RString 前回調査票調査結果,
            TiyosaKekka 調査結果) {
        if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回厚労省IF識別コード.getColumnValue())
                || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回厚労省IF識別コード.getColumnValue())
                || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回厚労省IF識別コード.getColumnValue())) {
            調査結果.set前回結果(ハイフン);
            return;
        }
        AnswerPattern answerPattern = AnswerPattern.toValue(認定調査項目マッピング.getパターンNo());
        if (is前回調査結果印字(前回調査票調査結果, 調査結果.get調査結果コード())) {
            RString 前回調査結果名称 = answerPattern.get回答略称(getコード_半角スペース除去(前回調査票調査結果));
            調査結果.set前回結果(前回調査結果名称);
        } else {
            調査結果.set前回結果(RString.EMPTY);
        }
        set前回今回比較結果By回答パターン(調査結果, 前回調査票調査結果, answerPattern);
    }

    private boolean is前回調査結果印字(RString 前回調査票調査結果, RString 今回調査票調査結果) {
        if (!今回調査票調査結果.equals(前回調査票調査結果)) {
            if (is前回結果正常値印字) {
                return true;
            } else {
                if (調査結果_正常値.equals(前回調査票調査結果)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private void set前回今回比較結果By回答パターン(TiyosaKekka 調査結果, RString 前回調査結果コード, AnswerPattern answerPattern) {
        IchijihanteikekkahyoKekka 一次判定結果 = new IchijihanteikekkahyoKekka();
        if (AnswerPattern.回答パターン1.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン1(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン2.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン2(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン3.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン3(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン4.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン4(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン6.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン6(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン7.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン7(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン8.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン8(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン9.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン9(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン10.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン10(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン11.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン11(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン12.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン12(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン13.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン13(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン14.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン14(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン15.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン15(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン16.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン16(調査結果, 前回調査結果コード);
        } else if (AnswerPattern.回答パターン17.getコード().equals(answerPattern.getコード())) {
            一次判定結果.set前回今回比較結果_回答パターン17(調査結果, 前回調査結果コード);
        }
    }

    private List<TiyosaKekka> set主治医意見書リスト(Code 厚労省IF識別コード,
            Code 前回厚労省IF識別コード,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目情報,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報,
            List<TiyosaKekka> 主治医意見書リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書項目 : 主治医意見書項目情報) {
            TiyosaKekka 主治医意見書 = null;
            RString 調査結果;
            RString 調査結果コード;
            RString 主治医意見書項目連番 = new RString(主治医意見書項目.getRemban());
            if (主治医意見書項目連番.equals(settei.get日常生活自立度(厚労省IF識別コード))) {
                主治医意見書 = new TiyosaKekka();
                主治医意見書.set連番(Integer.parseInt(主治医意見書項目連番.toString()));
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku03.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku03.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
            } else if (主治医意見書項目連番.equals(settei.get短期記憶意見書(厚労省IF識別コード))) {
                主治医意見書 = new TiyosaKekka();
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku04.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku04.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
            } else if (主治医意見書項目連番.equals(settei.get認知能力(厚労省IF識別コード))) {
                主治医意見書 = new TiyosaKekka();
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku05.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku05.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
            } else if (主治医意見書項目連番.equals(settei.get伝達能力(厚労省IF識別コード))) {
                主治医意見書 = new TiyosaKekka();
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku06.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku06.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
            } else if (主治医意見書項目連番.equals(settei.get食事行為(厚労省IF識別コード))) {
                主治医意見書 = new TiyosaKekka();
                調査結果 = RString.isNullOrEmpty(主治医意見書項目.getIkenItem()) ? RString.EMPTY
                        : IkenKomoku14.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).get略称();
                調査結果コード = RString.isNullOrEmpty(調査結果) ? RString.EMPTY
                        : IkenKomoku14.toValue(getコード_半角スペース除去(主治医意見書項目.getIkenItem())).getコード();
                主治医意見書.set調査結果(調査結果);
                主治医意見書.set調査結果コード(調査結果コード);
            }
            if (主治医意見書 != null) {
                主治医意見書リスト.add(主治医意見書);
            }
        }
        set前回主治医意見書(前回厚労省IF識別コード, 前主治医意見書項目情報, 主治医意見書リスト);
        return 主治医意見書リスト;
    }

    private void set前回主治医意見書(Code 前回厚労省IF識別コード,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前回主治医意見書項目情報,
            List<TiyosaKekka> 主治医意見書リスト) {
        IchijihanteikekkahyoItemSetteiThreeA3 settei = new IchijihanteikekkahyoItemSetteiThreeA3();
        IchijihanteikekkahyoKekka kekka = new IchijihanteikekkahyoKekka();
        outSide:
        for (DbT5304ShujiiIkenshoIkenItemEntity 前回主治医意見書項目 : 前回主治医意見書項目情報) {
            RString 前回調査結果コード;
            RString 前回調査結果;
            if (new RString(前回主治医意見書項目.getRemban()).equals(settei.get日常生活自立度(前回厚労省IF識別コード))) {
                for (TiyosaKekka 主治医意見書 : 主治医意見書リスト) {
                    if (主治医意見書.get連番() == 前回主治医意見書項目.getRemban()) {
                        if (isFraud厚労省IF識別コード(前回厚労省IF識別コード)) {
                            主治医意見書.set前回結果(ハイフン);
                            continue outSide;
                        }
                        前回調査結果 = RString.isNullOrEmpty(前回主治医意見書項目.getIkenItem()) ? RString.EMPTY
                                : IkenKomoku03.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).get略称();
                        前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                                : IkenKomoku03.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).getコード();
                        if (is前回調査結果印字(前回調査結果, 主治医意見書.get調査結果コード())) {
                            主治医意見書.set前回結果(前回調査結果);
                        } else {
                            主治医意見書.set前回結果(RString.EMPTY);
                        }
                        kekka.set日常生活自立度今回結果前回結果比(主治医意見書, 前回調査結果コード);
                    }
                }
            } else if (new RString(前回主治医意見書項目.getRemban()).equals(settei.get短期記憶意見書(前回厚労省IF識別コード))) {
                for (TiyosaKekka 主治医意見書 : 主治医意見書リスト) {
                    if (主治医意見書.get連番() == 前回主治医意見書項目.getRemban()) {
                        if (isFraud厚労省IF識別コード(前回厚労省IF識別コード)) {
                            主治医意見書.set前回結果(ハイフン);
                            continue outSide;
                        }
                        前回調査結果 = RString.isNullOrEmpty(前回主治医意見書項目.getIkenItem()) ? RString.EMPTY
                                : IkenKomoku04.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).get略称();
                        前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                                : IkenKomoku04.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).getコード();
                        if (is前回調査結果印字(前回調査結果, 主治医意見書.get調査結果コード())) {
                            主治医意見書.set前回結果(前回調査結果);
                        } else {
                            主治医意見書.set前回結果(RString.EMPTY);
                        }
                        kekka.set短期記憶意見書今回結果前回結果比(主治医意見書, 前回調査結果コード);
                    }
                }
            } else if (new RString(前回主治医意見書項目.getRemban()).equals(settei.get認知能力(前回厚労省IF識別コード))) {
                for (TiyosaKekka 主治医意見書 : 主治医意見書リスト) {
                    if (主治医意見書.get連番() == 前回主治医意見書項目.getRemban()) {
                        if (isFraud厚労省IF識別コード(前回厚労省IF識別コード)) {
                            主治医意見書.set前回結果(ハイフン);
                            continue outSide;
                        }
                        前回調査結果 = RString.isNullOrEmpty(前回主治医意見書項目.getIkenItem()) ? RString.EMPTY
                                : IkenKomoku05.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).get略称();
                        前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                                : IkenKomoku05.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).getコード();
                        if (is前回調査結果印字(前回調査結果, 主治医意見書.get調査結果コード())) {
                            主治医意見書.set前回結果(前回調査結果);
                        } else {
                            主治医意見書.set前回結果(RString.EMPTY);
                        }
                        kekka.set認知能力今回結果前回結果比(主治医意見書, 前回調査結果コード);
                    }
                }
            } else if (new RString(前回主治医意見書項目.getRemban()).equals(settei.get伝達能力(前回厚労省IF識別コード))) {
                for (TiyosaKekka 主治医意見書 : 主治医意見書リスト) {
                    if (主治医意見書.get連番() == 前回主治医意見書項目.getRemban()) {
                        if (isFraud厚労省IF識別コード(前回厚労省IF識別コード)) {
                            主治医意見書.set前回結果(ハイフン);
                            continue outSide;
                        }
                        前回調査結果 = RString.isNullOrEmpty(前回主治医意見書項目.getIkenItem()) ? RString.EMPTY
                                : IkenKomoku06.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).get略称();
                        前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                                : IkenKomoku06.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).getコード();
                        if (is前回調査結果印字(前回調査結果, 主治医意見書.get調査結果コード())) {
                            主治医意見書.set前回結果(前回調査結果);
                        } else {
                            主治医意見書.set前回結果(RString.EMPTY);
                        }
                        kekka.set伝達能力今回結果前回結果比(主治医意見書, 前回調査結果コード);
                    }
                }
            } else if (new RString(前回主治医意見書項目.getRemban()).equals(settei.get食事行為(前回厚労省IF識別コード))) {
                for (TiyosaKekka 主治医意見書 : 主治医意見書リスト) {
                    if (主治医意見書.get連番() == 前回主治医意見書項目.getRemban()) {
                        if (isFraud厚労省IF識別コード(前回厚労省IF識別コード)) {
                            主治医意見書.set前回結果(ハイフン);
                            continue outSide;
                        }
                        前回調査結果 = RString.isNullOrEmpty(前回主治医意見書項目.getIkenItem()) ? RString.EMPTY
                                : IkenKomoku14.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).get略称();
                        前回調査結果コード = RString.isNullOrEmpty(前回調査結果) ? RString.EMPTY
                                : IkenKomoku14.toValue(getコード_半角スペース除去(前回主治医意見書項目.getIkenItem())).getコード();
                        if (is前回調査結果印字(前回調査結果, 主治医意見書.get調査結果コード())) {
                            主治医意見書.set前回結果(前回調査結果);
                        } else {
                            主治医意見書.set前回結果(RString.EMPTY);
                        }
                        kekka.set食事行為今回結果前回結果比(主治医意見書, 前回調査結果コード);
                    }
                }
            }
        }
    }

    private boolean isFraud厚労省IF識別コード(Code 前回厚労省IF識別コード) {
        if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(前回厚労省IF識別コード.getColumnValue())
                || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(前回厚労省IF識別コード.getColumnValue())
                || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(前回厚労省IF識別コード.getColumnValue())) {
            return true;
        }
        return false;
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
