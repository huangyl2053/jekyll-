/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ImjJohoEntity;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.io.Directory;

/**
 * 事務局用概況特記一覧表情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuGaikyouTokkiBusiness {

    private final IinTokkiJikouItiziHanteiProcessParameter paramter;
    private final GaikyoTokkiEntity entity;
    private final ImjJohoEntity entityImg;
    private final List<GaikyoTokkiEntity> 概況特記一覧表情報;
    private final List<ImjJohoEntity> 概況特記イメージ情報;
    private final int no;
    private final RString path;
    private static final int 件数 = 10;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_0 = 0;
    private static final RString ファイルID_C0007 = new RString("C0007.png");
    private static final RString ファイルID_C0007_BAK = new RString("C0007_BAK.png");
    private static final RString SEPARATOR = new RString("/");

    /**
     * コンストラクタです。
     *
     * @param entity GaikyoTokkiEntity
     * @param 概況特記一覧表情報 List<GaikyoTokkiEntity>
     * @param 概況特記イメージ情報 List<ImjJohoEntity>
     * @param paramter IinTokkiJikouItiziHanteiProcessParameter
     * @param no no
     * @param entityImg entityImg
     * @param path path
     */
    public JimuGaikyouTokkiBusiness(
            GaikyoTokkiEntity entity,
            List<GaikyoTokkiEntity> 概況特記一覧表情報,
            List<ImjJohoEntity> 概況特記イメージ情報,
            IinTokkiJikouItiziHanteiProcessParameter paramter,
            int no, ImjJohoEntity entityImg, RString path) {
        this.entity = entity;
        this.概況特記一覧表情報 = 概況特記一覧表情報;
        this.概況特記イメージ情報 = 概況特記イメージ情報;
        this.paramter = paramter;
        this.no = no;
        this.entityImg = entityImg;
        this.path = path;
    }

    /**
     * 審査会番号を取得します。
     *
     * @return 審査会番号
     */
    public RString get審査会番号() {
        return paramter.getShinsakaiKaisaiNo();
    }

    /**
     * Noを取得します。
     *
     * @return No
     */
    public RString getNo() {
        if (entity != null) {
            return new RString(entity.getDbt5502_shinsakaiOrder());
        }
        return new RString(entityImg.getDbt5502_shinsakaiOrder());
    }

    /**
     * 概況特記テキスト１を取得します。
     *
     * @return 概況特記テキスト１
     */
    public RString get概況特記テキスト１() {
        return get概況特記テキスト(INT_0);
    }

    /**
     * 概況特記テキスト２を取得します。
     *
     * @return 概況特記テキスト２
     */
    public RString get概況特記テキスト２() {
        return get概況特記テキスト(INT_1);
    }

    /**
     * 概況特記テキスト３を取得します。
     *
     * @return 概況特記テキスト３
     */
    public RString get概況特記テキスト３() {
        return get概況特記テキスト(INT_2);
    }

    /**
     * 概況特記テキスト４を取得します。
     *
     * @return 概況特記テキスト４
     */
    public RString get概況特記テキスト４() {
        return get概況特記テキスト(INT_3);
    }

    /**
     * 概況特記テキスト５を取得します。
     *
     * @return 概況特記テキスト５
     */
    public RString get概況特記テキスト５() {
        return get概況特記テキスト(INT_4);
    }

    /**
     * 概況特記テキスト６を取得します。
     *
     * @return 概況特記テキスト６
     */
    public RString get概況特記テキスト６() {
        return get概況特記テキスト(INT_5);
    }

    /**
     * 概況特記テキスト７を取得します。
     *
     * @return 概況特記テキスト７
     */
    public RString get概況特記テキスト７() {
        return get概況特記テキスト(INT_6);
    }

    /**
     * 概況特記テキスト８を取得します。
     *
     * @return 概況特記テキスト８
     */
    public RString get概況特記テキスト８() {
        return get概況特記テキスト(INT_7);
    }

    /**
     * 概況特記テキスト９を取得します。
     *
     * @return 概況特記テキスト９
     */
    public RString get概況特記テキスト９() {
        return get概況特記テキスト(INT_8);
    }

    /**
     * 概況特記テキスト１０を取得します。
     *
     * @return 概況特記テキスト１０
     */
    public RString get概況特記テキスト１０() {
        return get概況特記テキスト(INT_9);
    }

    /**
     * 概況特記イメージ１を取得します。
     *
     * @return 概況特記イメージ１
     */
    public RString get概況特記イメージ１() {
        return get概況特記イメージ(INT_0);
    }

    /**
     * 概況特記イメージ２を取得します。
     *
     * @return 概況特記イメージ２
     */
    public RString get概況特記イメージ２() {
        return get概況特記イメージ(INT_1);
    }

    /**
     * 概況特記イメージ３を取得します。
     *
     * @return 概況特記イメージ３
     */
    public RString get概況特記イメージ３() {
        return get概況特記イメージ(INT_2);
    }

    /**
     * 概況特記イメージ４を取得します。
     *
     * @return 概況特記イメージ４
     */
    public RString get概況特記イメージ４() {
        return get概況特記イメージ(INT_3);
    }

    /**
     * 概況特記イメージ５を取得します。
     *
     * @return 概況特記イメージ５
     */
    public RString get概況特記イメージ５() {
        return get概況特記イメージ(INT_4);
    }

    /**
     * 概況特記イメージ６を取得します。
     *
     * @return 概況特記イメージ６
     */
    public RString get概況特記イメージ６() {
        return get概況特記イメージ(INT_5);
    }

    /**
     * 概況特記イメージ７を取得します。
     *
     * @return 概況特記イメージ７
     */
    public RString get概況特記イメージ７() {
        return get概況特記イメージ(INT_6);
    }

    /**
     * 概況特記イメージ８を取得します。
     *
     * @return 概況特記イメージ８
     */
    public RString get概況特記イメージ８() {
        return get概況特記イメージ(INT_7);
    }

    /**
     * 概況特記イメージ９を取得します。
     *
     * @return 概況特記イメージ９
     */
    public RString get概況特記イメージ９() {
        return get概況特記イメージ(INT_8);
    }

    /**
     * 概況特記イメージ１０を取得します。
     *
     * @return 概況特記イメージ１０
     */
    public RString get概況特記イメージ１０() {
        return get概況特記イメージ(INT_9);
    }

    private RString get概況特記テキスト(int index) {

        if (概況特記一覧表情報 != null && !概況特記一覧表情報.isEmpty()) {
            if (件数 < 概況特記一覧表情報.size() && (index + (no / 件数) * 件数) < 概況特記一覧表情報.size()) {
                return get項目(index + (no / 件数) * 件数);
            }
            if (概況特記一覧表情報.size() <= 件数 && index < 概況特記一覧表情報.size()) {
                return get項目(index);
            }
        }
        return RString.EMPTY;
    }

    private RString get項目(int index) {
        RStringBuilder builder = new RStringBuilder();
        GaikyoTokkiEntity 概況特記一覧 = 概況特記一覧表情報.get(index);
        return builder.append(概況特記一覧.getDbt5206_shuso())
                .append(概況特記一覧.getDbt5206_kazokuJokyo())
                .append(概況特記一覧.getDbt5206_kyojuKankyo())
                .append(概況特記一覧.getDbt5206_kikaiKiki())
                .toRString();
    }

    private RString get概況特記イメージ(int index) {
        if (概況特記イメージ情報 != null && !概況特記イメージ情報.isEmpty()) {
            if (件数 < 概況特記イメージ情報.size() && (index + (no / 件数) * 件数) < 概況特記イメージ情報.size()) {
                return getイメージ(index + (no / 件数) * 件数);
            }
            if (概況特記イメージ情報.size() < 件数 && index < 概況特記イメージ情報.size()) {
                return getイメージ(index);
            }
        }
        return RString.EMPTY;
    }

    private RString getイメージ(int index) {
        if (entityImg.isJimukyoku()) {
            return getFilePath(path, ファイルID_C0007_BAK);
        } else {
            return getFilePath(path, ファイルID_C0007);
        }
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名);
        }
        return RString.EMPTY;
    }
}
