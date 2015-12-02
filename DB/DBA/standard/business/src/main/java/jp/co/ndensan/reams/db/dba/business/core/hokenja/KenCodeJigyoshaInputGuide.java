/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hokenja;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoDataKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJushoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報です。
 */
public class KenCodeJigyoshaInputGuide implements Serializable {

    private final UrT0101ZenkokuJushoEntity entity;
    private final KenCodeJigyoshaInputGuideIdentifier id;

    /**
     * <p>
     * コンストラクタです。
     * </p>
     * <p>
     * 全国住所情報の新規作成時に使用します。
     * </p>
     *
     * @param dataKubun データ区分
     * @param todofukenJushoCode 都道府県住所コード
     * @param shichosonJushoCode 市町村住所コード
     * @param ooazaJushoCode 大字住所コード
     * @param azaChoJushoCode 字丁住所コード
     */
    public KenCodeJigyoshaInputGuide(
            ZenkokuJushoDataKubun dataKubun,
            RString todofukenJushoCode,
            RString shichosonJushoCode,
            RString ooazaJushoCode,
            RString azaChoJushoCode) {
        requireNonNull(dataKubun, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        requireNonNull(todofukenJushoCode, UrSystemErrorMessages.値がnull.getReplacedMessage("都道府県住所コード"));
        requireNonNull(shichosonJushoCode, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村住所コード"));
        requireNonNull(ooazaJushoCode, UrSystemErrorMessages.値がnull.getReplacedMessage("大字住所コード"));
        requireNonNull(azaChoJushoCode, UrSystemErrorMessages.値がnull.getReplacedMessage("字丁住所コード"));
        this.entity = new UrT0101ZenkokuJushoEntity();
        this.entity.setDataKubun(dataKubun);
        this.entity.setTodofukenJushoCode(todofukenJushoCode);
        this.entity.setShichosonJushoCode(shichosonJushoCode);
        this.entity.setOoazaJushoCode(ooazaJushoCode);
        this.entity.setAzaChoJushoCode(azaChoJushoCode);
        this.id = new KenCodeJigyoshaInputGuideIdentifier(dataKubun, todofukenJushoCode, shichosonJushoCode, ooazaJushoCode, azaChoJushoCode);
    }

    /**
     * <p>
     * コンストラクタです。
     * </p>
     * <p>
     * DBより取得した{@link UrT0507HokenjaEntity}より{@link Hokensha}を生成します。
     * </p>
     *
     * @param entity DBより取得した{@link UrT0507HokenjaEntity}
     */
    public KenCodeJigyoshaInputGuide(UrT0101ZenkokuJushoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("全国住所情報"));
        this.id = new KenCodeJigyoshaInputGuideIdentifier(
                entity.getDataKubun(),
                entity.getTodofukenJushoCode(),
                entity.getShichosonJushoCode(),
                entity.getOoazaJushoCode(),
                entity.getAzaChoJushoCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     *
     * @param entity {@link UrT0507HokenjaEntity}
     * @param id {@link HokenshaIdentifier}
     */
    KenCodeJigyoshaInputGuide(
            UrT0101ZenkokuJushoEntity entity,
            KenCodeJigyoshaInputGuideIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 都道府県住所コードを返します。
     *
     * @return 都道府県住所コード
     */
    public RString get都道府県住所コード() {
        return entity.getTodofukenJushoCode();
    }

    /**
     * 都道府県名を返します。
     *
     * @return 都道府県名
     */
    public RString get都道府県名() {
        return entity.getTodofukenName();
    }
}
