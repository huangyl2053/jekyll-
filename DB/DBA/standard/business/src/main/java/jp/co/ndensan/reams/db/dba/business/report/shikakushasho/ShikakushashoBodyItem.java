/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護保険資格者証リスト一覧表情報です。
 * 
 * @reamsid_L DBU-0490-080  suguangjun
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakushashoBodyItem {

    private final RString subTitle;
    private final RString yukoKigen;
    private final RString hihokenshaNo;
    private final RString jusho;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString birthGengoMeiji;
    private final RString birthGengoTaisho;
    private final RString birthGengoShowa;
    private final RString seibetsu;
    private final RString birthYMD;
    private final RString kofuYMD;
    private final RString yokaigoJotaiKubun;
    private final RString ninteiYMD;
    private final RString yukoKaishiYMD;
    private final RString yukoShuryoYMD;
    private final RString kubunShikyuTanisu;
    private final RString kubunShikyuYukoKaishiYMD;
    private final RString kubunShikyuYukoShuryoYMD;
    private final RString kubunShikyuTaniShurui;
    private final RString kubunShikyuTani;
    private final List<RString> shuruiShikyuServiceName;
    private final List<RString> shuruiShikyuTnisu;
    private final List<RString> shuruiShikyuTani;
    private final RString serviceRyui;
    private final RString kyufuseigenNaiyo;
    private final RString kyufuseigenKaishiYMD;
    private final RString kyufuseigenShuryoYMD;

    private final RString keikakuJigyoshaName1;
    private final RString keikakuTodokedeYMD1;
    private final RString keikakuJigyoshaName2;
    private final RString shaName2Asutarisuku;
    private final RString keikakuJigyoshaName2Masshosen;
    private final RString keikakuTodokedeYMD2;
    private final RString keikakuTodokedeYMD2Asutarisuku;
    private final RString keikakuTodokedeYMD2Masshosen;
    private final RString keikakuJigyoshaName3;
    private final RString shaName3Asutarisuku;
    private final RString keikakuJigyoshaName3Masshosen;
    private final RString keikakuTodokedeYMD3;
    private final RString keikakuTodokedeYMD3Asutarisuku;
    private final RString keikakuTodokedeYMD3Masshosen;

    private final RString nyushoShisetsuShurui1;
    private final RString nyushoShisetsuName1;
    private final RString shisetsuNyusho1;
    private final RString shisetsuNyuin1;
    private final RString shisetsuNyushoYMD1;
    private final RString shisetsuTaisho1;
    private final RString shisetsuTaiin1;
    private final RString shisetsuTaishoYMD1;
    private final RString nyushoShisetsuShurui2;
    private final RString nyushoShisetsuName2;
    private final RString shisetsuNyusho2;
    private final RString shisetsuNyuin2;
    private final RString shisetsuNyushoYMD2;
    private final RString shisetsuTaisho2;
    private final RString shisetsuTaiin2;
    private final RString shisetsuTaishoYMD2;
    private final RString hokenshaNo;
    private final RString hokenshaJusho;
    private final RString hokenshaName;
    private final RString hokenshaTelno;
    private final RString remban;
    private final RString denshiKoin;

    /**
     * インスタンスを生成します。
     *
     * @param subTitle サブタイトル
     * @param yukoKigen 有効期限
     * @param hihokenshaNo 被保険者番号
     * @param jusho 被保険者住所
     * @param hihokenshaNameKana 被保険者フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param birthGengoMeiji 明治
     * @param birthGengoTaisho 大正
     * @param birthGengoShowa 昭和
     * @param seibetsu 性別
     * @param birthYMD 生年月日
     * @param kofuYMD 交付年月日
     * @param yokaigoJotaiKubun 要介護状態区分等
     * @param ninteiYMD 認定年月日
     * @param yukoKaishiYMD 認定の有効期間開始
     * @param yukoShuryoYMD 認定の有効期間終了
     * @param kubunShikyuTanisu 区分支給単位数
     * @param kubunShikyuYukoKaishiYMD 区分支給限度期間開始
     * @param kubunShikyuYukoShuryoYMD 区分支給限度期間終了
     * @param kubunShikyuTaniShurui 居宅サービス等の単位種類
     * @param kubunShikyuTani 居宅サービス等の単位
     * @param shuruiShikyuServiceName サービスの種類
     * @param shuruiShikyuTnisu サービス単位数
     * @param shuruiShikyuTani サービス単位
     * @param serviceRyui 認定審査会の意見及びサービスの種類
     * @param kyufuseigenNaiyo 給付制限の内容
     * @param kyufuseigenKaishiYMD 給付制限の開始年月日
     * @param kyufuseigenShuryoYMD 給付制限の終了年月日
     * @param keikakuJigyoshaName1 計画事業者名称1
     * @param keikakuTodokedeYMD1 事業所届出年月日1
     * @param keikakuJigyoshaName2 計画事業者名称2
     * @param shaName2Asutarisuku 計画事業者名称アスタリスク2
     * @param keikakuJigyoshaName2Masshosen 計画事業者名称取消2
     * @param keikakuTodokedeYMD2 事業所届出年月日2
     * @param keikakuTodokedeYMD2Asutarisuku 事業所届出年月日アスタリスク2
     * @param keikakuTodokedeYMD2Masshosen 事業所届出年月日取消2
     * @param shaName3Asutarisuku 計画事業者名称アスタリスク3
     * @param keikakuJigyoshaName3 計画事業者名称3
     * @param keikakuJigyoshaName3Masshosen 計画事業者名称取消3
     * @param keikakuTodokedeYMD3 事業所届出年月日3
     * @param keikakuTodokedeYMD3Asutarisuku 事業所届出年月日アスタリスク3
     * @param keikakuTodokedeYMD3Masshosen 事業所届出年月日取消3
     * @param nyushoShisetsuShurui1 介護保険施設等の種類1
     * @param nyushoShisetsuName1 介護保険施設等の名称1
     * @param shisetsuNyusho1 施設入所1
     * @param shisetsuNyuin1 施設入院1
     * @param shisetsuNyushoYMD1 介護保険施設等の入所年月日1
     * @param shisetsuTaisho1 施設退所1
     * @param shisetsuTaiin1 施設退院1
     * @param shisetsuTaishoYMD1 介護保険施設等の退所年月日１
     * @param nyushoShisetsuShurui2 介護保険施設等の種類2
     * @param nyushoShisetsuName2 介護保険施設等の名称2
     * @param shisetsuNyusho2 施設入所2
     * @param shisetsuNyuin2 施設入院2
     * @param shisetsuNyushoYMD2 介護保険施設等の入所年月日2
     * @param shisetsuTaisho2 施設退所2
     * @param shisetsuTaiin2 施設退院2
     * @param shisetsuTaishoYMD2 介護保険施設等の退所年月日２
     * @param hokenshaNo 保険者番号
     * @param hokenshaJusho 保険者住所
     * @param hokenshaName 保険者名称
     * @param hokenshaTelno 保険者電話番号
     * @param remban 連番
     * @param denshiKoin 電子公印
     */
    public ShikakushashoBodyItem(RString subTitle,
            RString yukoKigen,
            RString hihokenshaNo,
            RString jusho,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString birthGengoMeiji,
            RString birthGengoTaisho,
            RString birthGengoShowa,
            RString seibetsu,
            RString birthYMD,
            RString kofuYMD,
            RString yokaigoJotaiKubun,
            RString ninteiYMD,
            RString yukoKaishiYMD,
            RString yukoShuryoYMD,
            RString kubunShikyuTanisu,
            RString kubunShikyuYukoKaishiYMD,
            RString kubunShikyuYukoShuryoYMD,
            RString kubunShikyuTaniShurui,
            RString kubunShikyuTani,
            List<RString> shuruiShikyuServiceName,
            List<RString> shuruiShikyuTnisu,
            List<RString> shuruiShikyuTani,
            RString serviceRyui,
            RString kyufuseigenNaiyo,
            RString kyufuseigenKaishiYMD,
            RString kyufuseigenShuryoYMD,
            RString keikakuJigyoshaName1,
            RString keikakuTodokedeYMD1,
            RString keikakuJigyoshaName2,
            RString shaName2Asutarisuku,
            RString keikakuJigyoshaName2Masshosen,
            RString keikakuTodokedeYMD2,
            RString keikakuTodokedeYMD2Asutarisuku,
            RString keikakuTodokedeYMD2Masshosen,
            RString keikakuJigyoshaName3,
            RString shaName3Asutarisuku,
            RString keikakuJigyoshaName3Masshosen,
            RString keikakuTodokedeYMD3,
            RString keikakuTodokedeYMD3Asutarisuku,
            RString keikakuTodokedeYMD3Masshosen,
            RString nyushoShisetsuShurui1,
            RString nyushoShisetsuName1,
            RString shisetsuNyusho1,
            RString shisetsuNyuin1,
            RString shisetsuNyushoYMD1,
            RString shisetsuTaisho1,
            RString shisetsuTaiin1,
            RString shisetsuTaishoYMD1,
            RString nyushoShisetsuShurui2,
            RString nyushoShisetsuName2,
            RString shisetsuNyusho2,
            RString shisetsuNyuin2,
            RString shisetsuNyushoYMD2,
            RString shisetsuTaisho2,
            RString shisetsuTaiin2,
            RString shisetsuTaishoYMD2,
            RString hokenshaNo,
            RString hokenshaJusho,
            RString hokenshaName,
            RString hokenshaTelno,
            RString remban,
            RString denshiKoin) {
        this.subTitle = subTitle;
        this.yukoKigen = yukoKigen;
        this.hihokenshaNo = hihokenshaNo;
        this.jusho = jusho;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.birthGengoMeiji = birthGengoMeiji;
        this.birthGengoTaisho = birthGengoTaisho;
        this.birthGengoShowa = birthGengoShowa;
        this.seibetsu = seibetsu;
        this.birthYMD = birthYMD;
        this.kofuYMD = kofuYMD;
        this.yokaigoJotaiKubun = yokaigoJotaiKubun;
        this.ninteiYMD = ninteiYMD;
        this.yukoKaishiYMD = yukoKaishiYMD;
        this.yukoShuryoYMD = yukoShuryoYMD;
        this.kubunShikyuTanisu = kubunShikyuTanisu;
        this.shuruiShikyuTani = shuruiShikyuTani;
        this.kubunShikyuYukoKaishiYMD = kubunShikyuYukoKaishiYMD;
        this.kubunShikyuYukoShuryoYMD = kubunShikyuYukoShuryoYMD;
        this.kubunShikyuTaniShurui = kubunShikyuTaniShurui;
        this.kubunShikyuTani = kubunShikyuTani;
        this.shuruiShikyuServiceName = shuruiShikyuServiceName;
        this.shuruiShikyuTnisu = shuruiShikyuTnisu;
        this.serviceRyui = serviceRyui;
        this.kyufuseigenNaiyo = kyufuseigenNaiyo;
        this.kyufuseigenKaishiYMD = kyufuseigenKaishiYMD;
        this.kyufuseigenShuryoYMD = kyufuseigenShuryoYMD;
        this.keikakuJigyoshaName1 = keikakuJigyoshaName1;
        this.keikakuTodokedeYMD1 = keikakuTodokedeYMD1;
        this.keikakuJigyoshaName2 = keikakuJigyoshaName2;
        this.shaName2Asutarisuku = shaName2Asutarisuku;
        this.keikakuJigyoshaName2Masshosen = keikakuJigyoshaName2Masshosen;
        this.keikakuTodokedeYMD2 = keikakuTodokedeYMD2;
        this.keikakuTodokedeYMD2Asutarisuku = keikakuTodokedeYMD2Asutarisuku;
        this.keikakuTodokedeYMD2Masshosen = keikakuTodokedeYMD2Masshosen;
        this.keikakuJigyoshaName3 = keikakuJigyoshaName3;
        this.shaName3Asutarisuku = shaName3Asutarisuku;
        this.keikakuJigyoshaName3Masshosen = keikakuJigyoshaName3Masshosen;
        this.keikakuTodokedeYMD3 = keikakuTodokedeYMD3;
        this.keikakuTodokedeYMD3Asutarisuku = keikakuTodokedeYMD3Asutarisuku;
        this.keikakuTodokedeYMD3Masshosen = keikakuTodokedeYMD3Masshosen;
        this.nyushoShisetsuShurui1 = nyushoShisetsuShurui1;
        this.nyushoShisetsuName1 = nyushoShisetsuName1;
        this.shisetsuNyusho1 = shisetsuNyusho1;
        this.shisetsuNyuin1 = shisetsuNyuin1;
        this.shisetsuNyushoYMD1 = shisetsuNyushoYMD1;
        this.shisetsuTaisho1 = shisetsuTaisho1;
        this.shisetsuTaiin1 = shisetsuTaiin1;
        this.shisetsuTaishoYMD1 = shisetsuTaishoYMD1;
        this.nyushoShisetsuShurui2 = nyushoShisetsuShurui2;
        this.nyushoShisetsuName2 = nyushoShisetsuName2;
        this.shisetsuNyusho2 = shisetsuNyusho2;
        this.shisetsuNyuin2 = shisetsuNyuin2;
        this.shisetsuNyushoYMD2 = shisetsuNyushoYMD2;
        this.shisetsuTaisho2 = shisetsuTaisho2;
        this.shisetsuTaiin2 = shisetsuTaiin2;
        this.shisetsuTaishoYMD2 = shisetsuTaishoYMD2;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaJusho = hokenshaJusho;
        this.hokenshaName = hokenshaName;
        this.hokenshaTelno = hokenshaTelno;
        this.remban = remban;
        this.denshiKoin = denshiKoin;
    }
}
