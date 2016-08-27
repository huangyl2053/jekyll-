package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBA-0060-010 dongyabin
 */
public interface IServiceCodeInputCommonChildDiv extends ICommonChildDivBaseProperties {

    /**
     * 画面を画面初期化します。
     */
    public void initialize();

    /**
     * サービスコード1を返します。
     *
     * @return サービスコード1
     */
    public RString getサービスコード1();

    /**
     * サービスコード2を返します。
     *
     * @return サービスコード2
     */
    public RString getサービスコード2();

    /**
     * サービス名称を返します。
     *
     * @return サービス名称
     */
    public RString getサービス名称();

    /**
     * サービス種類コードを返します。
     *
     * @param サービス種類コード RString
     */
    public void setサービス種類コード(RString サービス種類コード);

    /**
     * サービス項目コードを返します。
     *
     * @param サービス項目コード RString
     */
    public void setサービス項目コード(RString サービス項目コード);

    /**
     * サービス名称を返します。
     *
     * @param サービス名称 RString
     */
    public void setサービス名称(RString サービス名称);

    /**
     * 画面をクリアします。
     */
    public abstract void clear();
}
