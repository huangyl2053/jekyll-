/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.kihonchosainput;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.kihonchosainput.KihonChosaInputEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査基本情報を管理するビジネスです。
 */
public class KihonChosaInput implements Serializable {

    private final KihonChosaInputEntity 認定調査基本情報;

    /**
     * コンストラクタです。<br/>
     *
     * @param 認定調査基本情報 認定調査基本情報
     * @link KihonChosaInputEntity}より{@link KihonChosaInput}を生成します。
     *
     * @param KihonChosaInput {@link KihonChosaInput}
     */
    public KihonChosaInput(KihonChosaInputEntity 認定調査基本情報) {
        this.認定調査基本情報 = requireNonNull(認定調査基本情報,
                UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査基本情報のエンティティ"));
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 認知症高齢者自立度 認知症高齢者自立度
     * @param 障害高齢者自立度 障害高齢者自立度
     * @param 調査連番 調査連番
     * @param 調査項目 調査項目
     * @param 前回認知症高齢者自立度 前回認知症高齢者自立度
     * @param 前回障害高齢者自立度 前回障害高齢者自立度
     * @param 前回調査連番 前回調査連番
     * @param 前回調査項目 前回調査項目
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 認定調査特記事項連番 認定調査特記事項連番
     * @param 原本マスク区分 原本マスク区分
     * @param 特記事項 特記事項
     * @link KihonChosaInputEntity}より{@link KihonChosaInput}を生成します。
     *
     * @param KihonChosaInput {@link KihonChosaInput}
     */
    public KihonChosaInput(Code 認知症高齢者自立度,
            Code 障害高齢者自立度,
            int 調査連番,
            RString 調査項目,
            Code 前回認知症高齢者自立度,
            Code 前回障害高齢者自立度,
            int 前回調査連番,
            RString 前回調査項目,
            RString 認定調査特記事項番号,
            int 認定調査特記事項連番,
            Code 原本マスク区分,
            RString 特記事項
    ) {
        this.認定調査基本情報 = new KihonChosaInputEntity();
        認定調査基本情報.set前回認知症高齢者自立度(前回認知症高齢者自立度);
        認定調査基本情報.set前回調査連番(前回調査連番);
        認定調査基本情報.set前回調査項目(前回調査項目);
        認定調査基本情報.set前回障害高齢者自立度(前回障害高齢者自立度);
        認定調査基本情報.set原本マスク区分(原本マスク区分);
        認定調査基本情報.set特記事項(特記事項);
        認定調査基本情報.set認定調査特記事項番号(認定調査特記事項番号);
        認定調査基本情報.set認定調査特記事項連番(認定調査特記事項連番);
        認定調査基本情報.set認知症高齢者自立度(認知症高齢者自立度);
        認定調査基本情報.set調査連番(調査連番);
        認定調査基本情報.set調査項目(調査項目);
        認定調査基本情報.set障害高齢者自立度(障害高齢者自立度);
    }

    /**
     * 前回認知症高齢者自立度を返します。
     *
     * @return 前回認知症高齢者自立度
     */
    public Code get前回認知症高齢者自立度() {
        return 認定調査基本情報.get前回認知症高齢者自立度();
    }

    /**
     * 前回障害高齢者自立度を返します。
     *
     * @return 前回障害高齢者自立度
     */
    public Code get前回障害高齢者自立度() {
        return 認定調査基本情報.get前回障害高齢者自立度();
    }

    /**
     * 認知症高齢者自立度を返します。
     *
     * @return 認知症高齢者自立度
     */
    public Code get認知症高齢者自立度() {
        return 認定調査基本情報.get認知症高齢者自立度();
    }

    /**
     * 障害高齢者自立度を返します。
     *
     * @return 障害高齢者自立度
     */
    public Code get障害高齢者自立度() {
        return 認定調査基本情報.get障害高齢者自立度();
    }

    /**
     * 原本マスク区分を返します。
     *
     * @return 原本マスク区分
     */
    public Code get原本マスク区分() {
        return 認定調査基本情報.get原本マスク区分();
    }

    /**
     * 調査連番を返します。
     *
     * @return 調査連番
     */
    public int get調査連番() {
        return 認定調査基本情報.get調査連番();
    }

    /**
     * 前回調査連番を返します。
     *
     * @return 前回調査連番
     */
    public int get前回調査連番() {
        return 認定調査基本情報.get前回調査連番();
    }

    /**
     * 認定調査特記事項連番を返します。
     *
     * @return 認定調査特記事項連番
     */
    public int get認定調査特記事項連番() {
        return 認定調査基本情報.get認定調査特記事項連番();
    }

    /**
     * 調査項目を返します。
     *
     * @return 調査項目
     */
    public RString get調査項目() {
        return 認定調査基本情報.get調査項目();
    }

    /**
     * 前回調査項目を返します。
     *
     * @return 前回調査項目
     */
    public RString get前回調査項目() {
        return 認定調査基本情報.get前回調査項目();
    }

    /**
     * 認定調査特記事項番号を返します。
     *
     * @return 認定調査特記事項番号
     */
    public RString get認定調査特記事項番号() {
        return 認定調査基本情報.get認定調査特記事項番号();
    }

    /**
     * 特記事項を返します。
     *
     * @return 特記事項
     */
    public RString get特記事項() {
        return 認定調査基本情報.get特記事項();
    }

}
