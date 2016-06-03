/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureidaicho;

import jp.co.ndensan.reams.db.dba.entity.db.relate.otheraddressledger.OtherAddressLedgerEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 他市町村住所地特例者台帳のエンティティのbusinessクラスです。
 *
 * @reamsid_L DBA-0402-020 wangjie2
 */
public class OtherAddressLedgerBusiness {

    private final OtherAddressLedgerEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity OtherAddressLedgerEntity
     */
    public OtherAddressLedgerBusiness(OtherAddressLedgerEntity entity) {
        this.entity = entity;
    }

    /**
     * 印刷日時を返します。
     *
     * @return 印刷日時
     */
    public RString get印刷日時() {
        return entity.get印刷日時();
    }

    /**
     * ページ目を返します。
     *
     * @return ページ目
     */
    public int getページ目() {
        return entity.getページ目();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.get市町村コード();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.get市町村名称();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 性別(を返します。
     *
     * @return 性別(
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return entity.get世帯コード();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.get識別コード();
    }

    /**
     * 氏名カナを返します。
     *
     * @return 氏名カナ
     */
    public AtenaKanaMeisho get氏名カナ() {
        return entity.get氏名カナ();
    }

    /**
     * 地区タイトル1を返します。
     *
     * @return 地区タイトル1
     */
    public RString get地区タイトル1() {
        return entity.get地区タイトル1();
    }

    /**
     * 地区コード1を返します。
     *
     * @return 地区コード1
     */
    public ChikuCode get地区コード1() {
        return entity.get地区コード1();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return entity.get氏名();
    }

    /**
     * 状態を返します。
     *
     * @return 状態
     */
    public RString get状態() {
        return entity.get状態();
    }

    /**
     * 電話番号タイトルを返します。
     *
     * @return 電話番号タイトル
     */
    public RString get電話番号タイトル() {
        return entity.get電話番号タイトル();
    }

    /**
     * 地区タイトル2を返します。
     *
     * @return 地区タイトル2
     */
    public RString get地区タイトル2() {
        return entity.get地区タイトル2();
    }

    /**
     * 地区コード2を返します。
     *
     * @return 地区コード2
     */
    public ChikuCode get地区コード2() {
        return entity.get地区コード2();
    }

    /**
     * 住所1を返します。
     *
     * @return 住所1
     */
    public RString get住所1() {
        return entity.get住所1();
    }

    /**
     * 電話番号１を返します。
     *
     * @return 電話番号１
     */
    public RString get電話番号１() {
        return entity.get電話番号１();
    }

    /**
     * 住所タイトル1を返します。
     *
     * @return 住所タイトル1
     */
    public RString get住所タイトル1() {
        return entity.get住所タイトル1();
    }

    /**
     * 電話番号２を返します。
     *
     * @return 電話番号２
     */
    public RString get電話番号２() {
        return entity.get電話番号２();
    }

    /**
     * 地区タイトル3を返します。
     *
     * @return 地区タイトル3
     */
    public RString get地区タイトル3() {
        return entity.get地区タイトル3();
    }

    /**
     * 地区コード3を返します。
     *
     * @return 地区コード3
     */
    public ChikuCode get地区コード3() {
        return entity.get地区コード3();
    }

    /**
     * 行政区タイトルを返します。
     *
     * @return 行政区タイトル
     */
    public RString get行政区タイトル() {
        return entity.get行政区タイトル();
    }

    /**
     * 住所コードを返します。
     *
     * @return 住所コード
     */
    public RString get住所コード() {
        return entity.get住所コード();
    }

    /**
     * 行政区コードを返します。
     *
     * @return 行政区コード
     */
    public GyoseikuCode get行政区コード() {
        return entity.get行政区コード();
    }

    /**
     * 前住所コードを返します。
     *
     * @return 前住所コード
     */
    public ZenkokuJushoCode get前住所コード() {
        return entity.get前住所コード();
    }

    /**
     * 住所2を返します。
     *
     * @return 住所2
     */
    public RString get住所2() {
        return entity.get住所2();
    }

    /**
     * 転入年月日を返します。
     *
     * @return 転入年月日
     */
    public FlexibleDate get転入年月日() {
        return entity.get転入年月日();
    }

    /**
     * 住所タイトル2を返します。
     *
     * @return 住所タイトル2
     */
    public RString get住所タイトル2() {
        return entity.get住所タイトル2();
    }

    /**
     * 転出年月日を返します。
     *
     * @return 転出年月日
     */
    public FlexibleDate get転出年月日() {
        return entity.get転出年月日();
    }

    /**
     * Noを返します。
     *
     * @return No
     */
    public RString getNo() {
        return entity.getNo();
    }

    /**
     * 適用年月日を返します。
     *
     * @return 適用年月日
     */
    public FillTypeFormatted get適用年月日() {
        return entity.get適用年月日();
    }

    /**
     * 適用届出年月日を返します。
     *
     * @return 適用届出年月日
     */
    public FillTypeFormatted get適用届出年月日() {
        return entity.get適用届出年月日();
    }

    /**
     * 他市町村住所地特例適用事由コードを返します。
     *
     * @return 他市町村住所地特例適用事由コード
     */
    public RString get他市町村住所地特例適用事由コード() {
        return entity.get他市町村住所地特例適用事由コード();
    }

    /**
     * 他市町村住所地特例適用事由名称を返します。
     *
     * @return 他市町村住所地特例適用事由名称
     */
    public RString get他市町村住所地特例適用事由名称() {
        return entity.get他市町村住所地特例適用事由名称();
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FillTypeFormatted get解除年月日() {
        return entity.get解除年月日();
    }

    /**
     * 解除届出年月日を返します。
     *
     * @return 解除届出年月日
     */
    public FillTypeFormatted get解除届出年月日() {
        return entity.get解除届出年月日();
    }

    /**
     * 他市町村住所地特例解除事由コードを返します。
     *
     * @return 他市町村住所地特例解除事由コード
     */
    public RString get他市町村住所地特例解除事由コード() {
        return entity.get他市町村住所地特例解除事由コード();
    }

    /**
     * 他市町村住所地特例解除事由名称を返します。
     *
     * @return 他市町村住所地特例解除事由名称
     */
    public RString get他市町村住所地特例解除事由名称() {
        return entity.get他市町村住所地特例解除事由名称();
    }

    /**
     * 入所年月日を返します。
     *
     * @return 入所年月日
     */
    public FillTypeFormatted get入所年月日() {
        return entity.get入所年月日();
    }

    /**
     * 退所年月日を返します。
     *
     * @return 退所年月日
     */
    public FillTypeFormatted get退所年月日() {
        return entity.get退所年月日();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.get事業者名称();
    }

    /**
     * 事業者住所を返します。
     *
     * @return 事業者住所
     */
    public RString get事業者住所() {
        return entity.get事業者住所();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.get電話番号();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.get郵便番号();
    }

    /**
     * 保険者名称を返します。
     *
     * @return 保険者名称
     */
    public RString get保険者名称() {
        return entity.get保険者名称();
    }

    /**
     * 他被保番号を返します。
     *
     * @return 他被保番号
     */
    public HihokenshaNo get他被保番号() {
        return entity.get他被保番号();
    }

}
