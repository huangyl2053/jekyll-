/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kihonchosainput.KihonChosaInputEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査基本情報を管理するビジネスです。
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class KihonChosaInput implements Serializable {

    private final KihonChosaInputEntity 認定調査基本情報;

    /**
     * コンストラクタです。<br/>
     *
     * @param 認定調査基本情報 認定調査基本情報
     * @link KihonChosaInputEntity}より{@link KihonChosaInput}を生成します。
     */
    public KihonChosaInput(KihonChosaInputEntity 認定調査基本情報) {
        this.認定調査基本情報 = requireNonNull(認定調査基本情報,
                UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査基本情報のエンティティ"));
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認知症高齢者自立度 認知症高齢者自立度
     * @param 障害高齢者自立度 障害高齢者自立度
     * @param 調査連番 調査連番
     * @param 調査項目 調査項目
     * @param 前回認知症高齢者自立度 前回認知症高齢者自立度
     * @param 前回障害高齢者自立度 前回障害高齢者自立度
     * @param 前回調査連番 前回調査連番
     * @param 前回調査項目 前回調査項目
     * @link KihonChosaInputEntity}より{@link KihonChosaInput}を生成します。
     */
    public KihonChosaInput(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            Code 認知症高齢者自立度,
            Code 障害高齢者自立度,
            int 調査連番,
            RString 調査項目,
            Code 前回認知症高齢者自立度,
            Code 前回障害高齢者自立度,
            int 前回調査連番,
            RString 前回調査項目
    ) {
        this.認定調査基本情報 = new KihonChosaInputEntity();
        認定調査基本情報.set申請書管理番号(申請書管理番号);
        認定調査基本情報.set認定調査依頼履歴番号(認定調査依頼履歴番号);
        認定調査基本情報.set前回認知症高齢者自立度(前回認知症高齢者自立度);
        認定調査基本情報.set前回調査連番(前回調査連番);
        認定調査基本情報.set前回調査項目(前回調査項目);
        認定調査基本情報.set前回障害高齢者自立度(前回障害高齢者自立度);
        認定調査基本情報.set認知症高齢者自立度(認知症高齢者自立度);
        認定調査基本情報.set調査連番(調査連番);
        認定調査基本情報.set調査項目(調査項目);
        認定調査基本情報.set障害高齢者自立度(障害高齢者自立度);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認知症高齢者自立度 認知症高齢者自立度
     * @param 障害高齢者自立度 障害高齢者自立度
     * @param 調査連番 調査連番
     * @param 調査項目 調査項目
     * @param 前回認知症高齢者自立度 前回認知症高齢者自立度
     * @param 前回障害高齢者自立度 前回障害高齢者自立度
     * @param 前回調査連番 前回調査連番
     * @param 前回調査項目 前回調査項目
     * @param 特記事項有無 特記事項有無
     * @link KihonChosaInputEntity}より{@link KihonChosaInput}を生成します。
     */
    public KihonChosaInput(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            Code 認知症高齢者自立度,
            Code 障害高齢者自立度,
            int 調査連番,
            RString 調査項目,
            Code 前回認知症高齢者自立度,
            Code 前回障害高齢者自立度,
            int 前回調査連番,
            RString 前回調査項目,
            boolean 特記事項有無
    ) {
        this.認定調査基本情報 = new KihonChosaInputEntity();
        認定調査基本情報.set申請書管理番号(申請書管理番号);
        認定調査基本情報.set認定調査依頼履歴番号(認定調査依頼履歴番号);
        認定調査基本情報.set前回認知症高齢者自立度(前回認知症高齢者自立度);
        認定調査基本情報.set前回調査連番(前回調査連番);
        認定調査基本情報.set前回調査項目(前回調査項目);
        認定調査基本情報.set前回障害高齢者自立度(前回障害高齢者自立度);
        認定調査基本情報.set認知症高齢者自立度(認知症高齢者自立度);
        認定調査基本情報.set調査連番(調査連番);
        認定調査基本情報.set調査項目(調査項目);
        認定調査基本情報.set障害高齢者自立度(障害高齢者自立度);
        認定調査基本情報.set特記事項有無(特記事項有無);
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return 認定調査基本情報.get認定調査依頼履歴番号();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 認定調査基本情報.get申請書管理番号();
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
     * 特記事項有無を返します。
     *
     * @return 特記事項
     */
    public boolean is特記事項有無() {
        return 認定調査基本情報.is特記事項有無();
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KihonChosaInputBuilder createBuilderForEdit() {
        return new KihonChosaInputBuilder(認定調査基本情報);
    }

}
