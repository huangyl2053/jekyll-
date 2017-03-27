/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.TokkijikoIchiranJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事務局特記事項のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class IchijihanteiekkahyoTokkijiko {

    private static final RString テキスト全面イメージ = new RString("1");
    private static final RString ハイフン = new RString("-");
    private static final RString ファイルID_C4101 = new RString("C4101");
    private static final int 最大連番 = 10;
    private static final int 最大ページ = 6;
    private final List<TokkijikoIchiranJohoRelateEntity> 特記情報List;
    private final ShinsakaiSiryoKyotsuEntity kyotsuEntity;
    private final RString 特記パターン;
    private final int 最大文字数;
    private final int ページ最大表示行数;
    private final RString path;
    private final int 特記事項連番_1 = 1;
    private final int 二枚目特記事項開始番号 = 16;
    private final int 三枚目特記事項開始番号 = 50;

    /**
     * 事務局一次判定結果票Entityの設定。
     *
     * @param 特記情報List 特記情報List
     * @param kyotsuEntity kyotsuEntity
     * @param path ローカルコピーしたファイルパス
     */
    public IchijihanteiekkahyoTokkijiko(List<TokkijikoIchiranJohoRelateEntity> 特記情報List,
            ShinsakaiSiryoKyotsuEntity kyotsuEntity, RString path) {
        特記パターン = DbBusinessConfig.get(ConfigNameDBE.審査会資料調査特記パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        最大文字数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.特記事項行最大文字数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        this.ページ最大表示行数 = Integer.parseInt(DbBusinessConfig.get(
                ConfigNameDBE.特記事項最大表示行数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        this.特記情報List = 特記情報List;
        this.kyotsuEntity = kyotsuEntity;
        this.path = path;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return kyotsuEntity.getShinseishoKanriNo().value();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return kyotsuEntity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return kyotsuEntity.getHihokenshaNo();
    }

    /**
     * 名前を取得します。
     *
     * @return 名前
     */
    public RString get名前() {
        return kyotsuEntity.getHihokenshaName().getColumnValue();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return kyotsuEntity.getNinteiShinseiYMD();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return kyotsuEntity.getNinteichosaJisshiYMD();
    }

    /**
     * 介護認定審査会開催年月日を取得します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return kyotsuEntity.getShinsakaiKaisaiYMD();
    }

    /**
     * 特記パターンが2（短冊テキスト＆短冊イメージ＆全面イメージ）の場合、短冊情報リストを取得します。
     *
     * @return 短冊情報リスト
     */
    public List<TokkiJikou> get短冊情報リスト() {
        List<TokkiJikou> 短冊情報リスト = new ArrayList<>();
        boolean is項目名印字する = false;
        int 特記事項カウント = 1;
        if (!テキスト全面イメージ.equals(特記パターン)) {
            for (TokkijikoIchiranJohoRelateEntity entity : 特記情報List) {
                TokkiJikou 短冊情報 = new TokkiJikou();
                if (特記事項カウント == 二枚目特記事項開始番号 || 特記事項カウント == 三枚目特記事項開始番号) {
                    is項目名印字する = true;
                    特記事項カウント = 二枚目特記事項開始番号;
                }
                短冊情報.set事項番号(get項目番号(kyotsuEntity.getKoroshoIfShikibetsuCode(), entity));
                短冊情報.set項目名称(get項目名称(kyotsuEntity.getKoroshoIfShikibetsuCode(), entity, is項目名印字する));
                if (TokkijikoTextImageKubun.テキスト.getコード().equals(get特記事項テキスト_イメージ区分())) {
                    短冊情報.setテキストとイメージ(entity.get認定調査票特記事項Entity().getTokkiJiko());
                } else {
                    if (kyotsuEntity.isJimukyoku()) {
                        短冊情報.setテキストとイメージ(DBEImageUtil.getOriginalImageFilePath(path,
                                getFilePathByRemban(entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoNo(),
                                        entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoRemban())));
                    } else {
                        短冊情報.setテキストとイメージ(DBEImageUtil.getMaskOrOriginalImageFilePath(path,
                                getFilePathByRemban(entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoNo(),
                                        entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoRemban())));
                    }
                }
                短冊情報リスト.add(短冊情報);
                特記事項カウント++;
                is項目名印字する = false;
            }
        }
        return 短冊情報リスト;
    }

    /**
     * 全面特記事項イメージを取得します。
     *
     * @return 全面特記事項イメージを取得します
     */
    public List<RString> getTokkiImg() {
        List<RString> filePathList = new ArrayList<>();
        List<RString> 特記事項全面イメージファイルリスト = get特記事項全面イメージファイルリスト();
        for (RString 特記事項全面イメージファイル : 特記事項全面イメージファイルリスト) {
            RString tokkiImgPath;
            if (kyotsuEntity.isJimukyoku()) {
                tokkiImgPath = DBEImageUtil.getOriginalImageFilePath(path, 特記事項全面イメージファイル);
            } else {
                tokkiImgPath = DBEImageUtil.getMaskOrOriginalImageFilePath(path, 特記事項全面イメージファイル);
            }
            if (!RString.isNullOrEmpty(tokkiImgPath)) {
                filePathList.add(tokkiImgPath);
            }
        }
        return filePathList;
    }

    /**
     * 全面特記事項テキストを取得します。
     *
     * @return 全面特記事項テキストを取得します
     */
    public List<RString> getTokkiText() {
        List<RString> テキスト全面List = new ArrayList<>();
        if (テキスト全面イメージ.equals(特記パターン)) {
            テキスト全面List.addAll(getTextByテキスト全面イメージ());
        }
        return テキスト全面List;
    }

    /**
     * 全面特記事項テキストを取得します。
     *
     * @return 全面特記事項テキストを取得します
     */
    public RString get特記事項テキスト_イメージ区分() {
        for (TokkijikoIchiranJohoRelateEntity entity : 特記情報List) {
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(entity.get認定調査票特記事項Entity().getTokkijikoTextImageKubun())) {
                return TokkijikoTextImageKubun.イメージ.getコード();
            }
        }
        return TokkijikoTextImageKubun.テキスト.getコード();
    }

    private List<RString> getTextByテキスト全面イメージ() {
        List<RString> テキスト全面List = new ArrayList<>();
        RStringBuilder テキスト全面 = new RStringBuilder();
        int 表示行数 = 0;
        for (int i = 0; i < 特記情報List.size(); i++) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(特記情報List.get(i).get認定調査票特記事項Entity().getTokkijikoTextImageKubun())) {
                RStringBuilder テキストBuilder = new RStringBuilder();
                テキストBuilder.append(get特記事項テキスト(kyotsuEntity.getKoroshoIfShikibetsuCode(),
                        特記情報List.get(i).get認定調査票特記事項Entity().getNinteichosaTokkijikoNo(),
                        特記情報List.get(i).get認定調査票特記事項Entity().getNinteichosaTokkijikoRemban()));
                テキストBuilder.append(特記情報List.get(i).get認定調査票特記事項Entity().getTokkiJiko());
                テキストBuilder.append(System.lineSeparator());
                表示行数 = 表示行数 + (int) Math.ceil((double) テキストBuilder.length() / 最大文字数);
                if (表示行数 <= ページ最大表示行数) {
                    テキスト全面.append(テキストBuilder);
                }
                if (i == 特記情報List.size() - 1) {
                    setテキスト全面List(表示行数, テキスト全面List, テキスト全面, テキストBuilder);
                } else if (ページ最大表示行数 <= 表示行数) {
                    テキスト全面List.add(テキスト全面.toRString());
                    テキスト全面 = new RStringBuilder();
                    テキスト全面.append(テキストBuilder);
                    表示行数 = 0;
                }
            }
        }
        return テキスト全面List;
    }

    private void setテキスト全面List(int 表示行数, List<RString> テキスト全面List,
            RStringBuilder テキスト全面, RStringBuilder テキストBuilder) {
        if (ページ最大表示行数 < 表示行数) {
            テキスト全面List.add(テキスト全面.toRString());
            テキスト全面 = new RStringBuilder();
            テキスト全面.append(テキストBuilder);
            テキスト全面List.add(テキスト全面.toRString());
        } else {
            テキスト全面List.add(テキスト全面.toRString());
        }
    }

    private RString getFilePathByRemban(RString 特記事項番号, int 特記事項連番) {
        RString ファイル名;
        NinteiChosaTokkiJikou 認定調査特記事項;
        try {
            認定調査特記事項 = NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(特記事項番号);
            ファイル名 = 認定調査特記事項.getComposedImageFileName(特記事項連番);
            ファイル名.replace(".png", "");
        } catch (Exception e) {
            ファイル名 = RString.EMPTY;
        }
        return ファイル名;
    }

    private RString get特記事項テキスト(Code 厚労省IF識別コード, RString 調査特記事項番号, int 特記事項連番) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku99A 調査特記事項 = NinteichosaKomoku99A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku02A 調査特記事項 = NinteichosaKomoku02A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku06A 調査特記事項 = NinteichosaKomoku06A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku09A 調査特記事項 = NinteichosaKomoku09A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku09B 調査特記事項 = NinteichosaKomoku09B.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        }
        return RString.EMPTY;
    }

    private RString get項目名称(Code 厚労省IF識別コード, TokkijikoIchiranJohoRelateEntity 特記事項一覧情報Entity, boolean is項目名印字する) {
        RString 調査特記事項番号 = 特記事項一覧情報Entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoNo();
        if (特記事項一覧情報Entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoRemban() == 特記事項連番_1 || is項目名印字する) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                return NinteichosaKomoku99A.getAllBy調査特記事項番(調査特記事項番号).get名称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                return NinteichosaKomoku02A.getAllBy調査特記事項番(調査特記事項番号).get名称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                return NinteichosaKomoku06A.getAllBy調査特記事項番(調査特記事項番号).get名称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
                return NinteichosaKomoku09A.getAllBy調査特記事項番(調査特記事項番号).get名称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                return NinteichosaKomoku09B.getAllBy調査特記事項番(調査特記事項番号).get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString get項目番号(Code 厚労省IF識別コード, TokkijikoIchiranJohoRelateEntity 特記事項一覧情報Entity) {
        RStringBuilder 項目番号 = new RStringBuilder();
        RString 調査特記事項番号 = 特記事項一覧情報Entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoNo();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku99A.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku02A.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku06A.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku09A.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            項目番号.append(NinteichosaKomoku09B.getAllBy調査特記事項番(調査特記事項番号).get特記事項番号());
        }
        if (!RString.isNullOrEmpty(項目番号.toRString())) {
            if (特記事項一覧情報Entity.getMaxRemban() != 特記事項連番_1) {
                項目番号.append(ハイフン);
                項目番号.append(特記事項一覧情報Entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoRemban());
            }
        }
        return 項目番号.toRString();
    }

    private List<RString> get特記事項全面イメージファイルリスト() {
        List<RString> 特記事項全面イメージファイルリスト = new ArrayList<>();
        特記事項全面イメージファイルリスト.add(new RString("C4101"));
        特記事項全面イメージファイルリスト.add(new RString("C4102"));
        特記事項全面イメージファイルリスト.add(new RString("C4103"));
        特記事項全面イメージファイルリスト.add(new RString("C4104"));
        特記事項全面イメージファイルリスト.add(new RString("C4105"));
        特記事項全面イメージファイルリスト.add(new RString("C4106"));
        return 特記事項全面イメージファイルリスト;
    }
}
