/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tekiyojogaishadaichojoho;

import java.util.Objects;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaishadaichojoho.TekiyoJogaishaDaichoJohoRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 適用除外者台帳情報を管理するクラスです。
 */
public class TekiyoJogaishaDaichoJoho {

    private final TekiyoJogaishaDaichoJohoRelateEntity entity;

    /**
     * DBより取得した{@link TekiyoJogaishaDaichoJohoRelateEntity}より{@link TekiyoJogaishaDaichoJoho}を生成します。
     *
     * @param entity 適用除外者台帳情報RelateEntity
     */
    public TekiyoJogaishaDaichoJoho(TekiyoJogaishaDaichoJohoRelateEntity entity) {
        this.entity = Objects.requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合適用除外者台帳情報検索結果"));
    }

    /**
     * 印刷日時を取得します。
     *
     * @return 印刷日時
     */
    public RString get印刷日時() {
        return entity.get印刷日時();
    }

    /**
     * ページ目を取得します。
     *
     * @return ページ目
     */
    public int getページ目() {
        return entity.getページ目();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return entity.get市町村コード();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.get市町村名称();
    }

    /**
     * 状態を取得します。
     *
     * @return 状態
     */
    public RString get状態() {
        return entity.get状態();
    }

    /**
     * 電話番号タイトルを取得します。
     *
     * @return 電話番号タイトル
     */
    public RString get電話番号タイトル() {
        return entity.get電話番号タイトル();
    }

    /**
     * 電話番号１を取得します。
     *
     * @return 電話番号１
     */
    public RString get電話番号１() {
        return entity.get電話番号１();
    }

    /**
     * 電話番号２を取得します。
     *
     * @return 電話番号２
     */
    public RString get電話番号２() {
        return entity.get電話番号２();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 世帯コードを取得します。
     *
     * @return 世帯コード
     */
    public RString get世帯コード() {
        return entity.get世帯コード();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.get識別コード();
    }

    /**
     * 氏名カナを取得します。
     *
     * @return 氏名カナ
     */
    public RString get氏名カナ() {
        return entity.get氏名カナ();
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return entity.get氏名();
    }

    /**
     * 地区コード1を取得します。
     *
     * @return 地区コード1
     */
    public RString get地区コード1() {
        return entity.get地区コード1();
    }

    /**
     * 地区タイトル1を取得します。
     *
     * @return 地区タイトル1
     */
    public RString get地区タイトル1() {
        return entity.get地区タイトル1();
    }

    /**
     * 地区コード2を取得します。
     *
     * @return 地区コード2
     */
    public RString get地区コード2() {
        return entity.get地区コード2();
    }

    /**
     * 地区タイトル2を取得します。
     *
     * @return 地区タイトル2
     */
    public RString get地区タイトル2() {
        return entity.get地区タイトル2();
    }

    /**
     * 地区コード3を取得します。
     *
     * @return 地区コード3
     */
    public RString get地区コード3() {
        return entity.get地区コード3();
    }

    /**
     * 地区タイトル3を取得します。
     *
     * @return 地区タイトル3
     */
    public RString get地区タイトル3() {
        return entity.get地区タイトル3();
    }

    /**
     * 住所1を取得します。
     *
     * @return 住所1
     */
    public RString get住所1() {
        return entity.get住所1();
    }

    /**
     * 住所タイトル1を取得します。
     *
     * @return 住所タイトル1
     */
    public RString get住所タイトル1() {
        return entity.get住所タイトル1();
    }

    /**
     * 住所コードを取得します。
     *
     * @return 住所コード
     */
    public RString get住所コード() {
        return entity.get住所コード();
    }

    /**
     * 行政区タイトルを取得します。
     *
     * @return 行政区タイトル
     */
    public RString get行政区タイトル() {
        return entity.get行政区タイトル();
    }

    /**
     * 行政区コードを取得します。
     *
     * @return 行政区コード
     */
    public RString get行政区コード() {
        return entity.get行政区コード();
    }

    /**
     * 住所2を取得します。
     *
     * @return 住所2
     */
    public RString get住所2() {
        return entity.get住所2();
    }

    /**
     * 住所タイトル2を取得します。
     *
     * @return 住所タイトル2
     */
    public RString get住所タイトル2() {
        return entity.get住所タイトル2();
    }

    /**
     * 住所コード2を取得します。
     *
     * @return 住所コード2
     */
    public RString get住所コード2() {
        return entity.get住所コード2();
    }

    /**
     * NOを取得します。
     *
     * @return NO
     */
    public int getNO() {
        return entity.getNO();
    }

    /**
     * 適用年月日を取得します。
     *
     * @return 適用年月日
     */
    public FlexibleDate get適用年月日() {
        return entity.get適用年月日();
    }

    /**
     * 適用届出年月日を取得します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate get適用届出年月日() {
        return entity.get適用届出年月日();
    }

    /**
     * 適用除外適用事由コードを取得します。
     *
     * @return 適用除外適用事由コード
     */
    public RString get適用除外適用事由コード() {
        return entity.get適用除外適用事由コード();
    }

    /**
     * 適用除外適用事由名称を取得します。
     *
     * @return 適用除外適用事由名称
     */
    public RString get適用除外適用事由名称() {
        return entity.get適用除外適用事由名称();
    }

    /**
     * 解除年月日を取得します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return entity.get解除年月日();
    }

    /**
     * 解除届出年月日を取得します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate get解除届出年月日() {
        return entity.get解除届出年月日();
    }

    /**
     * 適用除外解除事由コードを取得します。
     *
     * @return 適用除外解除事由コード
     */
    public RString get適用除外解除事由コード() {
        return entity.get適用除外解除事由コード();
    }

    /**
     * 適用除外解除事由名称を取得します。
     *
     * @return 適用除外解除事由名称
     */
    public RString get適用除外解除事由名称() {
        return entity.get適用除外解除事由名称();
    }

    /**
     * 入所年月日を取得します。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return entity.get入所年月日();
    }

    /**
     * 退所年月日を取得します。
     *
     * @return 退所年月日
     */
    public FlexibleDate get退所年月日() {
        return entity.get退所年月日();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.get事業者名称();
    }

    /**
     * 事業者住所を取得します。
     *
     * @return 事業者住所
     */
    public RString get事業者住所() {
        return entity.get事業者住所();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.get電話番号();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.get郵便番号();
    }
}
