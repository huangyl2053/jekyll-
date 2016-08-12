/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 委員用特記事項の編集クラスです。
 *
 * @reamsid_L DBE-0150-200 wangxiaodong
 */
public class TokkiText1A4Business {

    private static final RString ファイルID_C0007 = new RString("C0007.png");
    private static final RString ファイルID_C0007BAK = new RString("C0007_BAK.png");
    private static final RString テキスト全面イメージ = new RString("1");
    private static final RString テキスト = new RString("1");
    private static final RString イメージ = new RString("2");
    private static final RString ハイフン = new RString("-");
    private static final int 一ページ表示行数 = 15;
    private static final int 最大連番 = 10;
    private final List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List;
    private final ShinsakaiSiryoKyotsuEntity kyotsuEntity;
    private final RString 特記パターン;
    private final int 最大文字数;
    private final int ページ最大表示行数;
    private final boolean is2枚目以降;
    private final int 現在ページ;
    private boolean has改ページ;
    private int 表示行数;

    /**
     * コンストラクタです。
     *
     * @param is2枚目以降 boolean
     * @param 現在ページ int
     * @param entity ShinsakaiSiryoKyotsuEntity
     * @param 特記情報List List<DbT5205NinteichosahyoTokkijikoEntity>
     */
    public TokkiText1A4Business(boolean is2枚目以降, int 現在ページ,
            ShinsakaiSiryoKyotsuEntity entity, List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List) {
        this.特記パターン = DbBusinessConfig.get(ConfigNameDBE.審査会資料調査特記パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        this.最大文字数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.特記事項行最大文字数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        this.ページ最大表示行数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.特記事項最大表示行数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        this.現在ページ = 現在ページ;
        this.is2枚目以降 = is2枚目以降;
        this.特記情報List = 特記情報List;
        this.kyotsuEntity = entity;
        has改ページ = false;
        表示行数 = 0;
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
     * 概況特記テキスト_イメージ区分を取得します。
     *
     * @return 概況特記テキスト_イメージ区分
     */
    public RString get概況特記テキスト_イメージ区分() {
        return kyotsuEntity.getGaikyoChosaTextImageKubun();
    }

    /**
     * 概況調査の特記事項テキストを取得します。
     *
     * @return 概況調査の特記事項テキスト
     */
    public RString get概況調査の特記事項テキスト() {
        if (テキスト.equals(kyotsuEntity.getGaikyoChosaTextImageKubun())) {
            return kyotsuEntity.getTokki();
        }
        return RString.EMPTY;
    }

    /**
     * 概況調査の特記事項イメージを取得します。
     *
     * @return 概況調査の特記事項イメージ
     */
    public RString get概況調査の特記事項イメージ() {
        if (イメージ.equals(kyotsuEntity.getGaikyoChosaTextImageKubun())) {
            if (kyotsuEntity.isJimukyoku()) {
                return getFilePath(kyotsuEntity.getImageSharedFileId(), ファイルID_C0007BAK);
            } else {
                return getFilePath(kyotsuEntity.getImageSharedFileId(), ファイルID_C0007);
            }
        }
        return RString.EMPTY;
    }

    /**
     * 委員用区分を取得します。
     *
     * @return 委員用、「true」は委員です、それ以外、委員ではない
     */
    public boolean is委員用() {
        return !kyotsuEntity.isJimukyoku();
    }

    /**
     * 特記パターンが2（短冊テキスト＆短冊イメージ＆全面イメージ）の場合、短冊情報リストを取得します。
     *
     * @return 短冊情報リスト
     */
    public List<TokkiA4Entity> get短冊情報リスト() {
        List<TokkiA4Entity> 短冊情報リスト = new ArrayList<>();
        if (!テキスト全面イメージ.equals(特記パターン)) {
            for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
                TokkiA4Entity 短冊情報 = new TokkiA4Entity();
                短冊情報.set事項番号(get項目番号(kyotsuEntity.getKoroshoIfShikibetsuCode(),
                        entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban()));
                短冊情報.set項目名称(get項目名称(kyotsuEntity.getKoroshoIfShikibetsuCode(), entity.getNinteichosaTokkijikoNo()));
                if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                    短冊情報.set特記事項テキスト_イメージ(entity.getTokkiJiko());
                } else {
                    短冊情報.set特記事項テキスト_イメージ(getFilePath(kyotsuEntity.getImageSharedFileId(),
                            getFilePathByRemban(entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban())));
                }
                短冊情報リスト.add(短冊情報);
                表示行数 = 表示行数 + 1;
                if (表示行数 % (一ページ表示行数 * 現在ページ) == 0) {
                    has改ページ = true;
                    短冊情報リスト = 短冊情報リスト.subList(一ページ表示行数 * (現在ページ - 1), 表示行数 - 1);
                    return 短冊情報リスト;
                }
            }
            if (!短冊情報リスト.isEmpty() && 一ページ表示行数 * (現在ページ - 1) <= 短冊情報リスト.size()) {
                短冊情報リスト = 短冊情報リスト.subList(一ページ表示行数 * (現在ページ - 1), 短冊情報リスト.size() - 1);
            }
        }
        return 短冊情報リスト;
    }

