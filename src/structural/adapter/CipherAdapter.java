package structural.adapter;
public class CipherAdapter implements ModernSecurity {
    private LegacyCipher legacyCipher;
    public CipherAdapter(LegacyCipher lc) { this.legacyCipher = lc; }

    @Override
    public void encryptData() {
        System.out.print("Адаптер перенаправляє запит: ");
        legacyCipher.useOldEncryption();
    }
}