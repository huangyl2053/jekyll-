/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho.KyufuseigenDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho.NyushoShisetsuDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho.ShuruiShikyuGendoKizyunngakuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護保険資格者証リスト一覧表情報です。
 *
 * @reamsid_L DBU-0490-080 suguangjun
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
    private final List<ShuruiShikyuGendoKizyunngakuEntity> shuruiShikyuGendoEntity;
    private final RString serviceRyui;
    private final List<KyufuseigenDataEntity> kyufuseigenEntity;
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
    private final List<NyushoShisetsuDataEntity> nyushoShisetsuEntity;
    private final RString shisetsuNyusho;
    private final RString shisetsuNyuin;
    private final RString shisetsuTaisho;
    private final RString shisetsuTaiin;
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
     * @param shuruiShikyuGendoEntity うち種類支給限度基準額
     * @param serviceRyui 認定審査会の意見及びサービスの種類
     * @param kyufuseigenEntity 給付制限
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
     * @param nyushoShisetsuEntity 介護保険施設等
     * @param keikakuTodokedeYMD3Masshosen 事業所届出年月日取消3
     * @param shisetsuNyusho 施設入所1
     * @param shisetsuNyuin 施設入院1
     * @param shisetsuTaisho 施設退所1
     * @param shisetsuTaiin 施設退院1
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
            List<ShuruiShikyuGendoKizyunngakuEntity> shuruiShikyuGendoEntity,
            RString serviceRyui,
            List<KyufuseigenDataEntity> kyufuseigenEntity,
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
            List<NyushoShisetsuDataEntity> nyushoShisetsuEntity,
            RString shisetsuNyusho,
            RString shisetsuNyuin,
            RString shisetsuTaisho,
            RString shisetsuTaiin,
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
        this.shuruiShikyuGendoEntity = shuruiShikyuGendoEntity;
        this.kubunShikyuYukoKaishiYMD = kubunShikyuYukoKaishiYMD;
        this.kubunShikyuYukoShuryoYMD = kubunShikyuYukoShuryoYMD;
        this.kubunShikyuTaniShurui = kubunShikyuTaniShurui;
        this.kubunShikyuTani = kubunShikyuTani;
        this.serviceRyui = serviceRyui;
        this.kyufuseigenEntity = kyufuseigenEntity;
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
        this.nyushoShisetsuEntity = nyushoShisetsuEntity;
        this.shisetsuNyusho = shisetsuNyusho;
        this.shisetsuNyuin = shisetsuNyuin;
        this.shisetsuTaisho = shisetsuTaisho;
        this.shisetsuTaiin = shisetsuTaiin;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaJusho = hokenshaJusho;
        this.hokenshaName = hokenshaName;
        this.hokenshaTelno = hokenshaTelno;
        this.remban = remban;
        this.denshiKoin = denshiKoin;
    }
}
