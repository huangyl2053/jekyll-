/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkiyichirannyuroku.ChosaKoumokuAndTokkiBangoMappingEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目と認定調査特記事項番号のマッピングクラスです。
 */
public class ChosaKoumokuAndTokkiBangoMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    private final ChosaKoumokuAndTokkiBangoMappingEntity chosaKoumokuAndTokkiBangoMappingEntity;

    /**
     * コンストラクタです。<br/>
     *
     */
    public ChosaKoumokuAndTokkiBangoMapping() {
        this.chosaKoumokuAndTokkiBangoMappingEntity = new ChosaKoumokuAndTokkiBangoMappingEntity(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 画面表示用特記事項項番 画面表示用特記事項項番
     * @param 認定調査項目 認定調査項目
     */
    public ChosaKoumokuAndTokkiBangoMapping(
            RString 認定調査特記事項番号,
            RString 画面表示用特記事項項番,
            RString 認定調査項目) {
        this.chosaKoumokuAndTokkiBangoMappingEntity = new ChosaKoumokuAndTokkiBangoMappingEntity(
                認定調査特記事項番号,
                画面表示用特記事項項番,
                認定調査項目);
    }

    /**
     * 認定調査項目と認定調査特記事項番号のエンティティ返します。
     *
     * @return 認定調査項目と認定調査特記事項番号のエンティティ
     */
    public ChosaKoumokuAndTokkiBangoMappingEntity getChosaKoumokuAndTokkiBangoMappingEntityy() {
        return chosaKoumokuAndTokkiBangoMappingEntity;
    }

    /**
     * 認定調査特記事項番号を返します。
     *
     * @return 認定調査特記事項番号
     */
    public RString get認定調査特記事項番号() {
        return chosaKoumokuAndTokkiBangoMappingEntity.get認定調査特記事項番号();
    }

    /**
     * 画面表示用特記事項項番を返します。
     *
     * @return 画面表示用特記事項項番
     */
    public RString get画面表示用特記事項項番() {
        return chosaKoumokuAndTokkiBangoMappingEntity.get画面表示用特記事項項番();
    }

    /**
     * 認定調査項目を返します。
     *
     * @return 認定調査項目
     */
    public RString get認定調査項目() {
        return chosaKoumokuAndTokkiBangoMappingEntity.get認定調査項目();
    }
}