    /**
     * 全面特記事項イメージを取得します。
     *
     * @return 全面特記事項イメージを取得します
     */
    public RString getTokkiImg() {
        RStringBuilder ファイル名 = new RStringBuilder();
        ファイル名.append("C140");
        ファイル名.append(現在ページ);
        if (kyotsuEntity.isJimukyoku()) {
            return getFilePath(kyotsuEntity.getImageSharedFileId(), ファイル名.append("_BAK.png").toRString());
        } else {
            return getFilePath(kyotsuEntity.getImageSharedFileId(), ファイル名.append("_.png").toRString());
        }
    }

    /**
     * 全面特記事項テキストを取得します。
     *
     * @return 全面特記事項テキストを取得します
     */
    public RString getTokkiText() {
        if (テキスト全面イメージ.equals(特記パターン)) {
            return getTextByテキスト全面イメージ();
        }
        return RString.EMPTY;
    }

    /**
     * 全面特記事項テキストを取得します。
     *
     * @return 全面特記事項テキストを取得します
     */
    public RString get特記事項テキスト_イメージ区分() {
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                return TokkijikoTextImageKubun.テキスト.getコード();
            }
        }
        return TokkijikoTextImageKubun.イメージ.getコード();
    }

    /**
     * 特記パターンを取得します。
     *
     * @return 特記パターン
     */
    public RString get特記パターン() {
        return 特記パターン;
    }

    /**
     * ページ表示行数を取得します。
     *
     * @return ページ表示行数
     */
    public int getページ表示行数() {
        return 表示行数;
    }

    /**
     * ページ表示行数を取得します。
     *
     * @return ページ表示行数
     */
    public boolean hasBreak() {
        return has改ページ;
    }

    private RString getTextByテキスト全面イメージ() {
        boolean isテキスト = false;
        RStringBuilder テキスト全面 = new RStringBuilder();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                isテキスト = true;
                RStringBuilder テキストBuilder = new RStringBuilder();
                テキストBuilder.append(get特記事項テキスト(
                        kyotsuEntity.getKoroshoIfShikibetsuCode(), entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban()));
                テキストBuilder.append(entity.getTokkiJiko());
                if ((int) (テキストBuilder.length() / 最大文字数) == 2) {
                    テキストBuilder.insert(最大文字数 * 2, System.lineSeparator());
                    表示行数 = 表示行数 + 1;
                }
                if ((int) (テキストBuilder.length() / 最大文字数) == 1) {
                    テキストBuilder.insert(最大文字数, System.lineSeparator());
                    表示行数 = 表示行数 + 1;
                }
                if ((!is2枚目以降 && ページ最大表示行数 <= 表示行数)
                        || (is2枚目以降 && ページ最大表示行数 * 現在ページ <= 表示行数)) {
                    has改ページ = true;
                    テキスト全面.append(テキストBuilder.toRString());
                    return テキスト全面.toRString();
                }
                if (is2枚目以降 && 表示行数 % (ページ最大表示行数 * (現在ページ - 1)) == 0) {
                    テキスト全面 = new RStringBuilder();
                } else {
                    テキストBuilder.append(System.lineSeparator());
                    表示行数 = 表示行数 + 1;
                }
                テキスト全面.append(テキストBuilder.toRString());
            }
        }
        if ((isテキスト && !is2枚目以降) || (isテキスト && (is2枚目以降 && ページ最大表示行数 * (現在ページ - 1) <= 表示行数
                && ページ最大表示行数 * 現在ページ - 1 <= 表示行数))) {
            return テキスト全面.toRString();
        }
        return RString.EMPTY;
    }

    private RString getFilePathByRemban(RString 特記事項番号, int 特記事項連番) {
        RStringBuilder イメージファイル = new RStringBuilder();
        RString ファイル名 = getファイル名By特記番号(特記事項番号);
        if (!RString.isNullOrEmpty(ファイル名)) {
            イメージファイル.append(ファイル名);
            for (int i = 0; i <= 最大連番; i++) {
                if (i == 特記事項連番) {
                    イメージファイル.append(new RString(特記事項連番).padZeroToLeft(2));
                    break;
                }
            }
            if (kyotsuEntity.isJimukyoku()) {
                イメージファイル.append("_BAK");
            }
            return イメージファイル.append(".png").toRString();
        }
        return RString.EMPTY;
    }

    private RString getFilePath(RDateTime sharedFileId, RString filename) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(filename),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), filename);
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

    private RString get項目名称(Code 厚労省IF識別コード, RString 調査特記事項番号) {
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
        return RString.EMPTY;
    }

    private RString get項目番号(Code 厚労省IF識別コード, RString 調査特記事項番号, int 連番) {
        RStringBuilder 項目番号 = new RStringBuilder();
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
            項目番号.append(ハイフン);
            項目番号.append(連番);
        }
        return 項目番号.toRString();
    }

    private RString getファイル名By特記番号(RString 特記番号) {
        if (特記番号.equals(new RString("101"))) {
            return new RString("C3001-");
        } else if (特記番号.equals(new RString("102"))) {
            return new RString("C3006-");
        } else if (特記番号.equals(new RString("103"))) {
            return new RString("C3010-");
        } else if (特記番号.equals(new RString("104"))) {
            return new RString("C3011-");
        } else if (特記番号.equals(new RString("105"))) {
            return new RString("C3012-");
        } else if (特記番号.equals(new RString("106"))) {
            return new RString("C3013-");
        } else if (特記番号.equals(new RString("107"))) {
            return new RString("C3014-");
        } else if (特記番号.equals(new RString("108"))) {
            return new RString("C3015-");
        } else if (特記番号.equals(new RString("109"))) {
            return new RString("C3016-");
        } else if (特記番号.equals(new RString("110"))) {
            return new RString("C3017-");
        } else if (特記番号.equals(new RString("111"))) {
            return new RString("C3018-");
        } else if (特記番号.equals(new RString("112"))) {
            return new RString("C3019-");
        } else if (特記番号.equals(new RString("113"))) {
            return new RString("C3020-");
        }
        return getファイル名By特記番号2(特記番号);
    }

    private RString getファイル名By特記番号2(RString 特記番号) {
        if (特記番号.equals(new RString("201"))) {
            return new RString("C3021-");
        } else if (特記番号.equals(new RString("202"))) {
            return new RString("C3022-");
        } else if (特記番号.equals(new RString("203"))) {
            return new RString("C3023-");
        } else if (特記番号.equals(new RString("204"))) {
            return new RString("C3024-");
        } else if (特記番号.equals(new RString("205"))) {
            return new RString("C3025-");
        } else if (特記番号.equals(new RString("206"))) {
            return new RString("C3026-");
        } else if (特記番号.equals(new RString("207"))) {
            return new RString("C3027-");
        } else if (特記番号.equals(new RString("208"))) {
            return new RString("C3028-");
        } else if (特記番号.equals(new RString("209"))) {
            return new RString("C3029-");
        } else if (特記番号.equals(new RString("210"))) {
            return new RString("C3030-");
        } else if (特記番号.equals(new RString("211"))) {
            return new RString("C3031-");
        } else if (特記番号.equals(new RString("212"))) {
            return new RString("C3032-");
        }
        return getファイル名By特記番号3(特記番号);
    }

    private RString getファイル名By特記番号3(RString 特記番号) {
        if (特記番号.equals(new RString("301"))) {
            return new RString("C3033-");
        } else if (特記番号.equals(new RString("302"))) {
            return new RString("C3034-");
        } else if (特記番号.equals(new RString("303"))) {
            return new RString("C3035-");
        } else if (特記番号.equals(new RString("304"))) {
            return new RString("C3036-");
        } else if (特記番号.equals(new RString("305"))) {
            return new RString("C3037-");
        } else if (特記番号.equals(new RString("306"))) {
            return new RString("C3038-");
        } else if (特記番号.equals(new RString("307"))) {
            return new RString("C3039-");
        } else if (特記番号.equals(new RString("308"))) {
            return new RString("C3040-");
        } else if (特記番号.equals(new RString("309"))) {
            return new RString("C3041-");
        }
        return getファイル名By特記番号4(特記番号);
    }

    private RString getファイル名By特記番号4(RString 特記番号) {
        if (特記番号.equals(new RString("401"))) {
            return new RString("C3042-");
        } else if (特記番号.equals(new RString("402"))) {
            return new RString("C3043-");
        } else if (特記番号.equals(new RString("403"))) {
            return new RString("C3044-");
        } else if (特記番号.equals(new RString("404"))) {
            return new RString("C3045-");
        } else if (特記番号.equals(new RString("405"))) {
            return new RString("C3046-");
        } else if (特記番号.equals(new RString("406"))) {
            return new RString("C3047-");
        } else if (特記番号.equals(new RString("407"))) {
            return new RString("C3048-");
        } else if (特記番号.equals(new RString("408"))) {
            return new RString("C3049-");
        } else if (特記番号.equals(new RString("409"))) {
            return new RString("C3050-");
        } else if (特記番号.equals(new RString("410"))) {
            return new RString("C3051-");
        } else if (特記番号.equals(new RString("411"))) {
            return new RString("C3052-");
        } else if (特記番号.equals(new RString("412"))) {
            return new RString("C3053-");
        } else if (特記番号.equals(new RString("413"))) {
            return new RString("C3054-");
        } else if (特記番号.equals(new RString("414"))) {
            return new RString("C3055-");
        } else if (特記番号.equals(new RString("415"))) {
            return new RString("C3056-");
        }
        return getファイル名By特記番号5(特記番号);
    }

    private RString getファイル名By特記番号5(RString 特記番号) {
        if (特記番号.equals(new RString("501"))) {
            return new RString("C3057-");
        } else if (特記番号.equals(new RString("502"))) {
            return new RString("C3058-");
        } else if (特記番号.equals(new RString("503"))) {
            return new RString("C3059-");
        } else if (特記番号.equals(new RString("504"))) {
            return new RString("C3060-");
        } else if (特記番号.equals(new RString("505"))) {
            return new RString("C3061-");
        } else if (特記番号.equals(new RString("506"))) {
            return new RString("C3062-");
        }
        return getファイル名By特記番号6(特記番号);
    }

    private RString getファイル名By特記番号6(RString 特記番号) {
        if (特記番号.equals(new RString("601"))) {
            return new RString("C3063-");
        } else if (特記番号.equals(new RString("602"))) {
            return new RString("C3064-");
        } else if (特記番号.equals(new RString("603"))) {
            return new RString("C3065-");
        } else if (特記番号.equals(new RString("604"))) {
            return new RString("C3066-");
        } else if (特記番号.equals(new RString("605"))) {
            return new RString("C3067-");
        } else if (特記番号.equals(new RString("606"))) {
            return new RString("C3068-");
        } else if (特記番号.equals(new RString("607"))) {
            return new RString("C3069-");
        } else if (特記番号.equals(new RString("608"))) {
            return new RString("C3070-");
        } else if (特記番号.equals(new RString("609"))) {
            return new RString("C3071-");
        } else if (特記番号.equals(new RString("610"))) {
            return new RString("C3072-");
        } else if (特記番号.equals(new RString("611"))) {
            return new RString("C3073-");
        } else if (特記番号.equals(new RString("612"))) {
            return new RString("C3074-");
        } else if (特記番号.equals(new RString("701"))) {
            return new RString("C3075-");
        } else if (特記番号.equals(new RString("702"))) {
            return new RString("C3076-");
        }
        return RString.EMPTY;
    }
}
